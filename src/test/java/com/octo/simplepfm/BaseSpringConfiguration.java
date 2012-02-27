package com.octo.simplepfm;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring-test.xml")
public class BaseSpringConfiguration extends AbstractJUnit4SpringContextTests{

	@Test
	public void testSpringContext() {
		
	}
}
