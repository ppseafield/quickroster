package com.ppseafield.graphql.services

import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.ppseafield.graphql.RequiresAuth

class PasswordMutation : Mutation {
    fun changePassword(newPassword: String): Boolean {
        return false
    }
}

val passwordMutation = TopLevelObject(PasswordMutation())