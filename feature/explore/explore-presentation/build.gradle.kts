plugins {
    alias(libs.plugins.compose.conf)
}

android.namespace = "dev.yummy.explore_presentation"

dependencies {
    implementation(projects.feature.explore.exploreDomain)
}