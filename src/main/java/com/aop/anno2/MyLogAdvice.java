package com.aop.anno2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyLogAdvice {
	//���ͼ��Ϳ� ���� ������ ����...
	@Around("execution(public * com.aop.anno2.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//�޼��� ���� ��
		System.out.println("�� " + pjp.getSignature().getName() + " ���� ��...");
		
		//�޼��� ����
		Object obj = pjp.proceed();
		
		//�޼��� ���� ��
		System.out.println("�� " + pjp.getSignature().getName() + " ���� ��...");
		
		return obj;
	}
}
