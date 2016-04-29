node {
    properties [[$class: "ParametersDefinitionProperty", 
                 parameterDefinitions: [[$class: "BooleanParameterDefinition", 
                                         defaultValue: false, 
                                         description: "Release version?",
                                         name: "RELEASE"]]]]

    stage "Checkout"
    git url: "https://github.com/instil/jenkins-pipeline-dsl-plugin.git"

    stage "Build"
    sh "./gradlew clean build"
    archive includes: "build/libs/*.hpi"

    if (env.RELEASE) {
        sh "./gradlew release"
    }
}
