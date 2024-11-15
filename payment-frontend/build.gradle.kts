/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.9/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

group = "de.xxx"
version = "0.0.1-SNAPSHOT"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

task("cleanAngular") {
    if(project.hasProperty("withAngular")) {
        logger.info("Task cleanAngular")
        delete("src/angular/node_modules")
    }
}

task("buildAngular") {
    if(project.hasProperty("withAngular")) {
        exec {
            logger.info("Task buildAngular - npm install")
            workingDir ("src/angular")
            if (System.getProperty("os.name").uppercase().contains("WINDOWS")){
                commandLine("npm.cmd", "install")
            } else {
                commandLine("npm", "install")
            }
        }
        exec {
            logger.info("Task buildAngular - npm run build")
            workingDir("src/angular")
            if (System.getProperty("os.name").uppercase().contains("WINDOWS")){
                commandLine("npm.cmd", "run", "build")
            } else {
                commandLine("npm", "run", "build")
            }
        }
    }
}