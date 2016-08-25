package com.nicholasworkshop.artifactid

import org.gradle.api.Project
import org.gradle.api.internal.project.DefaultProject
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by nickwph on 1/23/16.
 */
class ArtifactIdPluginTest {

    private static final ARTIFACT_ID = UUID.randomUUID().toString()

    @Test
    void testApply() throws Exception {
        Project project = createAndroidApplicaitonProject()
        project.apply(plugin: 'com.nicholasworkshop.artifactid')
        project.id ARTIFACT_ID
        project.evaluate()
        assertEquals(true, project.hasId())
        assertEquals(ARTIFACT_ID, project.getId())
    }

    @Test
    void testApply_whenNotSet_shouldReturnNull() throws Exception {
        Project project = createAndroidLibraryProject()
        project.apply(plugin: 'com.nicholasworkshop.artifactid')
        project.evaluate()
        assertEquals(false, project.hasId())
        assertEquals(null, project.getId());
    }

    @Test
    void testApply_whenIsLibraryProject() throws Exception {
        Project project = createAndroidLibraryProject()
        project.apply(plugin: 'com.nicholasworkshop.artifactid')
        project.id ARTIFACT_ID
        project.evaluate()
        assertEquals(true, project.hasId())
        assertEquals(ARTIFACT_ID, project.getId())
    }

    private static Project createAndroidApplicaitonProject() {
        DefaultProject project = ProjectBuilder.builder().build() as DefaultProject
        linkAndroidSdkDir(project)
        generateAndroidManifest(project)
        project.apply(plugin: 'com.android.application')
        project.android.compileSdkVersion 23
        project.android.buildToolsVersion "23.0.1"
        return project
    }

    private static Project createAndroidLibraryProject() {
        DefaultProject project = ProjectBuilder.builder().build() as DefaultProject
        linkAndroidSdkDir(project)
        generateAndroidManifest(project)
        project.apply(plugin: 'com.android.library')
        project.android.compileSdkVersion 23
        project.android.buildToolsVersion "23.0.1"
        return project
    }

    private static void generateAndroidManifest(Project project) {
        File path = new File(project.projectDir.toString(), "src/main")
        File file = new File(path.toString(), "AndroidManifest.xml")
        path.mkdirs()
        file.createNewFile()
        file << "<manifest/>"
    }

    private static void linkAndroidSdkDir(DefaultProject project) {
        File file = new File(project.projectDir.toString(), "local.properties")
        File local = new File("../local.properties")
        if (local.exists()) {
            file << local.text
        } else {
            FileOutputStream stream = new FileOutputStream(file)
            Properties properties = new Properties()
            properties.setProperty("sdk.dir", System.getenv("ANDROID_HOME"))
            properties.store(stream, null)
            stream.close()
        }
    }
}
