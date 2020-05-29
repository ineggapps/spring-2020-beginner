package com.demo3;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() {
		name = "��浿";
		tel = "010-3333-2222";
		age = 3;
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
		return name + ", " + tel + ", " + age + ", " + (age >= 19 ? "����" : "�̼�����");
	}

}
