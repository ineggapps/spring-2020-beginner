package com.user8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 ��� �޼��� ������
 
 �߻�Ŭ������ �������̽��� �̿��Ͽ� ��ü�� ��ȯ�޴� ���.
 ��ü�� ���� �� ���� �߻�Ŭ������ �������̽��� ������ �ܿ��� �˾Ƽ� �����Ǿ� ��ü�� ��ȯ���� �� �ִ�.
 <!-- 
		�� ��� �޼��� ������
		�����̳ʰ� �����ϴ� ���� �޼��带 �������Ͽ� �����̳ʿ� �ִ� �ٸ� ���� ã�� �� �ֵ��� �ϴ� ����̴�.
		1. ��������� �ݵ�� public, protected���� �Ѵ�.
		2. return type�� void�� �ƴϴ�.
		3. ���㰪�� ���� �ʴ´�.
		4. �߻� �޼���ε� �����ϴ�.
		5. final ���� ����ϸ� �������� �� �����Ƿ� ����ؼ��� �� �ȴ�.
	 -->
	<bean id="pizzaShop" class="com.user8.PizzaShop">
		<lookup-method name="makePizza" bean="pizza"/>
		<lookup-method name="makeVeggiePizza" bean="veggiePizza" />
	</bean>
 * */
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
