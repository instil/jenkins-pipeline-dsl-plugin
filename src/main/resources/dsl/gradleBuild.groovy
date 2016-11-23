package dsl

def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    tasks = config.tasks ?: "clean build"
    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']) {
        sh "./gradlew ${tasks}"
    }
    archive includes: config.archiveFiles ?: "**/build/libs/*.jar"
    publishJunitTestResults config.junitResults ?: "**/build/test-results/**/TEST-*.xml"
    publishCheckstyleResults pattern: config.checkstyleResults ?: "**/build/reports/checkstyle/main.xml"
    publishFindbugsResults pattern: config.findbugsResults ?: "**/build/reports/findbugs/main.xml"
    publishPmdResults pattern: config.pmdResults ?: "**/build/reports/pmd/main.xml"
    scanCodebaseForOpenTasks pattern: "**/src/main/**/*.java, **/src/main/**/*.kt"
}
