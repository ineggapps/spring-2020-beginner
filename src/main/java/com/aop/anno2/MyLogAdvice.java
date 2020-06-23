package com.aop.anno2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyLogAdvice {
	//인터셉터와 정말 유사한 개념...
	@Around("execution(public * com.aop.anno2.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//메서드 실행 전
		System.out.println("▲ " + pjp.getSignature().getName() + " 실행 전...");
		
		//메서드 실행
		Object obj = pjp.proceed();
		
		//메서드 실행 후
		System.out.println("▲ " + pjp.getSignature().getName() + " 실행 후...");
		
		return obj;
	}
}
