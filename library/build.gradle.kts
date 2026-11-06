plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId    = "com.github.Techvercore"
                artifactId = "cricketliveapi-android-sdk"
                version    = "1.0.0"
            }
        }
        repositories {
            maven {
                name = "GitHubPackages"
                url  = uri("https://maven.pkg.github.com/Techvercore/cricketliveapi-android-sdk")
                credentials {
                    username = System.getenv("GITHUB_ACTOR") ?: ""
                    password = System.getenv("GITHUB_TOKEN") ?: ""
                }
            }
        }
    }
}