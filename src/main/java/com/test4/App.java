package com.test4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test4/applicationContext.xml");
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean(UserBean.class);//캐스팅하지 않아도 되는 구문
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
