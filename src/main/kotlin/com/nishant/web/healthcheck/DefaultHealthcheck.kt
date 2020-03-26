package com.nishant.web.healthcheck

import com.codahale.metrics.health.HealthCheck

class DefaultHealthcheck : HealthCheck() {
    override fun check(): Result {
        return Result.healthy()
    }
}