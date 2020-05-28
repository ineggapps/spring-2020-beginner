package com.user5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// �����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		// ������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user5/applicationContext.xml");

		try {
			// �����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = context.getBean(UserBean.class);// ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();

			UserBean2 bean2 = context.getBean(UserBean2.class);// ĳ�������� �ʾƵ� �Ǵ� ����
			bean2.write();
		} finally {
			context.close();// ���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
