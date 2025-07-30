package utils

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal object ProjectConfig {
    const val namespace = "dev.yummy.android"
    const val appId = "dev.yummy.android"
    const val compileSdk = 36
    const val minSdk = 28
    const val targetSdk = 36
    const val versionCode = 1
    const val versionName = "1.0"
    val compileJdkVersion = JavaVersion.VERSION_11
    val kotlinJvmTarget = JvmTarget.JVM_11
}