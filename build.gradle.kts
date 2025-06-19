plugins {
  kotlin("multiplatform") version "2.1.21"
  id("com.apollographql.apollo") version "5.0.0-SNAPSHOT"
}

repositories {
  mavenLocal()
//    maven {
//        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//    }
  mavenCentral()
}

kotlin {
  compilerOptions {
    freeCompilerArgs.add("-Xskip-prerelease-check")
  }

  if (System.getProperty("os.arch") == "aarch64") {
    macosArm64 {
      binaries {
        executable()
      }
    }
  } else {
    macosX64 {
      binaries {
        executable()
      }
    }
  }

  js(IR) {
    browser {
      binaries.executable()
    }
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation("com.apollographql.apollo:apollo-runtime")
        implementation("com.apollographql.apollo:apollo-normalized-cache")
//        implementation("com.apollographql.apollo3:apollo-normalized-cache-sqlite")
      }
    }
    commonTest {
      dependencies {
        implementation(kotlin("test"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")
      }
    }
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
    introspection {
      endpointUrl.set("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
      schemaFile.set(file("src/commonMain/graphql/schema.graphqls"))
    }
  }
}

// `./gradlew macosArm64Test` (or `macosX64Test` for Intel Mac) or to run native tests
// `./gradlew assemble && ./build/bin/macosArm64/debugExecutable/apollo-kotlin-template-mpp.kexe` (or `macosX64` for Intel Mac) to run native app
// `./gradlew jsTest` to run js tests
// `./gradlew jsRun` to run js app
