import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import utils.androidConfig
import utils.libs

internal class ComposeConfigBinaryPlugin : Plugin<Project> {
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
        apply("kotlin-composecompiler")
        apply("kotlin-kapt")
    }

    private fun Project.setProjectConfig() = configure<LibraryExtension> { // utils.android
        androidConfig(project)

        buildFeatures.compose = true
    }

    private fun Project.configureKapt() = configure<KaptExtension> { correctErrorTypes = true }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Adding common for each ui module from core ui module
        if (project.path != ":core:ui") "implementation"(project(":core:ui"))
        if (project.path != ":core:common") "implementation"(project(":core:common"))

        // Core
        "kapt"(libs.findLibrary("hilt-compiler").get())
        "implementation"(libs.findBundle("compose-core").get())

        // UI
        val composeBom = libs.findLibrary("compose-bom").get()

        "implementation"(platform(composeBom))
        "implementation"(libs.findBundle("compose-ui").get())

        // Testing
        "kaptTest"(libs.findLibrary("hilt-compiler").get())
        "kaptAndroidTest"(libs.findLibrary("hilt-compiler").get())
        "testImplementation"(libs.findBundle("compose-unit-testing").get())
        "androidTestImplementation"(platform(composeBom))
        "androidTestImplementation"(libs.findBundle("compose-android-testing").get())
    }
}