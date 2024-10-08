plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.ksp)
}

android {
    namespace = "com.example.commontemplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.commontemplate"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"

    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }


    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    //Koin
    implementation (libs.koin.android)
    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // Room
    implementation (libs.androidx.room.runtime)
    ksp (libs.room.compiler)
    implementation (libs.room.ktx)

    //Glide
    implementation (libs.glide)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}