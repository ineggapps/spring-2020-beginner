package com.demo1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// @Configuration�� xml�� �̿��Ͽ� �� ��ü �����ϱ�

public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/demo1/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
//			UserBean bean = context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			UserBean bean = (UserBean) context.getBean("beanDevice");
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
