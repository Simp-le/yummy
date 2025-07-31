pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "Yummy"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":core")
include(":core:common")
include(":core:ui")
include(":feature")
include(":feature:onboarding")
include(":feature:onboarding:onboarding-domain")
include(":feature:onboarding:onboarding-presentation")
include(":feature:profile")
include(":feature:profile:profile-data")
include(":feature:profile:profile-domain")
include(":feature:profile:profile-presentation")
include(":feature:explore")
include(":feature:explore:explore-data")
include(":feature:explore:explore-domain")
include(":feature:explore:explore-presentation")
include(":feature:recipe")
include(":feature:recipe:recipe-data")
include(":feature:recipe:recipe-domain")
include(":feature:recipe:recipe-presentation")
