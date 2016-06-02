package dsl

def call(Map config = [:]) {
    echo "Publishing Android linter results: ${config}"
    step([$class: "LintPublisher", pattern: config.pattern ?: "**/lint-results*.xml"])
}