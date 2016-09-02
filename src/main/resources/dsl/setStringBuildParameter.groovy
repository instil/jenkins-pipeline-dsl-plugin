package dsl

def call(Map config = [:]) {
    echo "Setting boolean build parameter: ${config}"
    if (!config.name) {
        error "Property name must be provided"
        return
    }
    properties([[$class: "ParametersDefinitionProperty",
                 parameterDefinitions: [[$class: "StringParameterDefinition",
                                         defaultValue: config.defaultValue ?: "",
                                         description: config.description ?: "",
                                         name: config.name]]]])
}