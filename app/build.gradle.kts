plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
   id("com.google.devtools.ksp") //room


}

android {
    namespace = "com.walid.noteapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.walid.noteapp"
        minSdk = 27
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
       kotlinCompilerExtensionVersion = "1.5.7"


    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core libraries

    implementation(libs.androidx.core.ktx) // Core KTX
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle KTX
    // Compose UI

    implementation(libs.androidx.activity.compose) // Compose integration with Activity
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM to align versions
    implementation(libs.androidx.ui) //  Core UI elements for Compose
    implementation(libs.androidx.ui.graphics) // UI / Graphics utilities for Compose UI
    implementation(libs.androidx.ui.tooling.preview) // Preview support for Compose
    implementation(libs.ui) // UI Core

    // Material Design

  //  implementation(libs.androidx.material3) // Material 3
    implementation(libs.androidx.material) // Material Design

    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)




    // Added hilt-navigation-compose to use hiltViewModel: Navigation with Hilt for ViewModel injection
    implementation(libs.androidx.hilt.navigation.compose)

    // Testing
    implementation(libs.androidx.ui.test.android)
    implementation(libs.common)
    implementation(libs.androidx.compose.material) // UI Test Android
    testImplementation(libs.junit) // JUnit
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit

    androidTestImplementation(platform(libs.androidx.compose.bom)) // Test BOM
    androidTestImplementation(libs.androidx.ui.test.junit4) // UI Test JUnit4

    // Debugging
    debugImplementation(libs.androidx.ui.tooling) // Tooling
    debugImplementation(libs.androidx.ui.test.manifest) // Test Manifest






    // Coroutines
    implementation( libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)



    // dagger hill
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)

// Hilt Navigation for ViewModel injection in fragments (optional)
    implementation( libs.androidx.hilt.navigation.fragment)

  //  room

    implementation(libs.androidx.room.runtime)
   ksp(libs.androidx.room.compiler)
    // Kotlin Extensions and Coroutines support for Room
    implementation (libs.androidx.room.ktx)


}

kapt {
    correctErrorTypes = true
}