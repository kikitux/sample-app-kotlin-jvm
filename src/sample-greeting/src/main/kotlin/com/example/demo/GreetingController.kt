package com.example.demo

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @ApiOperation(value = "greeting", notes = "returns Hello <name>")
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            "Hello $name!"

    @ApiOperation(value = "greetingData", notes = "returns data Hello <name>")
    @GetMapping("/greetingData")
    fun greetingData(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting ("Hello $name!")

}