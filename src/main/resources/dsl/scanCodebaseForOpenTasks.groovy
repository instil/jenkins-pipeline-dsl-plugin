package dsl

def call(Map config = [:]) {
    echo "Scanning codebase for open tasks: ${config}"
    step([$class: "TasksPublisher",
          canComputeNew: false,
          defaultEncoding: "",
          excludePattern: "",
          healthy: "",
          high: "FIXME",
          ignoreCase: true,
          low: "",
          normal: "TODO",
          pattern: config.pattern ?: "",
          unHealthy: ""])
}