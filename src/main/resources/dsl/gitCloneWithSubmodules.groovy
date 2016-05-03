package dsl

def call(Map config = [:]) {
    echo "Checking out branch(es) ${config.branchSpec} from ${config.url}"
    checkout([$class: "GitSCM",
              branches: [[name: config.branchSpec ?: "master"]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: "CleanBeforeCheckout"],
                           [$class: "LocalBranch", localBranch: config.localBranch ?: "master"],
                           [$class: "SubmoduleOption", disableSubmodules: false,
                            recursiveSubmodules: true,
                            reference: "",
                            trackingSubmodules: false]],
              submoduleCfg: [],
              userRemoteConfigs: [[url: config.url]]])
}