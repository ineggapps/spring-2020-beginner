package com.aop.pojo;

import org.aspectj.lang.JoinPoint;

public class MyLogAdvice {//����� ���� �� �ƴϳ�.. (aspectj�� ���ؼ� �ؾ� �Ѵ�)
	//JoinPoint: � �޼��尡 ȣ��Ǿ����� �����ϱ� ���� ��ü
	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop beforeLogging => " + methodName);
		
		return methodName;
	}
	
	public void returningLogging(JoinPoint joinPoint, Object ret) {
		//���ܰ� �߻��ϸ� ������� �ʴ� �޼���
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop returningLogging => " + methodName + ", ���ϰ�: "+ ret);
	}
	
	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop throwingLogging => " + methodName + ", ����Ŭ����: " + ex.getClass().getName());
	}
	
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("�� aop afterLogging: ���ܹ߻� ���ο� ������� ����. (finally...)" + methodName);
	}
}
