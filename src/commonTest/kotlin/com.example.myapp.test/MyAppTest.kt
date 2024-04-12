package com.example.myapp.test

import com.example.myapp.useApolloKotlin
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class MyAppTest {
  @Test
  fun test() = runTest {
    useApolloKotlin()
  }
}
