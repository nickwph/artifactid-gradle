# Artifact Id Gradle Plugin
[![Circle CI](https://img.shields.io/circleci/project/nickwph/artifactid-gradle.svg)]
(https://circleci.com/gh/nickwph/artifactid-gradle)
[![codecov.io](https://img.shields.io/codecov/c/github/nickwph/artifactid-gradle.svg)]
(https://codecov.io/github/nickwph/artifactid-gradle)
[ ![Download](https://img.shields.io/bintray/v/nickwph/maven/artifactid-gradle.svg)]
(https://bintray.com/nickwph/maven/artifactid-gradle/_latestVersion)

## What does this plugin do

Allow you to do following in <code>build.gradle</code>. <br/>
In the background it will do <code>ext.artifactId = 'the-artifact-id'</code>.

```groovy
id 'the-artifact-id'
```

## Usage

```groovy
buildscript {
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
