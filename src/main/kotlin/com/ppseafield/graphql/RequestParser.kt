package com.ppseafield.graphql

import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.server.request.*
import java.io.IOException

class RequestParser() : GraphQLRequestParser<ApplicationRequest> {
    val mapper = jacksonObjectMapper()
    override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest = try {
        mapper.readValue(
            request.call.receiveText(),
            GraphQLServerRequest::class.java
        )
    } catch (e: IOException) {
        throw IOException("Unable to parse GraphQL Payload")
    }
}