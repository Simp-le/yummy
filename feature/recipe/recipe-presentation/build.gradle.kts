plugins {
    alias(libs.plugins.compose.conf)
}

android.namespace = "dev.yummy.recipe_presentation"

dependencies {
    implementation(projects.feature.recipe.recipeDomain)
}