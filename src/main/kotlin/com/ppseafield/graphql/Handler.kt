package com.ppseafield.graphql

import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.execution.GraphQLServer
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

class Handler(
    private val requestParser: RequestParser,
    contextFactory: ContextFactory,
    requestHandler: GraphQLRequestHandler
) : GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler) {
    suspend fun handle(applicationCall: ApplicationCall) {
        val result = execute(applicationCall.request)
        if (result !== null) {
            applicationCall.response.call.respond(
                requestParser.mapper.writeValueAsString(result)
            )
        }
    }
}

fun mkHandler(): Handler {
    val graphQL = getGraphQLObject()
    return Handler(
        RequestParser(),
        ContextFactory(),
        GraphQLRequestHandler(graphQL)
    )
}