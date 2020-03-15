package com.group2.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource database = new DriverManagerDataSource();
		database.setDriverClassName("com.mysql.jdbc.Driver");
		database.setUrl("jdbc:mysql://localhost:3306/CS_451");
		database.setUsername("root");
		database.setPassword("password");

		return database;
	}

}
