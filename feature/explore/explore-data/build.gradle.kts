plugins {
    alias(libs.plugins.base.conf)
}

android.namespace = "dev.yummy.explore_data"

dependencies {
    implementation(projects.feature.explore.exploreDomain)
}