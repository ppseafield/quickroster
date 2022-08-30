package com.ppseafield.models

import org.ktorm.entity.Entity
import org.ktorm.schema.*
import java.time.Instant
import java.util.*


interface User : Entity<User> {
    val id: UUID
    val username: String
    val email: String?
    val createdOn: Instant
    val updatedOn: Instant
    val active: Boolean
}

object Users : Table<User>("users") {
    val id = uuid("id").primaryKey().bindTo { it.id }
    val username = text("username").bindTo { it.username }
    val email = text("email").bindTo { it.email }
    val createdOn = timestamp("created_on").bindTo { it.createdOn }
    val updatedOn = timestamp("updated_on").bindTo { it.updatedOn }
    val active = boolean("active").bindTo { it.active }
}