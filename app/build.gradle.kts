plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "me.hd.ggtutorial"
    compileSdk = 34

    defaultConfig {
        applicationId = "me.hd.ggtutorial"
        minSdk = 21
        targetSdk = 34
        versionCode = 20241109
        versionName = "1.0.5"
        buildConfigField("String", "TAG", "\"GGTutorial\"")

        ndk {
            abiFilters.apply {
                add("arm64-v8a")
            }
        }
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.navigation.fragment.ktx3)
    implementation(libs.flexbox)
}