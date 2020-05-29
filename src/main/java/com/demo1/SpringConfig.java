package com.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //환경 설정을 위한 클래스
public class SpringConfig {
	//Bean어노테이션을 붙였으므로 메서드가 호출된 횟수에 관계없이 기본적으로는 singleton으로 관리된다.
	@Bean //bean태그에 버금가는 어노테이션
	public UserBean beanDevice() { //메서드명은 제약X => 단, 메서드명이 id가 된다는 것을 기억한다.
		return new UserBean(); //bean태그와 달리 객체 생성을 직접 해야 한다는 것이 차이점
	}
	
	@Bean
	public UserService userServiceDevice() {
		return new UserServiceImpl();
	}
	
	
	
}
