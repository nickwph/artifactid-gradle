# Artifact Id Gradle Plugin
[![Circle CI](https://circleci.com/gh/nickwph/artifactid-gradle.svg?style=shield)](https://circleci.com/gh/nickwph/artifactid-gradle)
[![codecov.io](https://codecov.io/github/nickwph/artifactid-gradle/coverage.svg?branch=master)](https://codecov.io/github/nickwph/artifactid-gradle?branch=master)
[ ![Download](https://api.bintray.com/packages/nickwph/maven/artifactid-gradle/images/download.svg) ](https://bintray.com/nickwph/maven/artifactid-gradle/_latestVersion)

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
        maven { url "https://oss.sonatype.org/content/groups/staging" }
    }
    dependencies {
        classpath 'com.nicholasworkshop:gradle-artifactid:1.0.0'
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
