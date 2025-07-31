plugins {
    alias(libs.plugins.base.conf)
}

android.namespace = "dev.yummy.recipe_data"

dependencies {
    implementation(projects.feature.recipe.recipeDomain)
}