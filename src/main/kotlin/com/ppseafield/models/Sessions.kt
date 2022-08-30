package com.ppseafield.models

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.timestamp
import org.ktorm.schema.uuid
import java.time.Instant
import java.util.*

interface Session : Entity<Session> {
    val id: UUID
    val userId: User
    val createdOn: Instant
    val expiresOn: Instant
    val endedOn: Instant?
}

object Sessions : Table<Session>("sessions") {
    val id = uuid("id").primaryKey().bindTo { it.id }
    val userId = uuid("user_id").references(Users) { it.userId }
    val createdOn = timestamp("created_on").bindTo { it.createdOn }
    val expiresOn = timestamp("created_on").bindTo { it.expiresOn }
    val endedOn = timestamp("created_on").bindTo { it.endedOn }
}