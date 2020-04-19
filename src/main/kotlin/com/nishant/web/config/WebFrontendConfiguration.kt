package com.nishant.web.config

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.bundles.assets.AssetsBundleConfiguration
import io.dropwizard.bundles.assets.AssetsConfiguration
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle
import javax.validation.constraints.NotEmpty

class WebFrontendConfiguration : Configuration() {
    @JsonProperty
    @NotEmpty
    val projectStatus: String  = "development"
}