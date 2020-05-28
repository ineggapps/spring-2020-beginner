package com.test7;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() {
		name = "���ڹ�";
		tel="010-7777-7777";
		age=19;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String message() {
		String s = "�̸�: " + name + ", ��ȭ��ȣ: " + tel + ", ����: " + age;
		return s;
	}

}
