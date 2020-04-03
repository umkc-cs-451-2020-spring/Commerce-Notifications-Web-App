package com.group2.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatabaseConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource database = new DriverManagerDataSource();
		database.setDriverClassName("com.mysql.jdbc.Driver");
		database.setUrl("jdbc:mysql://136.32.145.118:3306/CS_451?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		database.setUsername("connor");
		database.setPassword("c0nn0r1");

		return database;
	}

}
