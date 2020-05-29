package com.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // ȯ�� ������ ���� Ŭ����
public class SpringConfig {
//	@Bean //@Bean: �⺻������ ���̵�� �޼��� �̸��� �ȴ�.
	@Bean(name = "demo2.bean", initMethod = "init", destroyMethod = "destroy")
	public UserBean beanDevice() {
		return new UserBean();
	}

	@Bean(name = "demo2.userService")
	public UserService userServiceDevice() {
		return new UserServiceImpl();
	}

}
