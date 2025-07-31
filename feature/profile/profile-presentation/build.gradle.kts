plugins {
    alias(libs.plugins.compose.conf)
}

android.namespace = "dev.yummy.profile_presentation"

dependencies {
    implementation(projects.feature.profile.profileDomain)
}