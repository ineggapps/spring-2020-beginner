package com.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

// xml파일 없이 @Configuration만으로 스프링 컨테이너 설정하기
// GenericXmlApplicationContext가 아닌 AnnotationConfigApplicationContext클래스 객체를 이용한다.

public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//★
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
//			UserBean bean = context.getBean(UserBean.class);//캐스팅하지 않아도 되는 구문
			UserBean bean = (UserBean) context.getBean("demo2.bean");
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
