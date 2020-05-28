package com.user9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/*
 	외부 파일을 이용하여 주입하는 방법
 	.properties 파일을 이용하여 객체에 내용을 삽입할 수 있다.
 	<!-- properties는 단 한 번 밖에 불러오지 못한다. -->
	<!-- <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"> 
		<property name="locations"> <value>classpath:com/user9/user.properties</value> 
		</property> </bean> -->

	<context:property-placeholder
		location="classpath:com/user9/user.properties" />

	<!-- properties의 =에서 앞부분의 항목명을 적어주면 된다. -->
	<bean id="userService" class="com.user9.UserServiceImpl">
		<property name="name" value="${name}" /> el태그 형식으로 값을 입력하면 된다.
		<property name="tel" value="${tel}" />
		<property name="age" value="${age}" />
	</bean>
 * */
public class App {
	public static void main(String[] args) {
		//생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		//스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user9/applicationContext.xml");
		
		try {
			//컨테이너에서 해당 객체 가져오는 방법
			UserBean bean = (UserBean) context.getBean(UserBean.class);//캐스팅하지 않아도 되는 구문
			bean.write();
		} finally {
			context.close();//리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
