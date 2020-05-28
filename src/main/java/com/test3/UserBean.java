package com.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserBean {
	// �������踦 Ÿ������ �ڵ� ����. setter�� �ʿ����� �ʴ�.
	// ��, ������ Ÿ���� ��ü�� �� �� �̻� �����ϴ� ��쿡�� �ʵ��� ������ ��ü �̸�(id)�� ���� ã�� ������ ���ܸ� �߻���Ų��.
	// @Autowired�� ���� ����ϸ�, ������ Ÿ���� �� �� �̻��� ��� id�� �������踦 �����Ѵ�.
	@Autowired
	@Qualifier("userService2")
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

}
