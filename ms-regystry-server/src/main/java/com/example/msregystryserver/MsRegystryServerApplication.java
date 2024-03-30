package com.example.msregystryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsRegystryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegystryServerApplication.class, args);
	}

}
