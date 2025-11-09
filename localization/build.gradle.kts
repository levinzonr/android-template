
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.convention.android.library)
}


android {
    namespace = "com.levinzonr.otterfinder.localization"

}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.android.startup)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.android)
    androidTestImplementation(libs.espresso.core)
}