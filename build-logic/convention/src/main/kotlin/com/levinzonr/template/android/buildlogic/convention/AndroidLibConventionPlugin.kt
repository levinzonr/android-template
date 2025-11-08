package com.levinzonr.template.android.buildlogic.convention

import com.android.build.gradle.LibraryExtension
import com.levinzonr.template.android.buildlogic.convention.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                compileSdk = AndroidConfiguration.COMPILE_SDK
                defaultConfig {
                    minSdk = AndroidConfiguration.MIN_SDK
                }
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}
