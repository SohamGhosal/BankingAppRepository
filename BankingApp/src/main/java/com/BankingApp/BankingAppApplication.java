package com.BankingApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BankingAppApplication {
	private  static final Logger logger= LogManager.getLogger(BankingAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
		logger.info("Application Started!");
	}
}
