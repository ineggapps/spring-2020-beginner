package com.aop.after;

public class UserServiceImpl implements UserService {
	private String value;

	@Override
	public void setData(String value) {
		System.out.println("setData 메서드 호출...");
		this.value = value;
	}

	@Override
	public void write() {
//		System.out.println(Integer.parseInt("aa"));//예외가 생기면 aop메서드 호출되지 않음
		System.out.println("결과: " + value);
	}

}
