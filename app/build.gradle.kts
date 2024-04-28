plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.pixelpatch.movieland"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pixelpatch.movieland"
        minSdk = 21
        targetSdk = 33
        versionCode = 5
        versionName = "5.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation (libs.appcompat)
    implementation (libs.material)
    implementation (libs.constraintlayout)
    testImplementation (libs.junit)
    androidTestImplementation (libs.ext.junit)
    androidTestImplementation (libs.espresso.core)
    implementation (libs.core.ktx)
    implementation (libs.appcompat)
    implementation (libs.material)
    implementation (libs.constraintlayout)
    implementation (libs.navigation.fragment.ktx)
    implementation (libs.navigation.ui.ktx)
    testImplementation (libs.junit)
    androidTestImplementation (libs.ext.junit)
    androidTestImplementation (libs.espresso.core)

    implementation (libs.gson)
    implementation (libs.volley)
    implementation (libs.junit.ktx)
    implementation (libs.lifecycle.extensions)
    implementation(libs.retrofit2)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)
    implementation (libs.picasso)

    implementation (libs.jackson.annotations)
    implementation (libs.material)
    implementation (libs.play.services.ads)

    implementation(files("libs/YouTubeAndroidPlayerApi.jar"))

}