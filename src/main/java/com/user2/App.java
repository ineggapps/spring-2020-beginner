package com.user2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 xml�� ��ü�� ������ �� property �±׸� �̿��Ͽ� Ŭ������ �� �����ϱ�(setter�޼��尡 ����� �־�� �Ѵ�.)
 xml�� ��ü�� ������ �� �����ڸ� �̿��Ͽ� Ŭ������ �� �����ϱ� (constructor-arg �±�)
 
 �����ڷ��� ref �Ӽ����� ��üid ���
 �Ϲ��ڷ����� ���(String����) value="��" ���� ���
 * */
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
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
