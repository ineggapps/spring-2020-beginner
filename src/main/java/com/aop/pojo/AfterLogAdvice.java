package com.aop.pojo;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

//AfterReturningAdvice: ��� ��ü�� �޼��带 ���� ���Ŀ� ���� ����� ������ �� ���
//���ܾ��� ����Ǵ� ��쿡�� ����ȴ�
public class AfterLogAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("## after aop ����");

		String s = method.toString() + " �޼��� : " + target + "�� ����ǰ� �� �� ȣ���...";
		s+= "\n��ȯ�Ǵ� ��: " + returnValue;
		System.out.println("aop ���: " +  s);
		
		System.out.println("## after aop ��");
	}
}
