package com.test4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 @Autowired와 @Qualifier대신에 사용할 수 있는 @Resource(name="userService1")
 @Resource 어노테이션은 java에서 기본적으로 제공하는 어노테이션이다.
 기본적으로 @Resource의 name속성은 생략해도 되지만, 빈에 2개 이상의 객체가 선언되었는데 기본id가 없는 경우 반드시 name속성을 지정해 줘야 예외를 피할 수 있다.
 * */
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
