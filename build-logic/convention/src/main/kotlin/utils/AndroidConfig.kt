package utils

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal fun BaseExtension.androidConfig(project: Project) {
    namespace = ProjectConfig.namespace
    setCompileSdkVersion(ProjectConfig.compileSdk)

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

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