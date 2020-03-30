package com.nishant.web.resource.view

import com.nishant.web.data.PendingTime
import com.nishant.web.data.User
import io.dropwizard.views.View

class HomePage : View {
    var pendingTime: PendingTime

    constructor(pendingTime: PendingTime) : super("homepage.ftl") {
        this.pendingTime = pendingTime
    }

}