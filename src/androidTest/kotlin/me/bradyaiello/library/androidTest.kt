package me.bradyaiello.library

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", BestMobileOS.bestMobileOS().contains("Android"))
    }
}