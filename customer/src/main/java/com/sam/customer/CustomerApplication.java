package com.sam.customer;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Microservice for customer management REST API documentation",
				description = "With this microservice, it is possible to create, modify and delete customer data",
				version = "v1",
				contact = @Contact(
						name = "Samraj Subramaniam",
						email = "samrajs@gmail.com",
						url = "https://www.sam-gmbh.de"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.sam-gmbh.de"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "With this microservice, it is possible to create, modify and delete customer data",
				url = "https://www.sam-gmbh.de"
		)
)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
