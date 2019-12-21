package com.springboot.creditCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioCreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCreditCardApplication.class, args);
	}

}
