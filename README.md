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