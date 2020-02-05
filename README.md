# kotlin_mvvm_room_koin_coroutine

## Project level gradle

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.3.61'
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.2'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```

## PlugIns (App module gradle)

```
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: "kotlin-kapt"
```

## DataBinding and Java 1.8 Support (App module gradle)

```
android {
    ...

    dataBinding {
        enabled = true
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    ...
}
```

## Dependencies (App module)

```
dependencies {
    def life_cycle_version = "2.1.0"
    def room_version = "2.2.2"
    def koin_version = "2.0.1"
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.core:core-ktx:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

    implementation "com.google.android.material:material:1.0.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$life_cycle_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$life_cycle_version"
    implementation "androidx.lifecycle:lifecycle-extensions:$life_cycle_version"
    kapt "androidx.lifecycle:lifecycle-compiler:$life_cycle_version" // For Kotlin use kapt instead of annotationProcessor
    implementation "androidx.activity:activity-ktx:1.1.0-rc02"

    // Room
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    // For Kotlin use kapt instead of annotationProcessor
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"
    // optional - RxJava support for Room
    implementation "androidx.room:room-rxjava2:$room_version"
    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "androidx.room:room-guava:$room_version"
    // Test helpers
    testImplementation "androidx.room:room-testing:$room_version"

    //Room debug db
    debugImplementation 'com.amitshekhar.android:debug-db:1.0.6'

    // Koin for Android
    implementation "org.koin:koin-android:$koin_version"
    // Koin Android ViewModel features
    implementation "org.koin:koin-android-viewmodel:$koin_version"
    // Koin Arch Components for Room
//    implementation "org.koin:koin-android-architecture:$koin_version"

    //Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.2"

    implementation "com.squareup.retrofit2:retrofit:2.6.0"
    implementation "com.squareup.retrofit2:converter-gson:2.6.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.2.1"

    // instrumentation tests
    androidTestImplementation "androidx.test.ext:junit:1.1.1"
    androidTestImplementation "androidx.test.espresso:espresso-core:3.2.0"

    // unit tests
    testImplementation "junit:junit:4.12"
    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.2"
    testImplementation "org.koin:koin-test:2.0.1"
    testImplementation "org.mockito:mockito-core:2.28.2"
    testImplementation "androidx.arch.core:core-testing:2.1.0"
}

```




