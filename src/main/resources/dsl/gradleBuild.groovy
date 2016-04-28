package dsl

def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    sh "./gradlew clean build"
    archive includes: config.archiveFiles ?: "build/libs/*.jar"
    publishJunitTestResults "build/test-results/**/TEST-*.xml"
    publishCheckstyleResults pattern: "build/reports/checkstyle/main.xml"
    publishFindbugsResults pattern: "build/reports/findbugs/main.xml"
    publishPmdResults pattern: "build/reports/pmd/main.xml"
    scanCodebaseForOpenTasks pattern: "src/main/**/*.java, src/main/**/*.kt"
    sendEmailNotificationOnFailure notifyCommitters: true
}
