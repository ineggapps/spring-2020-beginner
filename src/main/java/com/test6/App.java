package com.test6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 @PostConstrcut: �����ڰ� ����� ���� ȣ��Ǵ� init �޼���� xml���� bean�Ӽ��� init-method�� ����
 @PreDestroy: �ڿ��� ������ ������ ȣ��Ǵ� destroy �޼���� xml���� bean �Ӽ��� destroy-method�� ����
  */
public class App {
	public static void main(String[] args) {
		// �����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		// ������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/test6/applicationContext.xml");

		try {
			// �����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean(UserBean.class);// ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();
		} finally {
			context.close();// ���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
