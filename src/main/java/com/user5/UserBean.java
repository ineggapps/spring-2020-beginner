package com.user5;

public class UserBean {
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	// �����ڸ� �̿��Ͽ� UserSerivice ��ü ����
	public UserBean(UserService userService) {
		this.userService = userService;
	}

	public void write() {
		String m = userService.message();
		System.out.println("�����ڷ� �ڵ����� => " + m);
	}

}
