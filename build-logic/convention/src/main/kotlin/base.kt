import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.libraryConfig
import utils.libs

internal class BaseConfigBinaryPlugin : Plugin<Project> {
    override fun apply(project: Project) = project.applyAndroid()

    private fun Project.applyAndroid() {
        applyPlugins()
        setProjectConfig()
        setDependencies()
    }

    private fun Project.applyPlugins() = pluginManager.apply {
        apply("com.android.library")
        apply("kotlin-android")
//        apply("com.google.devtools.ksp")
//        apply("kotlin-kapt")
//        apply("kotlin-parcelize")
    }

    private fun Project.setProjectConfig() = configure<LibraryExtension> { libraryConfig(project) }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Adding common for each base module from core module
        if (project.path != ":core:common") "implementation"(project(":core:common"))

        // Core
        "implementation"(libs.findBundle("base-core").get())

        // Testing
        "testImplementation"(libs.findBundle("base-testing").get())
    }
}