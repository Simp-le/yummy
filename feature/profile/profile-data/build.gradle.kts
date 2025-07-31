plugins {
    alias(libs.plugins.base.conf)
}

android.namespace = "dev.yummy.profile_data"

dependencies {
    implementation(projects.feature.profile.profileDomain)
}