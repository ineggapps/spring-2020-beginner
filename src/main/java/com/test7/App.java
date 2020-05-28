package com.test7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 @Component�� ������̼��� �̿��Ͽ� ��ü�� �����Ѵ�.
 �˾Ƽ� ��ü�� �����Ѵ�. ��, id���� @Component("id��")ó�� �������� ������ �⺻id�� �����ȴ�.
 ����, �Ʒ�ó�� ��Ű�� ������� Ŭ������ ��ĵ�� �� @Component�� id���� ��ġ�� ���ܰ� �߻��Ѵٴ� �Ϳ� �����Ѵ�.
 <context:component-scan base-package="com.test7"/>
 * */
public class App {
	public static void main(String[] args) {
		//�����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		//������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:com/test7/applicationContext.xml");
		
		try {
			//�����̳ʿ��� �ش� ��ü �������� ���
			UserBean bean = (UserBean) context.getBean(UserBean.class);//ĳ�������� �ʾƵ� �Ǵ� ����
			bean.write();
		} finally {
			context.close();//���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
