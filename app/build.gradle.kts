plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.coins"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.coins"
        minSdk = 29
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {


//Room
    implementation(libs.room)
// Кодогенератор Room
    ksp(libs.room.compiler)
// optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)
//Retrofit
    implementation(libs.retrofit)
//Gson
    implementation(libs.gson)
//WorkManager
    implementation(libs.work.manager)
// Picasso
    implementation(libs.picasso)
//ViewModel
    implementation(libs.viewModel)
//LiveData
    implementation(libs.liveData)
// Annotation processor
    ksp(libs.liveDataCompiler)
// optional - ReactiveStreams support for LiveData
    implementation(libs.reactiveStreams)
//OkHttpClient- не обязательна
    implementation(libs.okHttpClient)
//HttpLoggingInterceptor- не обязательна
    implementation(libs.httpLoggingInterceptor)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}