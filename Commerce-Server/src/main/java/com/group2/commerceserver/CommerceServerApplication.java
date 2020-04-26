package com.group2.commerceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.group2.commerceserver.api")
public class CommerceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceServerApplication.class, args);
	}

}
