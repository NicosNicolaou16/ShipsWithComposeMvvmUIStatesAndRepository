// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        val hiltVersion by extra("2.54")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
plugins {
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.26" apply false
}