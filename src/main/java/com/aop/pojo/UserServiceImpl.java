package com.aop.pojo;

public class UserServiceImpl implements UserService {

	@Override
	public int oddSum(int n) {
		System.out.println("oddSum()�޼��� ȣ���... Ȧ�� �� ��� ����!!");
		int s = 0;
//		for (int i = 1; i <= n; i += 2) {
//			s += i;
//		}
		int i = 1;
		while (i <= n) {
			s += i;
			i += 2;
		}
		return s;
	}

	@Override
	public void write(int s) {
//		System.out.println(Integer.parseInt("a"));
		System.out.println("Ȧ�� ��: " + s);
	}

}
