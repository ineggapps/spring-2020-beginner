package com.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// ��ü ����. id�� �ڵ����� ù���ڰ� �ҹ����� Ŭ�������� �ο��ȴ�.
// ���̵�: userBean
// �׷��� ���̵� ���� ���� xml ������ �ߺ��� ���� �� ����. 
// ������, xml�ɼǿ��� <context:component-scan base-package="com.*"/>�� �����Ͽ��� Ŭ�������� ��ġ�� ��쿡�� �浹�� ���Ƿ� ������ �� ����.
@Component
public class UserBean {
	
	@Autowired
	private UserService userService;// �������̽��� �������踦 ������ �ִ� UserBean

	public void write() {
		String m = userService.message();
		System.out.println(m);
	}

	
}
