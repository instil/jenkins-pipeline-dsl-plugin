package dsl

/*
 * This currently does not allow sending emails to committers due a Jenkins pipeline bug.
 * https://issues.jenkins-ci.org/browse/JENKINS-24141
 * https://issues.jenkins-ci.org/browse/JENKINS-34763
 */

def call(Map config = [:]) {
    echo "Sending email notification if previous steps failed: ${config}"
    step([$class: "Mailer",
          notifyEveryUnstableBuild: config.notifyForEveryUnstableBuild ?: true,
          recipients: config.additionalRecipients ?: "",
          sendToIndividuals: config.notifyCommitters ?: true])
}