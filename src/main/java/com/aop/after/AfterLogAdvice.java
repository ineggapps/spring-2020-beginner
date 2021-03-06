package com.aop.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

//AfterReturningAdvice: 대상 객체의 메서드를 실행 이후에 공통 기능을 실행할 때 사용
//예외없이 실행되는 경우에만 실행된다
public class AfterLogAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("=====================aop 시작=====================");
		String s = method.toString() + " 메서드 : " + target + "가 실행되고 난 후 호출됨...";
		s+= "\n반환되는 값: " + returnValue;
		System.out.println("aop 결과: " +  s);
		System.out.println("aop 끝===========================================");
	}
}
