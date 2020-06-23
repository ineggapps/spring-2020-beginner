package com.aop.pojo;

import org.aspectj.lang.JoinPoint;

public class MyLogAdvice {//상속을 받은 게 아니네.. (aspectj를 통해서 해야 한다)
	//JoinPoint: 어떤 메서드가 호출되었는지 참조하기 위한 객체
	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop beforeLogging => " + methodName);
		
		return methodName;
	}
	
	public void returningLogging(JoinPoint joinPoint, Object ret) {
		//예외가 발생하면 실행되지 않는 메서드
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop returningLogging => " + methodName + ", 리턴값: "+ ret);
	}
	
	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop throwingLogging => " + methodName + ", 예외클래스: " + ex.getClass().getName());
	}
	
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("■ aop afterLogging: 예외발생 여부와 상관없이 실행. (finally...)" + methodName);
	}
}
