package com.putrapebrianonurba.equran.core.constants

import com.putrapebrianonurba.equran.R
import com.putrapebrianonurba.equran.domain.model.quran.BannerCarousel

object AppConstants {
    // ONBOARDING FEATURE
    const val ONBOARDING_WELCOMING_TITLE = "Al-Qur’an Teman\nSetiap Ibadah"
    const val ONBOARDING_SUMMARY_TITLE = "EQuran membantu Anda membaca, memahami, dan mendekatkan diri kepada Al-Qur’an kapan pun dibutuhkan."
    const val ONBOARDING_GET_STARTED_BUTTON_TITLE = "Mulai Sekarang"

    // PRAYER FEATURE
    const val PRAYER_CITIES_BANNER_TITLE = "Daftar Kota\nDi Indonesia"
    const val PRAYER_PRAYER_SCHEDULE_TITLE = "Jadwal Sholat"
    const val PRAYER_EMPTY_SCHEDULE_TITLE = "Tidak tidak ditemukan jadwal sholat"

    // QURAN FEATURE
    const val QURAN_BOOKMARK_BANNER_TITLE = "Daftar Surah\nYang Sudah Tersimpan"
    const val QURAN_BOOKMARK_EMPTY_SURAH_TITLE = "Belum ada surah yang ditambahkan!"
    const val QURAN_SEARCH_SURAH_UNAVAILABLE_TITLE = "Surah tidak ditemukan!"
    val QURAN_CAROUSEL_IMAGE_ITEMS = listOf(
        BannerCarousel(1, R.drawable.ic_carousel_1),
        BannerCarousel(2, R.drawable.ic_carousel_2),
        BannerCarousel(3, R.drawable.ic_carousel_3)
    )

    // SETTINGS
    const val APP_VERSION = "Versi 1.0"
    const val SETTINGS_TITLE = "Pengaturan"
    const val SETTINGS_APPLICATION_TITLE = "Pengaturan Aplikasi"
    const val SETTINGS_APPLICATION_THEME_TITLE = "Tema Gelap"
    const val SETTINGS_APPLICATION_THEME_SUMMARY = "Tampilan dengan warna gelap, cocok untuk pada malam hari atau tempat gelap"
    const val SETTINGS_QURAN_FEATURE_QORI_OPTIONS_TITLE = "Qori Murrotal"
    const val SETTINGS_DEVELOPER_TITLE = "Seputar Pengembang"
    const val SETTINGS_DEVELOPER_LINKEDIN_TITLE = "Mengenal Pengembang"
    const val SETTINGS_DEVELOPER_LINKEDIN_SUMMARY = "Yuk kepoin profil pengembang Aplikasi EQuran di LinkedIn"
    const val SETTINGS_DEVELOPER_LINKEDIN_LINK = "https://id.linkedin.com/in/putra-pebriano-nurba-754b9227b"
    const val SETTINGS_DEVELOPER_GITHUB_TITLE = "GitHub"
    const val SETTINGS_DEVELOPER_GITHUB_SUMMARY = "Lihat aktivitas yang dilakukan pengembang dan aplikasi lain yang telah dibuat"
    const val SETTINGS_DEVELOPER_GITHUB_LINK = "https://github.com/PFebrianoooo"
    const val SETTINGS_DEVELOPER_CONTRIBUTION_REPO_TITLE = "Berkontribusi"
    const val SETTINGS_DEVELOPER_CONTRIBUTION_REPO_SUMMARY = "Ayo kita sama-sama mengembangkan EQuran agar menjadi lebih baik"
    const val SETTINGS_DEVELOPER__CONTRIBUTION_REPO_LINK = "https://github.com/PFebrianoooo/EQuran-Indonesia-Android"

    // DUA FEATURE
    const val DUAS_TITLE = "Kumpulan Doa\nSehari-Hari"
    const val DUAS_TEST_TITLE = "Hafalan Doa\nSehari-Hari"
    const val DUAS_TEST_INFORMATION_TITLE = "Coba Bacakan\n"
    const val DUAS_TEST_ANSWER_TITLE = "Jawaban"
    const val DUAS_TEST_REFRESH_TITLE = "Jawaban"
}