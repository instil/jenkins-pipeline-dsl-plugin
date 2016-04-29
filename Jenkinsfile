node {
    properties([[$class: "ParametersDefinitionProperty",
                 parameterDefinitions: [[$class: "BooleanParameterDefinition", 
                                         defaultValue: false, 
                                         description: "Release version?",
                                         name: "shouldRelease"]]]])

    stage "Checkout"
    git url: "git@github.com:instil/jenkins-pipeline-dsl-plugin.git"

    stage "Build"
    sh "./gradlew clean build"
    archive includes: "build/libs/*.hpi"

    if (shouldRelease && shouldRelease.toBoolean()) {
        sh "./gradlew -Prelease.useAutomaticVersion=true release"
    }
}
