package com.demo3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.demo3.config.SpringConfig;


public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//★
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
//			UserBean bean = context.getBean(UserBean.class);
			UserBean bean = context.getBean("userBean",UserBean.class);
			//expected at least 1 bean which qualifies as autowire candidate. Dependency annotations
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
