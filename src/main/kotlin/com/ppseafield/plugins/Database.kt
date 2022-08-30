package com.ppseafield.plugins

import com.ppseafield.DB
import io.ktor.server.application.*
import org.flywaydb.core.Flyway


fun Application.configureDatabase() {
    val host = environment.config.property("dataSource.host").getString()
    val port = environment.config.property("dataSource.port").getString()
    val database = environment.config.property("dataSource.database").getString()
    val user = environment.config.property("dataSource.user").getString()
    val password = environment.config.property("dataSource.password").getString()
    val url = "jdbc:postgresql://${host}:${port}/${database}"

    // Migrate
    Flyway.configure()
          .dataSource(url, user, password)
          .load()

    // Set up DB connection
    DB.connect(url, user, password)
}