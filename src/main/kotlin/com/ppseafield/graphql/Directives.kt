package com.ppseafield.graphql

import com.expediagroup.graphql.generator.annotations.GraphQLDirective
import graphql.introspection.Introspection.DirectiveLocation

@GraphQLDirective(
    name = "auth",
    description = "This field requires authentication.",
    locations = [DirectiveLocation.FIELD_DEFINITION]
)
annotation class RequiresAuth()

@GraphQLDirective(
    name = "anonymous",
    description = "This field may be accessed anonymously",
    locations = [DirectiveLocation.FIELD_DEFINITION]
)
annotation class AllowAnonymous()