package com.example.demo04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

// 配置属性测试
@Slf4j
@SpringBootTest
class Demo04ApplicationTests {
	@Value("${book.stock}")
	private int stock;

	// 还可以通过SpEL表达式进行一些计算
	@Value("#{${book.stock} > 50 ? true : false}")
	private boolean inStock;

	@Value("${book.desc}")
	private String desc;

	@Value("${com.didispace.blog.randomInt}")
	private int randomInt;

	@Value("${com.didispace.blog.randomStr}")
	private String randomStr;

	@Value("${spring.my-example.url}")
	private List<String> urls;



	@Test
	public void test() {

		log.info("book.stock: {}", stock);
		log.info("inStock: {}", inStock);
		log.info("desc: {}", desc);

		// 随机数
		log.info("randomInt: {}", randomInt);
		log.info("randomStr: {}", randomStr.toLowerCase(Locale.ROOT));

		// 数组
		log.info("urls: {}", urls);
		log.info("urls[0]: {}", urls.get(0));

	}

}
