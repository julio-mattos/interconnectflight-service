package com.ryanair.interconnectflight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ryanair.interconnectflight.clients")
public class InterconnectFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterconnectFlightApplication.class, args);
	}

}
