package com.ppseafield.graphql.services

import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import com.ppseafield.graphql.AllowAnonymous
import com.ppseafield.graphql.RequiresAuth
import com.ppseafield.models.User

class UserQuery : Query {
    fun usernameExists(username: String): Boolean {
        return false
    }
    fun userInfo() : User? {
        return null
    }
}


data class CreateAccountParameters(val username: String, val password: String, val email: String?)
class UserMutation : Mutation {
    fun createUserWithPassword(username: String, password: String, email: String?): User? {

        return null
    }
}

val userQuery = TopLevelObject(UserQuery())
val userMutation = TopLevelObject(UserMutation())