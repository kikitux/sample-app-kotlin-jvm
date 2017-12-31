package com.example.demo


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

import java.sql.ResultSet

@RestController
class SysdateController {

    @Autowired lateinit var jdbcTemplate: JdbcTemplate

    @GetMapping("/sysdate")
    fun sysdate() = jdbcTemplate.query(
    "SELECT SYSDATE FROM DUAL", {
            //rs: ResultSet, _: Int -> rs.getString("sysdate")
           rs: ResultSet, _: Int -> rs.getTimestamp("sysdate")
        }
    )

}