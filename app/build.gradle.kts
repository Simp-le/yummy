plugins {
    alias(libs.plugins.app.conf)
}

android {
    testOptions { packaging.resources.excludes.add("META-INT/*") }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.feature.onboarding.onboardingDomain)
    implementation(projects.feature.onboarding.onboardingPresentation)
    implementation(projects.feature.profile.profileData)
    implementation(projects.feature.profile.profileDomain)
    implementation(projects.feature.profile.profilePresentation)
    implementation(projects.feature.explore.exploreData)
    implementation(projects.feature.explore.exploreDomain)
    implementation(projects.feature.explore.explorePresentation)
    implementation(projects.feature.recipe.recipeData)
    implementation(projects.feature.recipe.recipeDomain)
    implementation(projects.feature.recipe.recipePresentation)
}
