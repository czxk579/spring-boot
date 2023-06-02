package com.example.demo21;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Demo21Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo21Application.class, args);
		log.error("Hello World");
		log.warn("Hello World");
		log.info("Hello World");
		log.debug("Hello World");
		log.trace("Hello World");
	}

}
