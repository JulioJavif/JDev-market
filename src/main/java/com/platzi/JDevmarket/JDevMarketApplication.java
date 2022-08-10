package com.platzi.JDevmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JDevMarketApplication {
	// exclude = {DataSourceAutoConfiguration.class}
	public static void main(String[] args) {
		SpringApplication.run(JDevMarketApplication.class, args);
	}

}
