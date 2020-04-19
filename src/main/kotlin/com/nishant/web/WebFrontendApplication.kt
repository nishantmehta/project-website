package com.nishant.web

import com.nishant.web.config.WebFrontendConfiguration
import com.nishant.web.healthcheck.DefaultHealthcheck
import com.nishant.web.resource.RootResource
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.views.ViewBundle

class WebFrontendApplication : Application<WebFrontendConfiguration>() {
    override fun run(config: WebFrontendConfiguration, env: Environment) {
        env.jersey().register(RootResource(config.projectStatus))
        env.healthChecks().register("default", DefaultHealthcheck())
    }

    override fun initialize(bootstrap: Bootstrap<WebFrontendConfiguration>) {
        bootstrap.addBundle(ViewBundle())
        bootstrap.addBundle(AssetsBundle())
    }

    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            WebFrontendApplication().run(*args)
        }
    }

}
