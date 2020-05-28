package com.test6;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserServiceImpl implements UserService {

	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() {
		System.out.println("������...");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("������ ���� ����(�ʱ�ȭ): @PostConstruct");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("���� ��: @PreDestroy");
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
