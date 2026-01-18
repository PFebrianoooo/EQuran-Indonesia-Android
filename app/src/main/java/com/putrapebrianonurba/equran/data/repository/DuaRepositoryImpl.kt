package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.data.local.source.DuaLocalDataSource
import com.putrapebrianonurba.equran.data.mappers.dua.isFull
import com.putrapebrianonurba.equran.data.mappers.dua.toDomain
import com.putrapebrianonurba.equran.data.mappers.dua.toEntity
import com.putrapebrianonurba.equran.data.remote.source.DuaRemoteDataSource
import com.putrapebrianonurba.equran.domain.model.dua.Dua
import com.putrapebrianonurba.equran.domain.repository.DuaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class DuaRepositoryImpl @Inject constructor(
    private val remoteSource: DuaRemoteDataSource,
    private val localSource: DuaLocalDataSource
): DuaRepository {
    override suspend fun getDuas(): Flow<Resource<List<Dua>>> {
        return flow {
            emit(Resource.Loading(true))

            val localData = localSource.getDuas()
            if (localData.isNotEmpty() ) {
                emit(Resource.Success(data = localData.map { it.toDomain() }))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteData = try {
                remoteSource.fetchAllDuas()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Duas: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Duas: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Duas: Exception"))
                return@flow
            }

            val entityData = remoteData.let { duaDto ->
                duaDto.map { it.toEntity() }
            }
            localSource.upsertDuas(entityData)

            emit(Resource.Success(data = localSource.getDuas().map { it.toDomain() }))
            emit(Resource.Loading(false))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getDuaById(id: Int): Flow<Resource<Dua>> {
        return flow {
            emit(Resource.Loading(true))

            val localData = localSource.getDuaById(id)
            if (localData != null && localData.isFull()) {
                emit(Resource.Success(data = localData.toDomain()))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteData = try {
                remoteSource.fetchDuaById(id)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: Exception"))
                return@flow
            }

            val entityData = remoteData.first().toEntity()
            localSource.upsertDua(entityData)

            emit(Resource.Success(data = entityData.toDomain()))
            emit(Resource.Loading(false))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getRandomDua(): Flow<Resource<Dua>> {
        return flow {
            emit(Resource.Loading(true))

            val localData = localSource.getRandomDua()
            if (localData != null && localData.isFull()) {
                emit(Resource.Success(data = localData.toDomain()))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteData = try {
                localData?.id?.let { id ->
                    remoteSource.fetchDuaById(id)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Dua: Exception"))
                return@flow
            }


            val entityData = remoteData?.first().let { it?.toEntity() }
            entityData?.let { localSource.upsertDua(it) }

            emit(Resource.Success(data = entityData?.toDomain()))
            emit(Resource.Loading(false))
        }.flowOn(Dispatchers.IO)
    }
}