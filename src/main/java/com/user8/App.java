package com.user8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 룩업 메서드 인젝션
 
 추상클래스나 인터페이스를 이용하여 객체를 반환받는 방법.
 객체로 만들 수 없는 추상클래스나 인터페이스도 스프링 단에서 알아서 구현되어 객체를 반환받을 수 있다.
 <!-- 
		★ 룩업 메서드 인젝션
		컨테이너가 관리하는 빈의 메서드를 재정의하여 컨테이너에 있는 다른 빈을 찾을 수 있도록 하는 기능이다.
		1. 접근제어는 반드시 public, protected여야 한다.
		2. return type이 void가 아니다.
		3. 인잣값을 갖지 않는다.
		4. 추상 메서드로도 가능하다.
		5. final 예약어를 사용하면 재정의할 수 없으므로 사용해서는 안 된다.
	 -->
	<bean id="pizzaShop" class="com.user8.PizzaShop">
		<lookup-method name="makePizza" bean="pizza"/>
		<lookup-method name="makeVeggiePizza" bean="veggiePizza" />
	</bean>
 * */
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
