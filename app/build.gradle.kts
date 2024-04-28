plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.pixelpatch.movieland"
    compileSdk = libs.versions.compileSdk.get().toInt()

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.pixelpatch.movieland"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
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

        // Enable Coroutines and Flow APIs
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlinx.coroutines.FlowPreview"
    }
    buildFeatures {
        compose = true
        dataBinding = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources.excludes += "/META-INF/AL2.0"
        resources.excludes += "/META-INF/LGPL2.1"
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

    // Compose
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.compose.ui.tooling.preview)

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