package com.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 환경 설정을 위한 클래스
public class SpringConfig {
//	@Bean //@Bean: 기본적으로 아이디는 메서드 이름이 된다.
	@Bean(name = "demo2.bean", initMethod = "init", destroyMethod = "destroy")
	public UserBean beanDevice() {
		return new UserBean();
	}

	@Bean(name = "demo2.userService")
	public UserService userServiceDevice() {
		return new UserServiceImpl();
	}

}
