//buildscript {
//    repositories {
//        gradlePluginPortal()
//        google()
//        mavenCentral()
//
//    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
//        classpath("com.android.tools.build:gradle:7.1.2")
//    }
//}
plugins {
    id ("com.android.application") version "7.1.2" apply false
    id ("com.android.library") version "7.1.2" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id ("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
    id("org.jetbrains.compose") version "1.1.1" apply false
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