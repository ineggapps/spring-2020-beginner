package com.test6;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserServiceImpl implements UserService {

	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() {
		System.out.println("생성자...");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("생성자 실행 다음(초기화): @PostConstruct");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("종료 전: @PreDestroy");
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
		String s = "이름: " + name + ", 전화번호: " + tel + ", 나이: " + age;
		return s;
	}

}
