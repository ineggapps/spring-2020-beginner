package com.aop.before;

public class UserServiceImpl implements UserService {

	private String value;

	public UserServiceImpl() {
		value = "�׽�Ʈ ...";
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public void write() {
		System.out.println(value);
	}

}
