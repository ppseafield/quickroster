package com.ppseafield.graphql

import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query

class UserQuery : Query {
    @GraphQLDescription("Check if a username already exists.")
    fun usernameExists(username: String): Boolean {
        return false
    }
    fun motd(): String {
        return "howdy, folks!"
    }
}


data class CreateAccountParameters(val username: String, val password: String, val email: String?)
class UserMutation : Mutation {
    @GraphQLDescription("Create a user account")
    fun createAccount(params: CreateAccountParameters): String {
        return "Account created!"
    }
}

val userQuery = TopLevelObject(UserQuery())
val userMutation = TopLevelObject(UserMutation())