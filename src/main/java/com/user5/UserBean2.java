package com.user5;

public class UserBean2 {
	private UserService userService;// 인터페이스에 의존관계를 가지고 있는 UserBean

	//setter을 이용하여 userService 객체 설정
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println("프로퍼티로 자동설정 =>" + m);
	}

}
