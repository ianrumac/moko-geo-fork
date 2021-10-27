import java.lang.System.getenv

/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("multiplatform-library-convention")
    id("kotlin-parcelize")
    id("dev.icerock.mobile.multiplatform.android-manifest")
    id("publication-convention")
}

group = "com.lotus.moko.fork"
version = libs.versions.mokoGeoVersion.get()

dependencies {
    commonMainImplementation(libs.coroutines)

    commonMainImplementation(libs.mokoParcelize)

    "androidMainImplementation"(libs.appCompat)
    "androidMainImplementation"(libs.lifecycle)
    "androidMainImplementation"(libs.playServicesLocation)
}

publishing {
    repositories {
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/ianrumac/moko-geo")
            credentials {
                username = getenv("GH_USER")
                password = getenv("GH_TOKEN")
            }
        }
    }
}


