package com.user9;

public class UserBean {
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

}
