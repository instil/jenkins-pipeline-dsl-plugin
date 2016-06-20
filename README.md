A collection of extensions to the base Jenkins build pipeline DSL. 

## Building

To build the Jenkins plugin, execute the following.

```
./gradlew clean build
```

## Local Testing

The Jenkins plugin build tools provide a quick and easy way to spin up a local Jenkins instance for testing.
```
./gradlew server
```

## Install

This plugin is currently not yet available through the Jenkins plugin repository so it requires manaual installation.
Simply take the built plugin `build/libs/instil-pipeline-dsl.hpi` and install this through the Jenkins user interface.
Note that installation will currently fail if the plugin dependencies are not met but Jenkins will alert as to which plugins
there are.

## Env variables

The list of env variables available to each build. Access them via env.<env_var_name> in your DSL script.
```
BUILD_DISPLAY_NAME, 
BUILD_ID, 
BUILD_NUMBER, 
BUILD_TAG, 
BUILD_URL, 
CLASSPATH, 
HUDSON_HOME, 
HUDSON_SERVER_COOKIE, 
HUDSON_URL, 
JENKINS_HOME, 
JENKINS_SERVER_COOKIE, 
JENKINS_URL, 
JOB_BASE_NAME,
JOB_NAME,
JOB_URL
```
