plugins {
    kotlin("multiplatform") version "1.6.21"
    id("com.apollographql.apollo3") version "3.3.0"
}

group = "com.example.myapp"
version = "1.0.0-SNAPSHOT"

repositories {
    maven {
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
    mavenCentral()
}

kotlin {
    val nativeTarget = if (System.getProperty("os.arch") == "aarch64") {
        macosArm64("native")
    } else {
        macosX64("native")
    }

    nativeTarget.apply {
        binaries {
            executable()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.apollographql.apollo3:apollo-runtime:3.3.0")
                implementation("com.apollographql.apollo3:apollo-testing-support:3.3.0")
                implementation("com.apollographql.apollo3:apollo-normalized-cache:3.3.0")
                implementation("com.apollographql.apollo3:apollo-normalized-cache-sqlite:3.3.0")

                // Make good use of the new memory manager - see https://github.com/JetBrains/kotlin/blob/master/kotlin-native/NEW_MM.md
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
            }
        }
        val commonTest by getting
    }
}

afterEvaluate {
    tasks.withType<AbstractTestTask> {
        testLogging {
            showStandardStreams = true
        }
    }
}

apollo {
    packageName.set("com.example.myapp")
}

// `./gradlew nativeTest` to run tests
// `./gradlew assemble && ./build/bin/native/debugExecutable/apollo-kotlin-template-mpp.kexe`
