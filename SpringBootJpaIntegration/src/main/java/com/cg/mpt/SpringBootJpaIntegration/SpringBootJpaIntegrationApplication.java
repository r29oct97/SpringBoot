package com.cg.mpt.SpringBootJpaIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EntityScan("com.cg.beans")
public class SpringBootJpaIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaIntegrationApplication.class, args);
	}

}
