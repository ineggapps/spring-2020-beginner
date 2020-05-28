package com.test5;

import javax.inject.Inject;

public class UserBean {
	// 타입으로 의존관계 자동 설정. java 지원
	@Inject
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
