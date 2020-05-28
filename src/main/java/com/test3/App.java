package com.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
@Autowired��
@Qualifier("userService2")�� �̿��Ͽ� id�ĺ��� �����ϱ�
Autowired�� �� �� �̻��� bean��ü�� ����Ǹ� Ŭ�����̸��� �⺻id�ĺ���(Ŭ���� ù ���ڸ� �ҹ��ڷ� �ٲ� ����)�� �⺻���� �ν��ϴµ�, 
�� Ŭ������ �������� �ʴ� ��� ���ܰ� �߻��Ѵ�. �̷��� ��츦 ����Ͽ� Qualifier�� �̸� id�� �����ϸ� ���ܸ� ���� �� �ִ�.
 * */
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test3/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
