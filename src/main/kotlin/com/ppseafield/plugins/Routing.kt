package com.ppseafield.plugins

import com.ppseafield.DB
import com.ppseafield.graphql.mkHandler
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    val graphqlHandler = mkHandler()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/users") {
            call.respondText("hi")
        }
        get("/users/exists") {
            val name = call.request.queryParameters["username"]
            if (name == null) {
                call.respondText("bad request")
            } else {
                call.respondText(
                    if (DB.usernameExists(name)) "taken" else "free"
                )
            }
        }
        post("/graphql") {
            graphqlHandler.handle(call)
        }
    }
}
