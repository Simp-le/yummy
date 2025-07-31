import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import utils.libraryConfig
import utils.libs

internal class BaseConfigBinaryPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.applyAndroid()

    private fun Project.applyAndroid() {
        applyPlugins()
        setProjectConfig()
        configureKapt()
        setDependencies()
    }

    private fun Project.applyPlugins() = pluginManager.apply {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-kapt")
        apply("com.google.devtools.ksp")
    }

    private fun Project.setProjectConfig() = configure<LibraryExtension> { libraryConfig(project) }

    private fun Project.configureKapt() = configure<KaptExtension> { correctErrorTypes = true }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Adding common for each base module from core module
        if (project.path != ":core:common") "implementation"(project(":core:common"))

        // Core
        "kapt"(libs.findLibrary("hilt-compiler").get())
        "implementation"(libs.findBundle("base-core").get())

        // Testing
        "kaptTest"(libs.findLibrary("hilt-compiler").get())
        "testImplementation"(libs.findBundle("base-testing").get())
    }
}