package com.aop.intercept;

public class UserServiceImpl implements UserService {

	@Override
	public int sum(int n) {
		System.out.println("�� ���ϱ�... �޼��尡 ȣ��Ǿ���...");
		int s=0;
		for(int i=1;i<=n;i++) {
			s+=i;
		}
		return s;
	}

	@Override
	public void write(int s) {
		System.out.println("���: " + s);
	}

}
