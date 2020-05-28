package com.test6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 @PostConstrcut: 생성자가 실행된 직후 호출되는 init 메서드로 xml에서 bean속성의 init-method와 동일
 @PreDestroy: 자원이 닫히기 직전에 호출되는 destroy 메서드로 xml에서 bean 속성의 destroy-method와 동일
  */
public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/test6/applicationContext.xml");

		try {
			// 컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean(UserBean.class);// 캐스팅하지 않아도 되는 구문
			bean.write();
		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
