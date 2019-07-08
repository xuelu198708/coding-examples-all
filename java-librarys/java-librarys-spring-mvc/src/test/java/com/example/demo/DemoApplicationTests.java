package com.example.demo;

import org.assertj.core.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ConversionService conversionService;

	@Test
	public void contextLoads() {
		Assert.assertEquals(25, conversionService.convert("25", Integer.class).intValue());
		Assert.assertEquals(new BigDecimal("25"), conversionService.convert("25", BigDecimal.class));
		Date today = new Date();
		Assert.assertEquals(DateUtil.now(), conversionService.convert(today, String.class));
	}

}
