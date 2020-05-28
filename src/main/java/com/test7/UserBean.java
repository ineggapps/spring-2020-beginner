package com.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 객체 생성. id는 자동으로 첫글자가 소문자인 클래스명이 부여된다.
// 아이디: userBean
// 그런데 아이디를 만들 때는 xml 내에서 중복을 만날 수 없다. 
// 하지만, xml옵션에서 <context:component-scan base-package="com.*"/>로 지정하였고 클래스명이 겹치는 경우에는 충돌이 나므로 실행할 수 없다.
@Component
public class UserBean {
	
	@Autowired
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
