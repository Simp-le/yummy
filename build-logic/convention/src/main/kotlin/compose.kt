import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.androidConfig
import utils.libs

internal class ComposeConfigBinaryPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.applyAndroid()

    private fun Project.applyAndroid() {
        applyPlugins()
        setProjectConfig()
        setDependencies()
    }

    private fun Project.applyPlugins() = pluginManager.apply {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-composecompiler")
//        apply("kotlin-kapt")
//        apply("kotlin-parcelize")
    }

    private fun Project.setProjectConfig() = configure<LibraryExtension> { // utils.android
        androidConfig(project)

        buildFeatures.compose = true
    }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Adding common for each ui module from core ui module
        if (project.path != ":core:ui") "implementation"(project(":core:ui"))
        if (project.path != ":core:common") "implementation"(project(":core:common"))

        // Core
        "implementation"(libs.findBundle("compose-core").get())

        // UI
        val composeBom = libs.findLibrary("compose-bom").get()

        "implementation"(platform(composeBom))
        "implementation"(libs.findBundle("compose-ui").get())

        // Testing
        "testImplementation"(libs.findBundle("compose-unit-testing").get())
        "androidTestImplementation"(platform(composeBom))
        "androidTestImplementation"(libs.findBundle("compose-android-testing").get())
    }
}