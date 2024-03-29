package com.example.demo02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demo02Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
	}

	@Slf4j
	@RestController
	static class HelloController {

		@Value("${db:}")
		private String db;

		@Value("${mq:}")
		private String mq;

		@RequestMapping("/")
		public String index() {
			log.info("db：" + db);
			log.info("mq：" + mq);
			return "success";
		}
	}
}
