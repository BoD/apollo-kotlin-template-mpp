A simplistic sample project using [Apollo Kotlin](https://github.com/apollographql/apollo-kotlin) in
a [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) project on Kotlin `1.6.21`
with [the new memory manager](https://github.com/JetBrains/kotlin/blob/master/kotlin-native/NEW_MM.md).

This uses the Apollo Kotlin snapshots that support
the [Hierarchical Project Structure](https://kotlinlang.org/docs/multiplatform-hierarchy.html).

Works on Mac only.

- `./gradlew nativeTest` to run tests
- `./gradlew assemble && ./build/bin/native/debugExecutable/apollo-kotlin-template-mpp.kexe`
