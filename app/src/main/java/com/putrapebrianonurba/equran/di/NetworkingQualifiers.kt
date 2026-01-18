package com.putrapebrianonurba.equran.di

import javax.inject.Qualifier

// QUALIFIER FOR QURAN FEATURE API
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QuranRetrofit

// QUALIFIER FOR DUA FEATURE API
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DuaRetrofit

// QUALIFIER FOR DUA FEATURE API
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PrayersRetrofit