package com.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//MethodBeforeAdvice: ��� ��ü�� �޼��带 �����ϱ� "��"�� ���� ����� �����ϰ��� �� �� ����ϴ� Advice 
public class BeforeLogAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String s = "---- �ȿ� �ѷ����� �κ��� Spring�� �ش� �޼��� ȣ�� ���� �θ� before�޼����̴�.\n";
		s += "-----------------------------------------\n";
		s += method.toString() + "�޼��� : " + target + "���� ȣ�� �� ����..";
		if (args != null) {
			s += "\n �Ű�����: ";
			for (int i = 0; i < args.length; i++) {
				s += args[i] + "\t";
			}
		}
		s += "\n-----------------------------------------\n";
		System.out.println(s);
	}

}
