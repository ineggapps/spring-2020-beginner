package com.user8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// �����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		// ������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/user8/applicationContext.xml");

		try {
			PizzaShop shop = context.getBean(PizzaShop.class);
			
			Pizza p1 = shop.makePizza();
			System.out.println("ó��: " + p1);
			
			Pizza p2 = shop.makePizza();
			System.out.println("�� ��°: " + p2);
			
			Pizza p3 = shop.makeVeggiePizza();
			System.out.println("�� ��°: " + p3);
			
		} finally {
			context.close();// ���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
