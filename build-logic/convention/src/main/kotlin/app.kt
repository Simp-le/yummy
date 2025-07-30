import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.ProjectConfig
import utils.androidConfig
import utils.libs

internal class AppModuleBinaryPlugin: Plugin<Project> {
    override fun apply(project: Project) = project.applyAndroid()

    private fun Project.applyAndroid() {
        applyPlugins()
        setProjectConfig()
        setDependencies()
    }

    private fun Project.applyPlugins() = pluginManager.apply {
        apply("com.android.application")
        apply("kotlin-android")
        apply("kotlin-composecompiler")

//        apply("com.google.dagger.hilt.android")
//        apply("com.google.devtools.ksp")
//        apply("kotlin-kapt")
    }

    private fun Project.setProjectConfig() = configure<BaseAppModuleExtension> {
        androidConfig(project)

        buildFeatures.compose = true
        defaultConfig {
            applicationId = ProjectConfig.appId
            vectorDrawables.useSupportLibrary = true
        }
    }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Core
        "implementation"(libs.findBundle("app-core").get())

        // UI
        val composeBom = libs.findLibrary("compose-bom").get()
        "implementation"(platform(composeBom))
        "implementation"(libs.findBundle("app-ui").get())

        // Data

        // Testing
        "testImplementation"(libs.findBundle("app-unit-testing").get())
        "androidTestImplementation"(platform(composeBom))
        "androidTestImplementation"(libs.findBundle("app-android-testing").get())

        // Debug
        "debugImplementation"(libs.findBundle("app-debug").get())
    }
}