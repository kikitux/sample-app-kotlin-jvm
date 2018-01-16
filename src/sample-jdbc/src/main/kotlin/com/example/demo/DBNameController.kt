package com.example.demo

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.ResultSet

@RestController
class DBNameController {

    @Autowired lateinit var jdbcTemplate: JdbcTemplate

    @ApiOperation(value = "dbname", notes = "returns db_name")
    @GetMapping("/dbname")
    fun dbname() = jdbcTemplate.query(
        "select sys_context('userenv','db_name') as db_name from dual", {
        rs: ResultSet, _: Int -> rs.getString("db_name")
        }
    )

}

