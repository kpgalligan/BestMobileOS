package me.bradyaiello.library

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(bestMobileOS().contains("iOS"), "Check iOS is mentioned")
    }
}