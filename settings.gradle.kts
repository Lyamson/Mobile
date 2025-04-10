pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lesson9"
include(":app")
include(":movieproject")
include(":data")
include(":domain")
include(":scrollviewapp")
include(":listviewapp")
include(":listviewapp2")
include(":retrofitapp")
include(":fragmentapp")
include(":fragmentmanagerapp")
include(":resultapifragmentapp")
