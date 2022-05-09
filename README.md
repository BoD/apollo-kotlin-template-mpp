A simplistic sample project using [Apollo Kotlin](https://github.com/apollographql/apollo-kotlin) in
a [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) project on Kotlin `1.6.21`
with [the new memory manager](https://github.com/JetBrains/kotlin/blob/master/kotlin-native/NEW_MM.md).

This uses Apollo Kotlin 3.3.0, which supports
the [Hierarchical Project Structure](https://kotlinlang.org/docs/multiplatform-hierarchy.html). When using Kotlin ≥
1.6.20, this is enabled by default on projects, but for older versions of Kotlin, enable it explicitly by uncommenting
the 2 flags in `gradle.properties`.

When using Kotlin < 1.6.20, you will need to uncomment the workaround
for [issue KT-51970](https://youtrack.jetbrains.com/issue/KT-51970) in `build.gradle.kts`.

Works on Mac only.

- `./gradlew nativeTest` to run tests
- `./gradlew assemble && ./build/bin/native/debugExecutable/apollo-kotlin-template-mpp.kexe`
