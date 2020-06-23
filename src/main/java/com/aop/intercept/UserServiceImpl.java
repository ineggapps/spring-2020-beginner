package com.aop.intercept;

public class UserServiceImpl implements UserService {

	@Override
	public int sum(int n) {
		System.out.println("합 구하기... 메서드가 호출되었음...");
		int s=0;
		for(int i=1;i<=n;i++) {
			s+=i;
		}
		return s;
	}

	@Override
	public void write(int s) {
		System.out.println("결과: " + s);
	}

}
