import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import utils.ProjectConfig
import utils.androidConfig
import utils.libs

internal class AppModuleBinaryPlugin: Plugin<Project> {
    override fun apply(project: Project) = project.applyAndroid()

    private fun Project.applyAndroid() {
        applyPlugins()
        setProjectConfig()
        configureKapt()
        setDependencies()
    }

    private fun Project.applyPlugins() = pluginManager.apply {
        apply("com.android.application")
        apply("kotlin-android")
        apply("kotlin-composecompiler")

        apply("com.google.dagger.hilt.android") // for easier @HiltAndroidApp and @AndroidEntryPoint, see https://dagger.dev/hilt/gradle-setup#:~:text=Why%20use%20the%20plugin?
        apply("com.google.devtools.ksp")
        apply("kotlin-kapt")
    }

    private fun Project.setProjectConfig() = configure<BaseAppModuleExtension> {
        androidConfig(project)

        buildFeatures.compose = true
        defaultConfig {
            applicationId = ProjectConfig.appId
            vectorDrawables.useSupportLibrary = true
        }
    }

    private fun Project.configureKapt() = configure<KaptExtension> { correctErrorTypes = true }

    private fun Project.setDependencies() = dependencies {
        // Desugaring
        "coreLibraryDesugaring"(libs.findLibrary("desugarJdkLibs").get())

        // Core
        "kapt"(libs.findLibrary("hilt-compiler").get())
        "implementation"(libs.findBundle("app-core").get())

        // UI
        val composeBom = libs.findLibrary("compose-bom").get()
        "implementation"(platform(composeBom))
        "implementation"(libs.findBundle("app-ui").get())

        // Data

        // Testing
        "kaptTest"(libs.findLibrary("hilt-compiler").get())
        "kaptAndroidTest"(libs.findLibrary("hilt-compiler").get())
        "testImplementation"(libs.findBundle("app-unit-testing").get())
        "androidTestImplementation"(platform(composeBom))
        "androidTestImplementation"(libs.findBundle("app-android-testing").get())

        // Debug
        "debugImplementation"(libs.findBundle("app-debug").get())
    }
}