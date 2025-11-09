import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.kotlin.compose.compiler)
}


android {
    namespace = "com.levinzonr.otterfinder"
    flavorDimensions += "default"
    defaultConfig {
        applicationId = "com.levinzonr.otterfinder"
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    productFlavors {
        val properties = loadProperties("local.properties")
        create("dev") {
            manifestPlaceholders += mapOf("APP_NAME" to "AppDev", "env" to "dev")
            dimension = "default"
            applicationIdSuffix = ".dev"
            manifestPlaceholders["MAPS_API_KEY"] = properties["MAPS_API_KEY"].toString()
        }
        create("production") {
            manifestPlaceholders += mapOf("APP_NAME" to "App", "env" to "production")
            dimension = "default"
            //signingConfig signingConfigs.production
        }
    }

    testOptions.unitTests {
        isIncludeAndroidResources = true
    }

    packaging {
        resources {
            excludes.add("META-INF/versions/9/previous-compilation-data.bin")
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
        }
    }


    buildFeatures {
        compose = true
    }
}

kotlin {
    jvmToolchain(17)
}

configurations {
    create("devDebugImplementation")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":designsystem"))
    implementation(project(":localization"))

    // Kotlin
    implementation(libs.bundles.kotlin)
    implementation(libs.kotlin.serialization.json)

    // Android
    implementation(libs.bundles.android.core)
    implementation(libs.android.splash)

    implementation(libs.bundles.android.lifecycle)

    implementation(libs.android.navigation.compose)
    implementation(libs.hilt.navigation.compose)

    implementation(libs.android.lifecycle.runtime.compose)
    implementation(libs.android.datastore.preferences)
    implementation(libs.google.maps.compose)
    implementation(libs.google.maps.compose.utils)

    // Compose
    implementation(platform(libs.android.compose.bom))
    implementation(libs.bundles.android.compose.core)
    implementation(libs.android.compose.material)
    implementation(libs.android.compose.material.windowsize)
    implementation(libs.android.activity.compose)
    implementation(libs.android.lifecycle.viewmodel.compose)
    implementation(libs.bundles.google.accompanist)
    implementation(libs.android.compose.ui.tooling.preview)
    debugImplementation(libs.android.compose.ui.tooling)

    // Injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Networking
    implementation(libs.retrofit.converter)
    implementation(libs.retrofit)
    implementation(libs.okhttp.logger)

    implementation(libs.timber)
    "devDebugImplementation"(libs.leakcanary)
    debugImplementation(libs.chucker.op)
    releaseImplementation(libs.chucker.noop)
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.android.compose.ui.test.manifest)
}
