package com.test2;

import org.springframework.beans.factory.annotation.Autowired;

public class UserBean {
	//의존관계를 타입으로 자동 설정. setter가 필요하지 않다.
	//단, 동일한 타입의 객체가 두 개 이상 존재하는 경우에는 필드명과 동일한 객체 이름(id)를 먼저 찾고 없으면 예외를 발생시킨다.
	@Autowired
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

}
