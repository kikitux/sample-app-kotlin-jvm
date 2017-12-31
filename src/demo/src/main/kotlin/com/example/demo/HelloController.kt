package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.swagger.annotations.ApiOperation

@RestController
class HelloController {

    @ApiOperation(value = "hello", notes = "always return Hello World!")
    @GetMapping("/hello")
    fun hello() = "Hello World!"

}