plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "2.0.0" apply false
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("com.microsoft.playwright:playwright:1.56.0")
    implementation("org.apache.commons:commons-lang3:3.20.0")
    testImplementation("io.qameta.allure:allure-junit5:2.27.0")

}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

