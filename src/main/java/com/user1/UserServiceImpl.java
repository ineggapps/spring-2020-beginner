package com.user1;

public class UserServiceImpl implements UserService {

	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() {
		name = "������";
		tel = "010-1234-1234";
		age = 20;
	}

	@Override
	public String message() {
		String s = "�̸�: " + name + ", ��ȭ��ȣ: " + tel + ", ����: " + age;
		return s;
	}

}
