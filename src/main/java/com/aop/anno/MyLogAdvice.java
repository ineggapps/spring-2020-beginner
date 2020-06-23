package com.aop.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// @Aspect: 자동으로 Advice 적용
@Aspect
public class MyLogAdvice {//상속을 받은 게 아니네.. (aspectj를 통해서 해야 한다)
	
	@Pointcut(value="execution(public * com.aop.anno.*.*(..))")
	private void allMethod() {
		//가명메서드: private void 이고 메서드 몸체가 없어야 함.
		//만들어도 어떠한 구문도 실행되지 않네...
	}
	
	//JoinPoint: 어떤 메서드가 호출되었는지 참조하기 위한 객체
	@Before("execution(public * com.aop.anno.*.*(..))")
	public String beforeLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop beforeLogging => " + methodName);
		
		return methodName;
	}
	
	@AfterReturning(value="allMethod()", returning="ret")
	public void returningLogging(JoinPoint joinPoint, Object ret) {
		//예외가 발생하면 실행되지 않는 메서드
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop returningLogging => " + methodName + ", 리턴값: "+ ret);
	}
	
	@AfterThrowing(value="allMethod()", throwing="ex")
	public void throwingLogging(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("■ aop throwingLogging => " + methodName + ", 예외클래스: " + ex.getClass().getName());
	}
	
	@After("allMethod()")
	public void afterLogging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("■ aop afterLogging: 예외발생 여부와 상관없이 실행. (finally...)" + methodName);
	}
}
