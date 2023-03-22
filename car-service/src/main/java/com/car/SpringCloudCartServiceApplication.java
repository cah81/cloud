package com.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCartServiceApplication.class, args);
	}

}
