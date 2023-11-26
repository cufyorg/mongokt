plugins {
    `maven-publish`

    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":coroutines"))

                implementation(kotlin("stdlib"))
                implementation(kotlin("reflect"))

                implementation(libs.bson)
                implementation(libs.kped.bson)

                implementation(libs.kotlin.serialization.json)
                implementation(libs.kotlin.coroutines.core)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        jvmMain {
            dependencies {
                implementation("org.cufy:weakness:1.0.0")
            }
        }
    }
}
