package com.aop.after;

public class UserServiceImpl implements UserService {
	private String value;

	@Override
	public void setData(String value) {
		System.out.println("setData �޼��� ȣ��...");
		this.value = value;
	}

	@Override
	public void write() {
//		System.out.println(Integer.parseInt("aa"));//���ܰ� ����� aop�޼��� ȣ����� ����
		System.out.println("���: " + value);
	}

}
