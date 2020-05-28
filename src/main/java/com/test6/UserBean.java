package com.test6;

import org.springframework.beans.factory.annotation.Autowired;

public class UserBean {
	
	@Autowired
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
