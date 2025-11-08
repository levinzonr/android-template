plugins {
    `kotlin-dsl`
}

group = "com.levinzonr.template.android.build-logic"


dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Register convention plugins so they are available in the build scripts of the application
     */
    plugins {
        register("conventionAndroidLib") {
            id = "convention.android.library"
            implementationClass = "com.levinzonr.template.android.buildlogic.convention.AndroidLibConventionPlugin"
        }

        register("conventionAndroidApp") {
            id = "convention.android.application"
            implementationClass = "com.levinzonr.template.android.buildlogic.convention.AndroidAppConventionPlugin"
        }

    }
}
