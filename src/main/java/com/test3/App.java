package com.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
@Autowired와
@Qualifier("userService2")를 이용하여 id식별자 지정하기
Autowired는 두 개 이상의 bean객체가 선언되면 클래스이름의 기본id식별자(클래스 첫 글자를 소문자로 바꾼 글자)를 기본으로 인식하는데, 
이 클래스가 존재하지 않는 경우 예외가 발생한다. 이러한 경우를 대비하여 Qualifier로 미리 id를 지정하면 예외를 피할 수 있다.
 * */
public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test3/applicationContext.xml");
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean(UserBean.class);//캐스팅하지 않아도 되는 구문
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
