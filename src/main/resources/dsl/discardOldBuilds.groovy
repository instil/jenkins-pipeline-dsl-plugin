package dsl

def call(Map config = [:]) {
    echo "Discarding old builds: ${config}"
    properties([[$class: "BuildDiscarderProperty",
                 strategy: [$class: "LogRotator",
                            artifactDaysToKeepStr: config.maxDaysToKeepArtifacts ?: "",
                            artifactNumToKeepStr: config.maxArtifactsToKeep ?: "",
                            daysToKeepStr: config.maxDaysToKeepBuilds ?: "",
                            numToKeepStr: config.maxBuildsToKeep ?: ""]]])
}