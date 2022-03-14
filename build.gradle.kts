buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://jetbrains.bintray.com/intellij-third-party-dependencies")

    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
    }
}
plugins {
    id ("com.android.application") version "7.1.2" apply false
    id ("com.android.library") version "7.1.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
//    id("org.jetbrains.compose") version "1.1.1" apply false
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}