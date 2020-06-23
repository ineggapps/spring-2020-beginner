package com.aop.intercept;

//aspectj�� ��Ű��
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


//MethodInterceptor: �޼��� ���� ��, �� �Ǵ� ���� �߻� ������ �������� ����� ������ �� ����
public class MyLogAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//�ش�Ǵ� �޼����� ���������� ���� MethodInvocation�� �Ѿ�´�.
		
		//��� ��ü ȣ�� ��
		System.out.println("## AOP �޼��� ȣ�� ��: " + invocation.getMethod().getName());
		
		//��� ��ü ȣ��
		Object returnValue = null;
		try {
			returnValue = invocation.proceed();
		} catch (Exception e) {
			System.out.println("#### AOP ȣ�� �� ���� �߻�... " + e.toString());
		}
		
		//��� ��ü ȣ�� ��
		System.out.println("## AOP �޼��� ȣ�� ��: " + invocation.getMethod().getName() + " => ���� ��: " + returnValue);
		
		return returnValue;
	}
	
}
