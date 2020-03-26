package com.nishant.web.resource.view

import com.nishant.web.data.User
import io.dropwizard.views.View

class HomePage : View {
    var user: User

    constructor(user: User) : super("homepage.ftl") {
        println(user.name)
        this.user = user
    }

}