package com.user5;

public class UserBean {
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	// 생성자를 이용하여 UserSerivice 객체 지정
	public UserBean(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println("생성자로 자동설정 => " + m);
	}

}
