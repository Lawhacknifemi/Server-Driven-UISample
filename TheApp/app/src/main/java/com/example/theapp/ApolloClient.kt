package com.example.theapp

import com.apollographql.apollo3.ApolloClient

val apolloCleint = ApolloClient.Builder()
    .serverUrl("http://192.168.62.110:4000/graphql")
    .build()
