package com.user3;

public class UserServiceImpl implements UserService {

	private String name;
	private String tel;
	private int age;

	public UserServiceImpl() { // 기본생성자를 이용하여 생성한다면 반드시 명시해야 하는 부분이다.
//		name = "스프링";
//		tel = "010-1234-1234";
//		age = 20;
	}

	public UserServiceImpl(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
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
