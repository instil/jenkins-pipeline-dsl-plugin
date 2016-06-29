package dsl

/*
 * Can be used two ways
 *
 * -Single value-
 * setBooleanBuildParameter name: "Release ne", defaultValue: false
 *
 * -Multiple values-
 * setBooleanBuildParameter([
 *     [name: "Release me", defaultValue: false],
 *     [name: "Release test", defaultValue: true],
 *     [name: "Release lab", defaultValue: true],
 * ])
 */

def call(config) {
    if (config == null) {
        error "Provided empty configuration for boolean parameter"
        return
    }

    booleanProperties = buildProperties(config)

    for (Map property : booleanProperties) {
        if (!property.name) {
            error "Property name must be provided for boolean parameter $map"
            return
        }

        property.put("\$class", "BooleanParameterDefinition")
    }

    properties([[$class: "ParametersDefinitionProperty", parameterDefinitions: booleanProperties]])
}

def buildProperties(config) {
    if (config instanceof List<Map<String, Object>>) {
        return config
    }

    if (config instanceof Map<String, Object>) {
        return [].push(config)
    }

    return []
}