package com.xxh.Test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-provider-zk.xml" })
public class Testcustclass {

	/*
	 * public static void main(String[] args) throws Exception {
	 * ClassPathXmlApplicationContext context = new
	 * ClassPathXmlApplicationContext("dubbo-provider-zk.xml");
	 * 
	 * context.start(); System.out.println("启动"); System.in.read();
	 * 
	 * 
	 * }
	 */
	@Test
	public void dubboStart() throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider-zk.xml");
		context.start();
		System.out.println("dubbo启动");
		System.in.read();

	}
}
