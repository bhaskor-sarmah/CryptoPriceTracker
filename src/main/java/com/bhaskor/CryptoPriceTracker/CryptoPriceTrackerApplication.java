package com.bhaskor.CryptoPriceTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoPriceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoPriceTrackerApplication.class, args);
	}

}
