package com.putrapebrianonurba.equran.di

import android.app.Application
import androidx.room.Room
import com.putrapebrianonurba.equran.data.local.database.EQuranDatabase
import com.putrapebrianonurba.equran.data.local.database.dao.BookmarkDao
import com.putrapebrianonurba.equran.data.local.database.dao.DuaDao
import com.putrapebrianonurba.equran.data.local.database.dao.PrayersDao
import com.putrapebrianonurba.equran.data.local.database.dao.SearchDao
import com.putrapebrianonurba.equran.data.local.database.dao.SurahDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // DATABASE PROVIDERS
    @Provides
    @Singleton
    fun provideEQuranDatabase(app: Application): EQuranDatabase {
        return Room.databaseBuilder(
            app,
            EQuranDatabase::class.java,
            "equran.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // DAO PROVIDERS
    @Provides
    fun provideQuranDao(
        database: EQuranDatabase
    ): SurahDao {
        return database.surahDao()
    }

    @Provides
    fun provideBookmarkDao(
        database: EQuranDatabase
    ): BookmarkDao {
       return database.bookmarkDao()
    }

    @Provides
    fun provideDuaDao(
        database: EQuranDatabase
    ): DuaDao {
        return database.duaDao()
    }

    @Provides
    fun provideSearchDao(
        database: EQuranDatabase
    ): SearchDao {
        return database.searchDao()
    }

    @Provides
    fun providePrayersDao(
        database: EQuranDatabase
    ): PrayersDao {
        return database.prayersDao()
    }
}