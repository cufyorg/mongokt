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
                implementation(project(":bsonkt"))

                implementation(kotlin("stdlib"))
                implementation(kotlin("reflect"))

                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        jvmMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.reactive)

                implementation(libs.mongodb.sync)
                implementation(libs.mongodb.reactivestreams)
            }
        }
    }
}
