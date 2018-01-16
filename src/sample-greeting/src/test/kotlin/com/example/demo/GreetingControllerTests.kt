package com.example.demo

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTests {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun testGreetingControllerNull() {
        val result = testRestTemplate.getForEntity("/greeting", String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "Hello World!")
    }

    @Test
    fun testGreetingControllerWord() {
        val result = testRestTemplate.getForEntity("/greeting?name=Word", String::class.java) // Word
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "Hello Word!") // Word
    }

    @Test
    fun testGreetingControllerDataNull() {

        val result = testRestTemplate.getForEntity("/greetingData", Greeting::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, Greeting("Hello World!"))
    }

    @Test
    fun testGreetingControllerDataWord() {
        val result = testRestTemplate.getForEntity("/greetingData?name=Word", Greeting::class.java) // Word
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, Greeting("Hello Word!")) // Word
    }

}