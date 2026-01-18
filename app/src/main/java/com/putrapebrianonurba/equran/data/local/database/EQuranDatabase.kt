package com.putrapebrianonurba.equran.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.putrapebrianonurba.equran.data.converters.SurahConverters
import com.putrapebrianonurba.equran.data.local.database.dao.BookmarkDao
import com.putrapebrianonurba.equran.data.local.database.dao.DuaDao
import com.putrapebrianonurba.equran.data.local.database.dao.PrayersDao
import com.putrapebrianonurba.equran.data.local.database.dao.SearchDao
import com.putrapebrianonurba.equran.data.local.database.dao.SurahDao
import com.putrapebrianonurba.equran.data.local.database.entity.dua.DuaEntity
import com.putrapebrianonurba.equran.data.local.database.entity.history.SearchEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.CitiesEntity
import com.putrapebrianonurba.equran.data.local.database.entity.prayers.PrayerScheduleEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.AyahsEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.BookmarkEntity
import com.putrapebrianonurba.equran.data.local.database.entity.surah.SurahEntity

@Database(
    entities = [
        SurahEntity::class,
        DuaEntity::class,
        BookmarkEntity::class,
        AyahsEntity::class,
        SearchEntity::class,
        CitiesEntity::class,
        PrayerScheduleEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(SurahConverters::class)
abstract class EQuranDatabase: RoomDatabase() {
    abstract fun surahDao(): SurahDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun duaDao(): DuaDao
    abstract fun searchDao(): SearchDao
    abstract fun prayersDao(): PrayersDao
}