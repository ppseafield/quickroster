package com.ppseafield

import com.ppseafield.models.*
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

object DB {
    private var database: Database? = null
    fun connect(url: String, user: String, password: String) {
        this.database = Database.connect(
            url = url,
            driver = "org.postgresql.Driver",
            user = user,
            password = password
        )
    }
    private val users get() = database!!.sequenceOf(Users)
    private val passwords get() = database!!.sequenceOf(Passwords)
    private val sessions get() = database!!.sequenceOf(Sessions)

    fun allUsers(): List<User> {
        return users.toList()
    }
    fun usernameExists(username: String): Boolean {
        return users.find { it.username eq username } == null
    }
}