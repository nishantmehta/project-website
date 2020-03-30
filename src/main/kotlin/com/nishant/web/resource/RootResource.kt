package com.nishant.web.resource

import com.codahale.metrics.annotation.Timed
import com.google.common.collect.ImmutableMap
import com.nishant.web.data.PendingTime
import com.nishant.web.data.User
import com.nishant.web.resource.view.HomePage
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/")
class RootResource(private val projectStatus: String) {

    val releaseDate = DateTime(2020, 4, 30, 12, 0, 0, DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/New_York")))
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @Path("timestamp")
    fun timestamp(): Response {
        val entity = ImmutableMap.builder<String, String>()
            .put("project status", projectStatus)
            .put("time on server", DateTime.now().toLocalDateTime().toString())
            .build()
        return Response.ok().entity(entity).build();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("")
    fun homePage(): HomePage {
        val now = DateTime.now()

        val pendingTime = PendingTime(Math.abs(releaseDate.dayOfMonth - now.dayOfMonth), Math.abs(releaseDate.hourOfDay - now.hourOfDay), Math.abs(releaseDate.minuteOfHour - now.minuteOfHour))
        return HomePage(pendingTime)
    }
}