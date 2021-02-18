plugins {
    kotlin("multiplatform") version "1.4.30"
//    id("com.android.library")
    id("maven-publish")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

group = "me.bradyaiello"
version = "1.0.2"

repositories {
    google()
    jcenter()
    mavenCentral()
}

kotlin {
//    android()
    iosX64 {
        binaries {
            framework {
                baseName = "BestMobileOS"
            }
        }
    }
    iosArm64 {
        binaries {
            framework {
                baseName = "BestMobileOS"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val iosMain = maybeCreate("iosMain").apply {
            dependsOn(commonMain)
        }

        val iosX64Main = maybeCreate("iosX64Main").apply {
            dependsOn(iosMain)
        }
        val iosArm64Main = maybeCreate("iosArm64Main").apply {
            dependsOn(iosMain)
        }
    }
}

//android {
//    compileSdkVersion(29)
//    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    defaultConfig {
//        minSdkVersion(24)
//        targetSdkVersion(30)
//    }
//}

multiplatformSwiftPackage {
    packageName("BestMobileOS")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("11") }
    }
    outputDirectory(File(projectDir, "../BestMobileOSPackage"))
}