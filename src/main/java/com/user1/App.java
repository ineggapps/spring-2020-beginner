package com.user1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 xml���� ��ü ���� �� �����ϱ�
*/
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/user1/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean("userBean");
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
