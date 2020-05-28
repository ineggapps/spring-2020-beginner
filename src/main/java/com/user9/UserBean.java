package com.user9;

public class UserBean {
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

}
