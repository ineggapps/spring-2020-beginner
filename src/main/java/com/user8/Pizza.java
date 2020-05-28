package com.user8;

import java.util.concurrent.atomic.AtomicLong;

public class Pizza {// ���� ����� ���
	// AtomicLong
	// ���ü��� ������ ����� ���ε� synchronized�� ������ ����ϱⰡ ���̴�.
	// �׷��Ƿ� ���ü��� ������ ����� �������� ���ڸ� ������ų ��� AtomicŬ������ �̿��Ѵ�.
	// ���ü��� �����ϴ� ȯ�� �Ͽ��� ���ڸ� ������ �� �ִ� Ŭ���� ��ü�̴�.
	private static AtomicLong count = new AtomicLong(0);
	private boolean isVeg;

	public Pizza() {
		count.incrementAndGet();
	}

	@Override
	public String toString() {
		return "���ο� ���� " + (isVeg ? "Veggie" : "") + " Pizza, count(" + count.get() + ")";
	}

	public void setIsVeg(boolean veg) {
		this.isVeg = veg;
	}

}
