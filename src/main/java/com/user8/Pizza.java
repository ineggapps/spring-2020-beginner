package com.user8;

import java.util.concurrent.atomic.AtomicLong;

public class Pizza {// 피자 만드는 기계
	// AtomicLong
	// 동시성에 문제가 생기는 것인데 synchronized를 일일이 사용하기가 버겁다.
	// 그러므로 동시성에 문제가 생기는 영역에서 숫자를 증가시킬 경우 Atomic클래스를 이용한다.
	// 동시성을 보장하는 환경 하에서 숫자를 증감할 수 있는 클래스 객체이다.
	private static AtomicLong count = new AtomicLong(0);
	private boolean isVeg;

	public Pizza() {
		count.incrementAndGet();
	}

	@Override
	public String toString() {
		return "새로운 피자 " + (isVeg ? "Veggie" : "") + " Pizza, count(" + count.get() + ")";
	}

	public void setIsVeg(boolean veg) {
		this.isVeg = veg;
	}

}
