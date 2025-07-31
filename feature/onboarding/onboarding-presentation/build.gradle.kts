plugins {
    alias(libs.plugins.compose.conf)
}

android.namespace = "dev.yummy.onboarding_presentation"

dependencies {
    implementation(projects.feature.onboarding.onboardingDomain)
}