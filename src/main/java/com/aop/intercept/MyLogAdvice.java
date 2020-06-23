package com.aop.intercept;

//aspectj의 패키지
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


//MethodInterceptor: 메서드 실행 전, 후 또는 예외 발생 시점에 공통적인 기능을 실행할 수 있음
public class MyLogAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//해당되는 메서드의 상태정보를 가진 MethodInvocation이 넘어온다.
		
		//대상 객체 호출 전
		System.out.println("## AOP 메서드 호출 전: " + invocation.getMethod().getName());
		
		//대상 객체 호출
		Object returnValue = null;
		try {
			returnValue = invocation.proceed();
		} catch (Exception e) {
			System.out.println("#### AOP 호출 중 예외 발생... " + e.toString());
		}
		
		//대상 객체 호출 후
		System.out.println("## AOP 메서드 호출 전: " + invocation.getMethod().getName() + " => 리턴 값: " + returnValue);
		
		return returnValue;
	}
	
}
