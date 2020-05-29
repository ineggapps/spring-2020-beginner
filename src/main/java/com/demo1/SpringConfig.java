package com.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //ȯ�� ������ ���� Ŭ����
public class SpringConfig {
	//Bean������̼��� �ٿ����Ƿ� �޼��尡 ȣ��� Ƚ���� ������� �⺻�����δ� singleton���� �����ȴ�.
	@Bean //bean�±׿� ���ݰ��� ������̼�
	public UserBean beanDevice() { //�޼������ ����X => ��, �޼������ id�� �ȴٴ� ���� ����Ѵ�.
		return new UserBean(); //bean�±׿� �޸� ��ü ������ ���� �ؾ� �Ѵٴ� ���� ������
	}
	
	@Bean
	public UserService userServiceDevice() {
		return new UserServiceImpl();
	}
	
	
	
}
