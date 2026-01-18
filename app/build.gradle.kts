plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    id("kotlin-kapt")

}

android {
    namespace = "com.putrapebrianonurba.equran"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.putrapebrianonurba.equran"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField(
            "String",
            "BASE_URL_QURAN",
            "\"${project.properties["BASE_URL_QURAN_DEBUG"]}\""
        )
        buildConfigField(
            "String",
            "BASE_URL_DUA",
            "\"${project.properties["BASE_URL_DUA_DEBUG"]}\""
        )
        buildConfigField(
            "String",
            "BASE_URL_PRAYERS",
            "\"${project.properties["BASE_URL_PRAYERS_DEBUG"]}\""
        )
    }

    signingConfigs {
        create("release") {
            storeFile = file("keystore/equran_keystore.jks")
            storePassword = "password"
            keyAlias = "equran"
            keyPassword = "password"
        }
    }

    buildTypes {
        debug {
            buildConfigField(
                "String",
                "BASE_URL_QURAN",
                "\"${project.properties["BASE_URL_QURAN_DEBUG"]}\""
            )
            buildConfigField(
                "String",
                "BASE_URL_DUA",
                "\"${project.properties["BASE_URL_DUA_DEBUG"]}\""
            )
            buildConfigField(
                "String",
                "BASE_URL_PRAYERS",
                "\"${project.properties["BASE_URL_PRAYERS_DEBUG"]}\""
            )
        }

        release {
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BASE_URL_QURAN",
                "\"${project.properties["BASE_URL_QURAN_RELEASE"]}\""
            )
            buildConfigField(
                "String",
                "BASE_URL_DUA",
                "\"${project.properties["BASE_URL_DUA_RELEASE"]}\""
            )
            buildConfigField(
                "String",
                "BASE_URL_PRAYERS",
                "\"${project.properties["BASE_URL_PRAYERS_RELEASE"]}\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)
    implementation(libs.androidx.core.splashscreen)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}