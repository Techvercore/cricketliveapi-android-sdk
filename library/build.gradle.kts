plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace   = "com.cricketliveapi.sdk"
    compileSdk  = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    api(libs.retrofit.core)
    api(libs.retrofit.gson)
    api(libs.okhttp.core)
    api(libs.okhttp.logging)
    api(libs.gson)
    api(libs.coroutines.android)
}