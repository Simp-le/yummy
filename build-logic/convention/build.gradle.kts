import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "dev.yummy.android.buildlogic"

kotlin {
    explicitApi = ExplicitApiMode.Strict
    compilerOptions.jvmTarget = JvmTarget.JVM_11
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

dependencies.implementation(libs.bundles.plugins)

gradlePlugin {
    plugins {
        register("app") {
            id = libs.plugins.app.conf.get().pluginId
            implementationClass = "AppModuleBinaryPlugin"
        }
        register("base") {
            id = libs.plugins.base.conf.get().pluginId
            implementationClass = "BaseConfigBinaryPlugin"
        }
        register("compose") {
            id = libs.plugins.compose.conf.get().pluginId
            implementationClass = "ComposeConfigBinaryPlugin"
        }
    }
}
