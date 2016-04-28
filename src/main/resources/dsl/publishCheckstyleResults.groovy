package dsl

def call(Map config = [:]) {
    echo "Publishing Checkstyle results: ${config}"
    step([$class: "CheckStylePublisher",
          canComputeNew: false,
          defaultEncoding: "",
          healthy: "",
          pattern: config.pattern ?: "",
          unHealthy: ""])
}