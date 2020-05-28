package com.user9;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/*
 	�ܺ� ������ �̿��Ͽ� �����ϴ� ���
 	.properties ������ �̿��Ͽ� ��ü�� ������ ������ �� �ִ�.
 	<!-- properties�� �� �� �� �ۿ� �ҷ����� ���Ѵ�. -->
	<!-- <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"> 
		<property name="locations"> <value>classpath:com/user9/user.properties</value> 
		</property> </bean> -->

	<context:property-placeholder
		location="classpath:com/user9/user.properties" />

	<!-- properties�� =���� �պκ��� �׸���� �����ָ� �ȴ�. -->
	<bean id="userService" class="com.user9.UserServiceImpl">
		<property name="name" value="${name}" /> el�±� �������� ���� �Է��ϸ� �ȴ�.
		<property name="tel" value="${tel}" />
		<property name="age" value="${age}" />
	</bean>
 * */
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user9/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
