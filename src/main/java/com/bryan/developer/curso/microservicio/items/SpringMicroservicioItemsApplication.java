package com.bryan.developer.curso.microservicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringMicroservicioItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicioItemsApplication.class, args);
	}

}
