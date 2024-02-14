// Top-level build file where you can add configuration options common to all sub-projects/modules.
val koinVersion by extra { "3.2.0" }
val coroutinesVersion by extra { "1.4.1" }
val coroutinesAndroidVersion by extra { "1.6.4" }
val retrofit2Version by extra { "2.9.0" }
val okhttpLoggingVersion by extra { "4.10.0" }

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false
}