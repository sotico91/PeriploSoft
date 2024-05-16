package com.co.periferiaIT.PeriploSoft.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.co.periferiaIT.PeriploSoft.client")
public class PeriploSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeriploSoftApplication.class, args);
	}

}
