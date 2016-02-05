# Artifact Id Gradle Plugin


## What does this plugin do

Allow you to do this in <code>build.gradle</code>.

```groovy
id 'the-artifact-id'
```

## Usage

```groovy
buildscript {
    repositories {
        maven { url "https://oss.sonatype.org/service/local/staging/deploy/maven2" }
    }
    dependencies {
        classpath 'com.nicholasworkshop:gradle-maven:1.0.0'
    }
}

apply plugin: 'com.nicholasworkshop.artifactid'

id 'the-artifact-id'
```