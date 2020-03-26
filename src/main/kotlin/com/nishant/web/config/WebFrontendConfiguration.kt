package com.nishant.web.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import javax.validation.constraints.NotEmpty

class WebFrontendConfiguration : Configuration() {
    @JsonProperty
    @NotEmpty
    val projectStatus: String  = "development"
}