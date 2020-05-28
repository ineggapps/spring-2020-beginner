package com.test7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 @Component의 어노테이션을 이용하여 객체를 생성한다.
 알아서 객체를 생성한다. 단, id값을 @Component("id값")처럼 지정하지 않으면 기본id로 설정된다.
 따라서, 아래처럼 패키지 기반으로 클래스를 스캔할 때 @Component의 id값이 겹치면 예외가 발생한다는 것에 유의한다.
 <context:component-scan base-package="com.test7"/>
 * */
public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test7/applicationContext.xml");
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean(UserBean.class);//캐스팅하지 않아도 되는 구문
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
