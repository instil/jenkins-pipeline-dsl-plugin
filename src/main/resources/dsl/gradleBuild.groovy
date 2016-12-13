package dsl

def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def tasks = config.tasks ?: "clean build"
    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']) {
        try {
            sh "./gradlew ${tasks}"
        } finally {
            def junitResults = config.junitResults ?: "**/TEST-*.xml"
            junit allowEmptyResults: true, testResults: junitResults

            publishCheckstyleResults pattern: config.checkstyleResults ?: "**/build/reports/checkstyle/main.xml"
            publishFindbugsResults pattern: config.findbugsResults ?: "**/build/reports/findbugs/main.xml"
            publishPmdResults pattern: config.pmdResults ?: "**/build/reports/pmd/main.xml"
        }
    }

    archive includes: config.archiveFiles ?: "**/build/libs/*.jar"
    scanCodebaseForOpenTasks pattern: "**/src/main/**/*.java, **/src/main/**/*.kt"
}
