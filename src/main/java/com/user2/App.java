package com.user2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʿ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user2/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean("userBean");
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
