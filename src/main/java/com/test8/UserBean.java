package com.test8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//아이디를 지정
@Component("test8.userBean")
public class UserBean {
	
	@Autowired
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
