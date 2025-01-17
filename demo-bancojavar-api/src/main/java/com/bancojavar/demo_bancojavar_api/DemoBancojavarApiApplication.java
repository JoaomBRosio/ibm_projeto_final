package com.bancojavar.demo_bancojavar_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.bancojavar.demo_bancojavar_api.feign")
public class DemoBancojavarApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBancojavarApiApplication.class, args);
	}

}
