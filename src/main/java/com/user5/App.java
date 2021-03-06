package com.user5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 xml을 이용하여 autowire을 설정하는 방법
 autowire="constructor"
 autowire="byName"
 autowire="byType"
 * */
public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user5/applicationContext.xml");

		try {
			// 컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = context.getBean(UserBean.class);// 캐스팅하지 않아도 되는 구문
			bean.write();

			UserBean2 bean2 = context.getBean(UserBean2.class);// 캐스팅하지 않아도 되는 구문
			bean2.write();
		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
