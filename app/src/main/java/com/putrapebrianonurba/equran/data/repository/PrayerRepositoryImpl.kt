package com.putrapebrianonurba.equran.data.repository

import com.putrapebrianonurba.equran.core.common.Resource
import com.putrapebrianonurba.equran.core.common.currentDate
import com.putrapebrianonurba.equran.data.local.source.PrayersLocalDataSource
import com.putrapebrianonurba.equran.data.mappers.prayers.toDomain
import com.putrapebrianonurba.equran.data.mappers.prayers.toEntity
import com.putrapebrianonurba.equran.data.remote.source.PrayersRemoteDataSource
import com.putrapebrianonurba.equran.domain.model.prayers.City
import com.putrapebrianonurba.equran.domain.model.prayers.PrayerSchedule
import com.putrapebrianonurba.equran.domain.repository.PrayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class PrayerRepositoryImpl @Inject constructor(
    private val remoteSource: PrayersRemoteDataSource,
    private val localSource: PrayersLocalDataSource
): PrayerRepository {
    override suspend fun getCities(): Flow<Resource<List<City>>> {
        return flow {
            emit(Resource.Loading(true))

            val local = localSource.getCities()
            if (local.isNotEmpty() && local.size > 1) {
                emit(Resource.Success(
                    data = local.map { it.toDomain() }
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            val remote = try {
                remoteSource.getAllCities()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Cities: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Cities: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Cities: Exception"))
                return@flow
            }

            val entity = remote.data.map { it.toEntity() }
            localSource.upsertCities(entity)

            emit(Resource.Success(
                data = localSource.getCities().map { it.toDomain() }
            ))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getCityById(cityId: Int): Flow<Resource<City>> {
        return flow {
            emit(Resource.Loading(true))

            val local = localSource.getCityById(cityId)
            if(local != null) {
                emit(Resource.Success(
                    data = local.toDomain()
                ))
                emit(Resource.Loading(false))
                return@flow
            }

            val remote = try {
                remoteSource.getCityById(cityId)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load City: IOException"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load City: HTTPException"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load City: Exception"))
                return@flow
            }

            val entity = remote.data.toEntity()
            localSource.upsertCities(listOf(entity))

            emit(Resource.Success(data = entity.toDomain()))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getPrayerSchedule(cityId: Int): Flow<Resource<PrayerSchedule>> {
        return flow {
            emit(Resource.Loading(true))

            val today = currentDate()

            val local = localSource.getSchedule(cityId, today)
            if (local != null) {
                emit(Resource.Success(data = local.toDomain()))
                emit(Resource.Loading(false))
                return@flow
            }

            val remote = try {
                remoteSource.getPrayersSchedule(cityId, today)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Schedule: IOException"))
                emit(Resource.Loading(false))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Schedule: HTTPException"))
                emit(Resource.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error When Load Schedule: Exception"))
                emit(Resource.Loading(false))
                return@flow
            }

            if (remote.status) {
                localSource.deleteOldPrayerSchedule(today)

                val entity = remote.data.schedule.toEntity(cityId)
                localSource.upsertPrayerSchedule(entity)

                emit(Resource.Success(entity.toDomain()))
            } else {
                emit(Resource.Success<PrayerSchedule>(null))
            }
                emit(Resource.Loading(false))
        }
    }
}