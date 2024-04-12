A simplistic sample project using [Apollo Kotlin](https://github.com/apollographql/apollo-kotlin) in
a [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) project.

Targets native (MacOS) and JS (browser).

- `./gradlew macosArm64Test` (or `macosX64Test` for Intel Mac) or to run native tests
- `./gradlew assemble && ./build/bin/macosArm64/debugExecutable/apollo-kotlin-template-mpp.kexe` (or `macosX64` for Intel Mac) to run native
  app
- `./gradlew jsTest` to run js tests
- `./gradlew jsRun` to run js app
