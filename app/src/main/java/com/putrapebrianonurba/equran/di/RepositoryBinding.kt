package com.putrapebrianonurba.equran.di

import com.putrapebrianonurba.equran.data.repository.BookmarkRepositoryImpl
import com.putrapebrianonurba.equran.data.repository.DuaRepositoryImpl
import com.putrapebrianonurba.equran.data.repository.PrayerRepositoryImpl
import com.putrapebrianonurba.equran.data.repository.SearchRepositoryImpl
import com.putrapebrianonurba.equran.data.repository.SettingsRepositoryImpl
import com.putrapebrianonurba.equran.data.repository.SurahRepositoryImpl
import com.putrapebrianonurba.equran.domain.repository.BookmarkRepository
import com.putrapebrianonurba.equran.domain.repository.DuaRepository
import com.putrapebrianonurba.equran.domain.repository.PrayerRepository
import com.putrapebrianonurba.equran.domain.repository.SearchRepository
import com.putrapebrianonurba.equran.domain.repository.SettingsRepository
import com.putrapebrianonurba.equran.domain.repository.SurahRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBinding {
    // REPOSITORY BINDING
    @Binds
    @Singleton
    abstract fun bindSettingsRepository(
        impl: SettingsRepositoryImpl
    ): SettingsRepository

    @Binds
    @Singleton
    abstract fun bindDuaRepository(
        impl: DuaRepositoryImpl
    ): DuaRepository

    @Binds
    @Singleton
    abstract fun bindSurahRepository(
        impl: SurahRepositoryImpl
    ): SurahRepository

    @Binds
    @Singleton
    abstract fun bindBookmarkRepository(
        impl: BookmarkRepositoryImpl
    ): BookmarkRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(
        impl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    @Singleton
    abstract fun bindPrayersRepository(
        impl: PrayerRepositoryImpl
    ): PrayerRepository

}