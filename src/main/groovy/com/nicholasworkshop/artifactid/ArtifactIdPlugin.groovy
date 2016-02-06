package com.nicholasworkshop.artifactid;

import org.gradle.api.Plugin;
import org.gradle.api.internal.project.ProjectInternal;

/**
 * Created by nickwph on 1/29/16.
 */
public class ArtifactIdPlugin implements Plugin<ProjectInternal> {

    private ProjectInternal project

    void apply(ProjectInternal project) {
        this.project = project
        project.ext {
            id = this.&id
            getId = this.&getId
            hasId = this.&hasId
        }
    }

    void id(param) {
        project.ext.artifactId = param
    }

    String getId() {
        if (hasId()) {
            return project.ext.artifactId
        }
        throw new MissingPropertyException("Cannot get property 'id' on extra properties extension as it does not exist");
    }

    boolean hasId() {
        return project.hasProperty('artifactId')
    }
}