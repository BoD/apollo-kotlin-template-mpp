package com.example.myapp

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory
import kotlinx.coroutines.runBlocking

fun useApolloKotlin() = runBlocking {
  val apolloClient = ApolloClient.Builder()
    .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
    .normalizedCache(MemoryCacheFactory(1024 * 1024).chain(SqlNormalizedCacheFactory("apollo.db")))
    .build()

  println()
  var response = apolloClient.query(LaunchListQuery())
    .fetchPolicy(FetchPolicy.NetworkOnly)
    .execute()
  println("From network: ${response.dataAssertNoErrors}")

  println()
  response = apolloClient.query(LaunchListQuery())
    .fetchPolicy(FetchPolicy.CacheOnly)
    .execute()
  println("From cache: ${response.dataAssertNoErrors}")
}
