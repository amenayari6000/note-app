// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version "2.49" apply false
    // room
   id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false


// ksp 1.9.21-1.0.15  should kotlin "1.9.21" and compose version  kotlinCompilerExtensionVersion = "1.5.7"
  //  to create room

}
tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
