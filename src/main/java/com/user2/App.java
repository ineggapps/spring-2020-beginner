package com.user2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 xml로 객체를 생성할 때 property 태그를 이용하여 클래스의 값 수정하기(setter메서드가 선언돼 있어야 한다.)
 xml로 객체를 생성할 때 생성자를 이용하여 클래스의 값 설정하기 (constructor-arg 태그)
 
 참조자료형 ref 속성으로 객체id 명시
 일반자료형의 경우(String까지) value="값" 으로 명시
 * */
public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user2/applicationContext.xml");
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean("userBean");
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
