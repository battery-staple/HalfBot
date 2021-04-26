package build

object Versions {
    const val exposedVersion = "0.30.1"
    const val diskordVersion = "1.8.1"
    const val slf4jVersion = "1.7.30"
    const val konfVersion = "1.1.2"
}

object KotlinDependencies {
    const val exposedCore = "org.jetbrains.exposed:exposed-core:${Versions.exposedVersion}"
    const val exposedDao = "org.jetbrains.exposed:exposed-dao:${Versions.exposedVersion}"
    const val exposedJdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposedVersion}"
}

object DiskordDependencies {
    const val diskord = "com.jessecorbett:diskord:${Versions.diskordVersion}"
    const val slf4j = "org.slf4j:slf4j-simple:${Versions.slf4jVersion}"
}

object KonfDependencies {
    const val konf = "com.uchuhimo:konf-yaml:${Versions.konfVersion}"
}