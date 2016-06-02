package dsl

def call(Map config = [:]) {
    echo "Sending email notification if previous steps failed: ${config}"
    step([$class: "Mailer",
          notifyEveryUnstableBuild: config.notifyForEveryUnstableBuild ?: true,
          recipients: config.additionalRecipients ?: "",
          sendToIndividuals: config.notifyCommitters ?: true])
}