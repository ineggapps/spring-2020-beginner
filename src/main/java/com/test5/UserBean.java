package com.test5;

import javax.inject.Inject;

public class UserBean {
	// Ÿ������ �������� �ڵ� ����. java ����
	@Inject
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
