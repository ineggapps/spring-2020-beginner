package com.user5;

public class UserBean2 {
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	//setter�� �̿��Ͽ� userService ��ü ����
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println("������Ƽ�� �ڵ����� =>" + m);
	}

}
