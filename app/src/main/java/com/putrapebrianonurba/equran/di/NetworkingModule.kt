package com.putrapebrianonurba.equran.di

import com.putrapebrianonurba.equran.BuildConfig
import com.putrapebrianonurba.equran.data.remote.api.DuaApi
import com.putrapebrianonurba.equran.data.remote.api.PrayersApi
import com.putrapebrianonurba.equran.data.remote.api.SurahApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {
    // NETWORKING PROVIDERS
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if(BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()
    }

    @Provides
    @Singleton
    @QuranRetrofit
    fun provideQuranRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_QURAN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    @DuaRetrofit
    fun provideDuaRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_DUA)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    @PrayersRetrofit
    fun providePrayersRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_PRAYERS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    // API PROVIDERS
    @Provides
    fun provideQuranApi(
        @QuranRetrofit quranRetrofit: Retrofit
    ): SurahApi {
        return quranRetrofit.create(SurahApi::class.java)
    }

    @Provides
    fun provideDuaApi(
        @DuaRetrofit duaRetrofit: Retrofit
    ): DuaApi {
        return duaRetrofit.create(DuaApi::class.java)
    }

    @Provides
    fun providePrayersApi(
        @PrayersRetrofit prayersApi: Retrofit
    ): PrayersApi {
        return prayersApi.create(PrayersApi::class.java)
    }
}