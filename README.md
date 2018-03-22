## STEPS

### 1. Setup
Create Kotlin/JS project

### 2. Add Kotlin Frontend

build.gradle

```groovy
group = "com.codingblocks"
version = "0.1.0"

buildscript {
    ext.kotlin_version = '1.2.30'

    repositories {
        jcenter()
        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
    }

    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "org.jetbrains.kotlin:kotlin-frontend-plugin:0.0.29"
    }
}

apply plugin: 'kotlin2js'
apply plugin: 'org.jetbrains.kotlin.frontend'

repositories {
    jcenter()
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-js:$kotlin_version"
}

kotlinFrontend {
//    COMMENT IF YOU HAVE NODE GLOBALLY INSTALLED
//    downloadNodeJsVersion = "latest"

    npm {
        dependency "kotlin"

    }

    webpackBundle {
        bundleName = "main"
        contentPath = file('src/main/web')
    }

    define "PRODUCTION", false
}

compileKotlin2Js {
    kotlinOptions.metaInfo = true
    kotlinOptions.outputFile = "$project.buildDir.path/js/${project.name}.js"
    kotlinOptions.sourceMap = true
    kotlinOptions.moduleKind = 'commonjs'
    kotlinOptions.main = "call"
}

```

### 3. Required Files

1. `src/main/web/index.html`
2. `src/main/kotlin/script.kt`


### 4. Types support

```kotlin
import kotlin.browser.*
import kotlin.dom.*
import jquery.*
```

### 5. Run

Run
```
gradle run
```

Stop

```
gradle stop
```

### 6. Hot Reload

```
gradle -t run
```

Open `http://localhost:8088`
