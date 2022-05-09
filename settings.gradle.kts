rootProject.name = "apollo-kotlin-template-mpp"

pluginManagement {
    repositories {
//        mavenLocal()
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }
        gradlePluginPortal()
        mavenCentral()
    }
}
