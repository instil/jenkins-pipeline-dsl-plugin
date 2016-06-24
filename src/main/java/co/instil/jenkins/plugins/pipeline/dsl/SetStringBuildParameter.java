/*
 * Copyright 2016 Instil Software.
 */
package co.instil.jenkins.plugins.pipeline.dsl;

import hudson.Extension;
import org.jenkinsci.plugins.pipelinedsl.PipelineDSLGlobal;

/**
 * Uses {@link PipelineDSLGlobal} to link to the groovy script file resources/dsl/setStringBuildParameter.groovy.
 */
@Extension
public class SetStringBuildParameter extends PipelineDSLGlobal {

    @Override
    public String getFunctionName() {
        return "setStringBuildParameter";
    }

}
