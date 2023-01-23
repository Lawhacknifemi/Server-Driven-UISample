package com.example.theapp

import com.apollographql.apollo3.ApolloClient

val apolloCleint = ApolloClient.Builder()
    .serverUrl("http://YOUR IP ADRESSS/graphql")
    .build()
