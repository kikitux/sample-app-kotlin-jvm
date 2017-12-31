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
class SysdateControllerTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun testSysdateController() {
        val result = testRestTemplate.getForEntity("/sysdate", String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
    }
}