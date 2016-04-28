node {
    stage "Build"
    sh "./gradlew clean build"
    archive includes: "build/libs/*.hpi"
}
