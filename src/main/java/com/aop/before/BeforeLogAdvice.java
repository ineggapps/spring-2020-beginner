package com.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//MethodBeforeAdvice: 대상 객체의 메서드를 실행하기 "전"에 공통 기능을 실행하고자 할 떄 사용하는 Advice 
public class BeforeLogAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String s = "---- 안에 둘러싸인 부분은 Spring이 해당 메서드 호출 전에 부른 before메서드이다.\n";
		s += "-----------------------------------------\n";
		s += method.toString() + "메서드 : " + target + "에서 호출 전 실행..";
		if (args != null) {
			s += "\n 매개변수: ";
			for (int i = 0; i < args.length; i++) {
				s += args[i] + "\t";
			}
		}
		s += "\n-----------------------------------------\n";
		System.out.println(s);
	}

}
