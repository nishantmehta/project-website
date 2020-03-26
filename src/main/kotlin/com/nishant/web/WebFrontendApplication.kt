package com.nishant.web

import com.nishant.web.config.WebFrontendConfiguration
import com.nishant.web.healthcheck.DefaultHealthcheck
import com.nishant.web.resource.RootResource
import io.dropwizard.Application
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
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            WebFrontendApplication().run(*args)
        }
    }
}
