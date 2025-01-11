// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    alias(libs.plugins.android.application) apply false

    alias(libs.plugins.jetbrains.kotlin.android) apply false

    //id("com.android.library") version "8.1.4" apply false
    alias(libs.plugins.android.library) apply false

    //id("com.google.dagger.hilt.android") version "2.45" apply false
    alias(libs.plugins.hilt.android) apply false


//    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    alias(libs.plugins.ksp) apply false


    kotlin("kapt") version "2.0.0"  // Specify version for kapt // Ensure kapt is applied for annotation processing

    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" // Ensure Compose is set up
}
