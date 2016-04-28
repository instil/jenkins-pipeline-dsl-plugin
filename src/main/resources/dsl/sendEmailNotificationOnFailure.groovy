package dsl

def call(Map config = [:]) {
    echo "Sending failure notification via email: ${config}"
    step([$class: "Mailer",
          notifyEveryUnstableBuild: config.notifyForEveryUnstableBuild ?: false,
          recipients: config.additionalRecipients ?: "",
          sendToIndividuals: config.notifyCommitters ?: true])
}