package com.aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// @Aspect: �ڵ����� Advice ����
@Aspect
public class MyLogAdvice2 {//����� ���� �� �ƴϳ�.. (aspectj�� ���ؼ� �ؾ� �Ѵ�)
	//JoinPoint: � �޼��尡 ȣ��Ǿ����� �����ϱ� ���� ��ü
	@Before("execution(public * com.aop.anno.*.*(..))")
	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop beforeLogging => " + methodName);
		
		return methodName;
	}
	
	@AfterReturning(pointcut="execution(public * com.aop.anno.*.*(..))", returning="ret")
	public void returningLogging(JoinPoint joinPoint, Object ret) {
		//���ܰ� �߻��ϸ� ������� �ʴ� �޼���
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop returningLogging => " + methodName + ", ���ϰ�: "+ ret);
	}
	
	@AfterThrowing(pointcut="execution(public * com.aop.anno.*.*(..))", throwing="ex")
	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("�� aop throwingLogging => " + methodName + ", ����Ŭ����: " + ex.getClass().getName());
	}
	
	@After("execution(public * com.aop.anno.*.*(..))")
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("�� aop afterLogging: ���ܹ߻� ���ο� ������� ����. (finally...)" + methodName);
	}
}
