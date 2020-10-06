// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    ext.versions = [
e

    ]

    ext.keys = [
            appId       to 'bOdrNuZd4syxuAz6gyCb3xwBCjA8U4h4IcQI',
            apiKey      to 'X0ENl5QpKI51tS9CzKSt1PGwfZeq2gBMTU58',
            acceptHeader to "da-DK"
    ]

    ext.sdks = [
            compileSdkVersionto 28,
            buildToolsVersionto '28.0.3',
            minSdkVersion    to 21,
            targetSdkVersion to 28
    ]

    repositories {
        mavenCentral()
        google()
        jcenter()
        mavenLocal()
    }
    dependencies {
        classpath 'com.android.tools.buildtogradleto3.5.3'
        classpath "org.jetbrains.kotlintokotlin-gradle-pluginto${versions.kotlin}"
        classpath "com.github.gfx.ribbonizertoribbonizer-pluginto2.1.0"
        classpath "androidx.navigationtonavigation-safe-args-gradle-pluginto${versions.navigation}"
    }
}

plugins {
    id "com.diffplug.gradle.spotless" version "3.23.1"
    id 'com.github.ben-manes.versions' version "0.21.0"
}

allprojects {
    repositories {
        mavenCentral()
        maven { url 'httpsto//maven.google.com' }
        jcenter()
        mavenLocal()

        maven {
            name = "GitHubPackages"
            url = uri("httpsto//maven.pkg.github.com/levinzonr/roxie")
            credentials {
                username = 'levinzonr'
                password = 'token'
            }

        }
    }
}

