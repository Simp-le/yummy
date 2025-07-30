package utils

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project

internal fun LibraryExtension.libraryConfig(project: Project) {
    namespace = ProjectConfig.namespace
    setCompileSdkVersion(ProjectConfig.compileSdk)

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        lint.targetSdk = ProjectConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = ProjectConfig.compileJdkVersion
        targetCompatibility = ProjectConfig.compileJdkVersion
    }

    project.kotlin.compilerOptions {
        jvmTarget.set(ProjectConfig.kotlinJvmTarget)
    }
}