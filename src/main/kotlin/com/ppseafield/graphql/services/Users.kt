package com.ppseafield.graphql.services

import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.server.operations.Mutation
import com.expediagroup.graphql.server.operations.Query
import com.ppseafield.DB
import com.ppseafield.graphql.AllowAnonymous
import com.ppseafield.graphql.RequiresAuth
import com.ppseafield.models.User
import io.ktor.server.http.*
import org.ktorm.entity.Entity
import java.time.Instant
import java.util.*

data class RosterUser(
    val id: ID,
    val username: String,
    val email: String?,
    val createdOn: String,
    val updatedOn: String,
    val active: Boolean
)
fun fromUser(user: User): RosterUser {
    // TODO: Replace with custom type in schema generator hook.
    return RosterUser(ID(user.id.toString()), user.username, user.email, user.createdOn.toHttpDateString(), user.updatedOn.toHttpDateString(), user.active)
}


class UserQuery : Query {
    fun usernameExists(username: String): Boolean {
        return false
    }
    fun userInfo() : RosterUser {
        return fromUser(DB.allUsers().last())
    }
}


data class CreateAccountParameters(val username: String, val password: String, val email: String?)
class UserMutation : Mutation {
    fun createUserWithPassword(username: String, password: String, email: String?): String {

        return "not created or destroyed"
    }
}

val userQuery = TopLevelObject(UserQuery())
val userMutation = TopLevelObject(UserMutation())