package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

        @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = "Hello $name!"

    @GetMapping("/greetingData")
    fun greetingData(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting ("Hello $name!")

}