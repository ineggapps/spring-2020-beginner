package com.test2;

import org.springframework.beans.factory.annotation.Autowired;

public class UserBean {
	//�������踦 Ÿ������ �ڵ� ����. setter�� �ʿ����� �ʴ�.
	//��, ������ Ÿ���� ��ü�� �� �� �̻� �����ϴ� ��쿡�� �ʵ��� ������ ��ü �̸�(id)�� ���� ã�� ������ ���ܸ� �߻���Ų��.
	@Autowired
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

}
