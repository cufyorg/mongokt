pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "mongokt"

// include directories that starts with "mongokt-"
for (file in rootDir.listFiles().orEmpty()) {
    if (file.isDirectory && file.name.startsWith("mongokt-")) {
        include(":${file.name}")
    }
}
