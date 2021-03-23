val jctoolsVersion: String by project
val mockitoVersion: String by project
val junitVersion: String by project

plugins {
    kotlin("jvm") version "1.4.20"
}

group "tech.pronghorn"
version "0.2.1"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(project(":common"))
    implementation(kotlin("stdlib"))
    implementation("org.jctools:jctools-core:$jctoolsVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}

//uploadArchives {
//    repositories {
//        mavenDeployer {
//            pom {
//                artifactId = 'plugin-collections-jctools'
//            }
//            pom.project {
//                name 'Pronghorn Framework JCTools Collections Plugin'
//                packaging 'jar'
//                description 'A plugin for the Pronghorn Framework utilizing JCTools for various collections.'
//                url 'https://pronghorn.tech'
//                scm {
//                    url 'https://github.com/pronghorn-tech/plugin-collections-jctools.git'
//                    connection 'scm:git@github.com:pronghorn-tech/plugin-collections-jctools.git'
//                    developerConnection 'scm:git@github.com:pronghorn-tech/plugin-collections-jctools.git'
//                }
//            }
//        }
//    }
//}