package com.player.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

	 public class AppConfig {
	    
	    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
	        return new JdbcTemplate(hikariDataSource);
	    }
	 }

