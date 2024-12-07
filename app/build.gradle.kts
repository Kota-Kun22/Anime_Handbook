plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt") // Apply kapt plugin

//  id("dagger.hilt.android.plugin")
    alias(libs.plugins.hilt.android)

//   id ("kotlinx-serialization")
    alias(libs.plugins.kotlinx.serialization)

//    id("com.google.devtools.ksp")
    alias(libs.plugins.ksp)

}

android {
    namespace = "com.example.anime_handbook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.anime_handbook"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Compose Navigation
    implementation(libs.androidx.navigation.compose)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    // Paging 3.0
    implementation(libs.androidx.paging.compose)
    // KotlinX Serialization
    implementation(libs.kotlinx.serialization.json)
    // DataStore Preferences
    implementation(libs.androidx.datastore.preferences)
    // Hilt
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    // Coil
    implementation(libs.coil.compose)
    // Room
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    ksp(libs.androidx.room.compiler.v250)
    implementation(libs.room.ktx)
    // Palette API
    implementation (libs.androidx.palette.ktx)

// Testing
    androidTestImplementation (libs.androidx.runner)
    androidTestImplementation (libs.androidx.rules)
    androidTestImplementation(libs.androidx.junit.v113)
    androidTestImplementation (libs.ui.test.junit4)
    debugImplementation (libs.ui.test.manifest)
    testImplementation (libs.junit)
    testImplementation (libs.kotlin.test.junit)
    testImplementation (libs.kotlinx.coroutines.test)


}