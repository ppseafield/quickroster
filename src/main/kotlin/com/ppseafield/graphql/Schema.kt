package com.ppseafield.graphql
import com.expediagroup.graphql.generator.SchemaGenerator
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.generator.toSchema
import com.ppseafield.graphql.services.passwordMutation
import com.ppseafield.graphql.services.sessionMutation
import com.ppseafield.graphql.services.userMutation
import com.ppseafield.graphql.services.userQuery
import graphql.GraphQL


private val queries = listOf(userQuery)
private val mutations = listOf(userMutation)


private val config = SchemaGeneratorConfig(
    supportedPackages = listOf("com.ppseafield.graphql.services", "com.ppseafield.models", "com.ppseafield.graphql")
)
val generator = SchemaGenerator(config)
val schema = toSchema(config, queries, mutations)

fun getGraphQLObject(): GraphQL = GraphQL.newGraphQL(schema).valueUnboxer(IDValueUnboxer()).build()