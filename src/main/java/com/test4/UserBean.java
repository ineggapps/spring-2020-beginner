package com.test4;

import javax.annotation.Resource;

public class UserBean {
	
	//id를 이용하여 의존 관계를 설정한다. java 어노테이션
	@Resource(name="userService1")
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
