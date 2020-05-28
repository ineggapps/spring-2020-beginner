package com.test4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 @Autowired�� @Qualifier��ſ� ����� �� �ִ� @Resource(name="userService1")
 @Resource ������̼��� java���� �⺻������ �����ϴ� ������̼��̴�.
 �⺻������ @Resource�� name�Ӽ��� �����ص� ������, �� 2�� �̻��� ��ü�� ����Ǿ��µ� �⺻id�� ���� ��� �ݵ�� name�Ӽ��� ������ ��� ���ܸ� ���� �� �ִ�.
 * */
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test4/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
