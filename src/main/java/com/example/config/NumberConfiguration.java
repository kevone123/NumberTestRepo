package com.example.config;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.h2.jdbcx.JdbcDataSource;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
@Configuration
public class NumberConfiguration {
	
	
	@Bean
    public DataSource h2DataSource(){
		 return new EmbeddedDatabaseBuilder()
	                .setType(EmbeddedDatabaseType.H2)
	                .addScript("number.sql")//script to create number table
	                .addScript("addNumber.sql")
	                .build();
	}

}
