plugins {
  kotlin("multiplatform") version "1.9.23"
  id("com.apollographql.apollo3") version "4.0.0-beta.5"
}

group = "com.example.myapp"
version = "1.0.0-SNAPSHOT"

repositories {
//    mavenLocal()
//    maven {
//        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//    }
  mavenCentral()
}

kotlin {
  if (System.getProperty("os.arch") == "aarch64") {
    macosArm64() {
      binaries {
        executable()
      }
    }
  } else {
    macosX64() {
      binaries {
        executable()
      }
    }
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation("com.apollographql.apollo3:apollo-runtime")
        implementation("com.apollographql.apollo3:apollo-normalized-cache")
        implementation("com.apollographql.apollo3:apollo-normalized-cache-sqlite")

        // Make good use of the new memory manager - see https://github.com/JetBrains/kotlin/blob/master/kotlin-native/NEW_MM.md
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
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
  service("service") {
    packageName.set("com.example.myapp")
  }
}

// `./gradlew macosArm64Test` (macosX64Test on intel) or to run tests
// `./gradlew assemble && ./build/bin/macosArm64/debugExecutable/apollo-kotlin-template-mpp.kexe` (or macosX64) to run executable
