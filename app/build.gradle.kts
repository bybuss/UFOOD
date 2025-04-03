plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "bob.colbaskin.ufood"
    compileSdk = 35

    defaultConfig {
        applicationId = "bob.colbaskin.ufood"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(projects.feature.main.presentation)
    implementation(projects.feature.main.data)
    implementation(projects.feature.onboarding.data)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    api(libs.androidx.compose.runtime)
}
