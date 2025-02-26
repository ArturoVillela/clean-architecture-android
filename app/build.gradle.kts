plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id ("kotlin-android")
    id ("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.firebaseapp.charlieandroidblog.cleanarchitectureexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.firebaseapp.charlieandroidblog.cleanarchitectureexample"
        minSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    val retrofitVersion = "2.11.0"  // optional to put a variable here

    implementation("androidx.compose.runtime:runtime:1.5.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.2")
    implementation ("androidx.fragment:fragment:1.4.1")

    implementation("com.google.dagger:hilt-android:2.55")
    kapt("com.google.dagger:hilt-compiler:2.55")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.55")
    androidTestAnnotationProcessor("com.google.dagger:hilt-compiler:2.55")
    testImplementation("com.google.dagger:hilt-android-testing:2.55")
    testAnnotationProcessor("com.google.dagger:hilt-compiler:2.55")



    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}