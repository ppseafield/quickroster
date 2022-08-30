package com.ppseafield.graphql
import com.expediagroup.graphql.generator.SchemaGenerator
import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.generator.toSchema
import graphql.GraphQL


private val queries = listOf(
    userQuery
)
private val mutations = listOf(
    userMutation
)


private val config = SchemaGeneratorConfig(
    supportedPackages = listOf("com.ppseafield.graphql", "com.ppseafield")
)
val generator = SchemaGenerator(config)
val schema = toSchema(config, queries, mutations)

fun getGraphQLObject(): GraphQL = GraphQL.newGraphQL(schema).valueUnboxer(IDValueUnboxer()).build()