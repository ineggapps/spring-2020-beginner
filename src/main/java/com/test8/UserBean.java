package com.test8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//���̵� ����
@Component("test8.userBean")
public class UserBean {
	
	@Autowired
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
