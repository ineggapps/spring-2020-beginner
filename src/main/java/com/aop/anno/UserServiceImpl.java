package com.aop.anno;

public class UserServiceImpl implements UserService {

	@Override
	public int evenSum(int n) {
		System.out.println("Â¦¼ö ÇÕ °è»ê...");
		int s = 0;
		for (int i = 0; i <= n; i += 2) {
			s += i;
		}
		return s;
	}

	@Override
	public void write(int s) {
		System.out.println("Â¦¼öÀÇ ÇÕ: " + s);
	}

}
