package com.ppseafield.graphql.services

import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.ppseafield.graphql.AllowAnonymous
import com.ppseafield.graphql.RequiresAuth

class SessionMutation : Mutation {
    fun loginWithPassword(username: String, password: String) : Boolean {
        return false
    }

    fun logout(): Boolean {
        return false
    }
}

val sessionMutation = TopLevelObject(SessionMutation())