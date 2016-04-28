package dsl

def call(Map config = [:]) {
    echo "Publishing PMD results: ${config}"
    step([$class: "PmdPublisher",
          canComputeNew: false,
          defaultEncoding: "",
          healthy: "",
          pattern: config.pattern ?: "",
          unHealthy: ""])
}