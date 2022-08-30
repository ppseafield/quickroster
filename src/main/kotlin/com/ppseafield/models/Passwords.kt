package com.ppseafield.models

import org.ktorm.entity.Entity
import org.ktorm.schema.*
import java.time.Instant
import java.util.UUID

interface Password : Entity<Password> {
    val id: UUID
    val userId: User
    val passwordHash: String
    val createdOn: Instant
    val version: Int
}

object Passwords : Table<Password>("passwords") {
    val id = uuid("id").primaryKey().bindTo { it.id }
    val userId = uuid("user_id").references(Users) { it.userId }
    val passwordHash = text("password_hash").bindTo { it.passwordHash }
    val createdOn = timestamp("created_on").bindTo { it.createdOn }
    val version = int("version").bindTo { it.version }
}