package com.aop.after;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:com/aop/after/applicationContext.xml");
		try {
			UserService service = (UserService)context.getBean("userService");
			service.setData("������");
			service.write();
		} finally {
			context.close();
		}
	}
}
