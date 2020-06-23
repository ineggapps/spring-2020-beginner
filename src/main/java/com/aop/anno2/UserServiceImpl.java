package com.aop.anno2;

public class UserServiceImpl implements UserService {

	@Override
	public int sum(int n) {//재귀호출될 때마다 aop메서드가 반응하는 것은 아니다. (최초에 실행 전과 후 단 한 번씩)
		System.out.println("재귀호출을 이용한 합 구하기");
		return n > 1 ? n + sum(n - 1) : n;
	}

	@Override
	public void write(int s) {
		System.out.println("결과: " + s);
	}

}
