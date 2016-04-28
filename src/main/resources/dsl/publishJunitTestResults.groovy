package dsl

def call(String testResults = null) {
    echo "Publishing JUnit test results: ${testResults}"
    step([$class: "JUnitResultArchiver", testResults: testResults ?: "**/TEST-*.xml"])
}