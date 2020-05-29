package com.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

// xml���� ���� @Configuration������ ������ �����̳� �����ϱ�
// GenericXmlApplicationContext�� �ƴ� AnnotationConfigApplicationContextŬ���� ��ü�� �̿��Ѵ�.

public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//��
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
//			UserBean bean = context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			UserBean bean = (UserBean) context.getBean("demo2.bean");
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
