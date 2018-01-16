package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.ResultSet
import io.swagger.annotations.ApiOperation

@RestController
class SysdateController {

    @Autowired lateinit var jdbcTemplate: JdbcTemplate

    @ApiOperation(value = "sysdate", notes = "returns SELECT SYSDATE FROM DUAL")
    @GetMapping("/sysdate")
    fun sysdate() = jdbcTemplate.query(
    "SELECT SYSDATE FROM DUAL", {
           rs: ResultSet, _: Int -> rs.getTimestamp("sysdate")
        }
    )

}



