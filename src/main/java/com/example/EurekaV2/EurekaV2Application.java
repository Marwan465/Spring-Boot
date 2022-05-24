package com.example.EurekaV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaV2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaV2Application.class, args);
	}

}
