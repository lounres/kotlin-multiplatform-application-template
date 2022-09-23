@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
//                freeCompilerArgs = listOf("...")
            }
        }
        testRuns.all {
            executionTask {
                useJUnitPlatform()
            }
        }
    }

    js(IR) {
        browser()
        nodejs()
        binaries.executable()
    }

    linuxX64()
    mingwX64()
    macosX64()

    sourceSets {
        all {
            languageSettings {
                progressiveMode = true
                optIn("kotlin.contracts.ExperimentalContracts")
            }
        }
        val commonMain by getting {
            dependencies {
//                implementation(...)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}