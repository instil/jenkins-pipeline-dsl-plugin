package dsl

def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    sendEmailNotificationOnFailure notifyCommitters: true

    tasks = config.tasks ?: "clean build"
    sh "./gradlew ${tasks}"
    archive includes: config.archiveFiles ?: "build/libs/*.jar"
    publishJunitTestResults junitResults ?: "build/test-results/**/TEST-*.xml"
    publishCheckstyleResults pattern: checkstyleResults ?: "build/reports/checkstyle/main.xml"
    publishFindbugsResults pattern: findbugsResults ?: "build/reports/findbugs/main.xml"
    publishPmdResults pattern: pmdResults ?: "build/reports/pmd/main.xml"
    scanCodebaseForOpenTasks pattern: "src/main/**/*.java, src/main/**/*.kt"
}
