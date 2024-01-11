// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        val hiltVersion by extra("2.50")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.16" apply false
}