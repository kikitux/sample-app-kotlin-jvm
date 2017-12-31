package com.example.demo

import oracle.jdbc.pool.OracleDataSource
import org.springframework.context.annotation.Bean
import javax.sql.DataSource
import javax.validation.constraints.NotNull
import java.sql.SQLException

class OracleConfiguration {
    @NotNull
    private var username: String? = null

    @NotNull
    private var password: String? = null

    @NotNull
    private var url: String? = null

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun setUrl(url: String) {
        this.url = url
    }

    @Bean
    @Throws(SQLException::class)
    internal fun dataSource(): DataSource {

        val dataSource = OracleDataSource()
        dataSource.user = username
        dataSource.setPassword(password)
        dataSource.url = url
        dataSource.implicitCachingEnabled = true
        dataSource.fastConnectionFailoverEnabled = true
        return dataSource
    }

}