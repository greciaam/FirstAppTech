plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.firstapp"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        // targetSdk tidak perlu didefinisikan karena akan mengikuti compileSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.compose.material3:material3:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation ("androidx.navigation:navigation-compose:2.7.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation ("androidx.activity:activity-compose:1.7.2")
}