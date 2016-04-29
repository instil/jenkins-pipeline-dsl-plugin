package dsl

def call(Map config = [:]) {
    echo "Setting boolean build parameter: ${config}"
    if (!config.name) {
        error "Property name must be provided"
        return
    }
    properties([[$class: "ParametersDefinitionProperty",
                 parameterDefinitions: [[$class: "BooleanParameterDefinition",
                                         defaultValue: config.defaultValue ?: false,
                                         description: config.description ?: "",
                                         name: config.name]]]])
}