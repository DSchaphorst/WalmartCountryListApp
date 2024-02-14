plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val retrofit2Version: String = "2.9.0"
val okhttpLoggingVersion: String = "4.10.0"

dependencies {
    implementation(project(mapOf("path" to ":domain")))

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
}
