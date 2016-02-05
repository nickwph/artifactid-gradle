# Artifact Id Gradle Plugin


## What does this plugin do

Allow you to do following in <code>build.gradle</code>. <br/>
In the background it will do <code>ext.artifactId = 'the-artifact-id'</code>.

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

## DSL

| Method                        | Description                                                        | 
| ----------------------------- | ------------------------------------------------------------------ |
| <code>void id(String)<code>   | Set Id.                                                            | 
| <code>String getId()</code>   | Return the id, <code>null</code> will be reutned if id is not set. |
| <code>boolean hasId()</code>  | Return if id is set.                                               |

## Build Status

[![Circle CI](https://circleci.com/gh/nickwph/artifactid-gradle.svg?style=shield)](https://circleci.com/gh/nickwph/artifactid-gradle)
[![Coverage Status](https://coveralls.io/repos/github/nickwph/artifactid-gradle/badge.svg?branch=master)](https://coveralls.io/github/nickwph/artifactid-gradle?branch=master)
