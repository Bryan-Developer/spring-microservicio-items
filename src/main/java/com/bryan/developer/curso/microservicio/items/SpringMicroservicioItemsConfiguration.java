package com.bryan.developer.curso.microservicio.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringMicroservicioItemsConfiguration {
	
	@Bean
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}

}
