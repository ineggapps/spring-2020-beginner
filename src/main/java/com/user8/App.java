package com.user8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/user8/applicationContext.xml");

		try {
			PizzaShop shop = context.getBean(PizzaShop.class);
			
			Pizza p1 = shop.makePizza();
			System.out.println("처음: " + p1);
			
			Pizza p2 = shop.makePizza();
			System.out.println("두 번째: " + p2);
			
			Pizza p3 = shop.makeVeggiePizza();
			System.out.println("세 번째: " + p3);
			
		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
