package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendServer1Application.class, args);
	}

}
