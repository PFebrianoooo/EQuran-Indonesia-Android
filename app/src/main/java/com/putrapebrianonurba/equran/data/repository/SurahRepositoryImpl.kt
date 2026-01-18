package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.data.local.source.SurahLocalDataSource
import com.putrapebrianonurba.equran.data.mappers.surah.toAyahEntity
import com.putrapebrianonurba.equran.data.mappers.surah.toDomain
import com.putrapebrianonurba.equran.data.mappers.surah.toEntity
import com.putrapebrianonurba.equran.data.remote.source.SurahRemoteDataSource
import com.putrapebrianonurba.equran.domain.model.quran.Surah
import com.putrapebrianonurba.equran.domain.repository.SurahRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val remoteSource: SurahRemoteDataSource,
    private val localSource: SurahLocalDataSource
): SurahRepository {
    override suspend fun getAllSurah(): Flow<Resource<List<Surah>>> {
        return flow {
            emit(Resource.Loading(true))

            val localData = localSource.getAllSurah()
            if(localData.isNotEmpty()) {
                emit(Resource.Success(data = localData.map { it.toDomain() }))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteData = try {
                remoteSource.fetchAllSurah().data
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: Exception"))
                return@flow
            }

            val entityData = remoteData.map { it.toEntity() }
            localSource.upsertAllSurah(entityData)

            emit(Resource.Success(data = localSource.getAllSurah().map { it.toDomain() }))
            emit(Resource.Loading(false))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSurahById(id: Int): Flow<Resource<Surah>> {
        return flow {
            emit(Resource.Loading(true))

            val localData = localSource.getSurahWithAyahsById(id)
            if (localData != null && localData.ayahs.isNotEmpty()) {
                emit(Resource.Success(data = localData.toDomain()))
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteData = try {
                remoteSource.fetchSurahById(id).data
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Surah: Exception"))
                return@flow
            }

            val surahEntity = remoteData.toEntity()
            val ayahEntity = remoteData.toAyahEntity()

            localSource.upsertSurahWithAyahs(surahEntity, ayahEntity)
            emit(Resource.Success(data = localSource.getSurahWithAyahsById(id)?.toDomain()))
            emit(Resource.Loading(false))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSurahByQuery(query: String): Flow<Resource<List<Surah>>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val localData = localSource.getSurahByQuery(query)
                emit(Resource.Success(localData.map { it.toDomain() }))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unknown Error"))
            } finally {
                emit(Resource.Loading(false))
            }
        }
    }
}