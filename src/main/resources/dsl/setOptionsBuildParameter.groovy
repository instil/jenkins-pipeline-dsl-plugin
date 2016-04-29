package dsl

def call(Map config = [:]) {
    echo "Setting options build parameter: ${config}"
    if (!config.name || !config.choices) {
        error "Property name and values must be provided"
        return
    }
    properties [[$class: 'ParametersDefinitionProperty',
                 parameterDefinitions: [[$class: 'ChoiceParameterDefinition',
                                         choices: config.choices,
                                         description: config.description ?: "",
                                         name: config.name]]]]
}