node {
    stage "Checkout"
    sh "git checkout . && git clean -fd"
    git url: "https://github.com/instil/jenkins-pipeline-dsl-plugin.git"

    stage "Build"
    sh "./gradlew clean build"
    archive includes: "build/libs/*.hpi"
}
