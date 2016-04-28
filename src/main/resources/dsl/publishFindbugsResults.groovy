package dsl

def call(Map config = [:]) {
    echo "Publishing Findbugs results: ${config}"
    step([$class: "FindBugsPublisher",
          canComputeNew: false,
          defaultEncoding: "",
          excludePattern: "",
          healthy: "",
          includePattern: "",
          pattern: config.pattern ?: "",
          unHealthy: ""])
}