plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.6.10"
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-core:1.6.7")
                implementation("io.ktor:ktor-client-serialization:1.6.7")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")
                implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.10")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
                implementation("co.touchlab:stately-common:1.2.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
                implementation("com.squareup.sqldelight:runtime:1.5.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-android:1.6.7")
                implementation("com.squareup.sqldelight:android-driver:1.5.3")
            }
        }
        val androidTest by getting{
            dependencies {
                implementation("androidx.test:runner:1.4.0")
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting{
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.7")
                implementation("com.squareup.sqldelight:native-driver:1.5.3")
            }
        }
        val iosArm64Main by getting{
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.7")
                implementation("com.squareup.sqldelight:native-driver:1.5.3")

            }
        }
        val iosSimulatorArm64Main by getting{
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.7")
                implementation("com.squareup.sqldelight:native-driver:1.5.3")

            }
        }



        val iosMain by creating {

            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}