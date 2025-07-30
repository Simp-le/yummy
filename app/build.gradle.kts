plugins {
    alias(libs.plugins.app.conf)
}

android {
    testOptions { packaging.resources.excludes.add("META-INT/*") }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui)
}