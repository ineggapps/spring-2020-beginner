package com.test4;

import javax.annotation.Resource;

public class UserBean {
	
	//id�� �̿��Ͽ� ���� ���踦 �����Ѵ�. java ������̼�
	@Resource(name="userService1")
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
