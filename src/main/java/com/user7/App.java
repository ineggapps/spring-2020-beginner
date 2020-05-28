package com.user7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// �����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		// ������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/user7/applicationContext.xml");

		try {
			//prototype:��ü�� �����̳ʿ��� ȣ���� ������ ��ü�� ����
			Movie mv1 = context.getBean(Movie.class); // ������Ÿ��
			Movie mv2 = context.getBean(Movie.class); //

			Music ms1 = context.getBean(Music.class);// ������Ÿ��
			Music ms2 = context.getBean(Music.class);//

			System.out.println(mv1 + ", " + mv2); // ���� �ٸ� ��ü�̴�.
			System.out.println(ms1 + ", " + ms2); // ���� �ٸ� ��ü�̴�.

			System.out.println("-----------------------------");

			Movie mv = context.getBean(Movie.class);
			Music ms = context.getBean(Music.class);
			
			//mv�� ��ü�� getBean�� �� �� �����Ƿ� �� ���� play�޼����� �ᱣ����(�ؽ�) ����.
			
			mv.play();
			mv.play();
			
			//�и��� applicationContext.xml���� scope�� prototype���� �����Ͽ����Ƿ� ��ü�� ȣ��� ���� �����Ǿ�� �Ѵ�.
			//�׷��� MusicŬ���� ��ü�� ��쿡�� ��ü�� ���� �� ����ȴٴ� ���� �� �� �ִ�.
			//<aop:scoped-proxy/>
			// 
			
			ms.play();
			ms.play();
			
			System.out.println("-----------------------------");
			UserBean bean = context.getBean(UserBean.class); // ��ü ȣ��
			// UserBean�� Movie�� Music�� applicationContext���� ��ü�� 1���ۿ� ȣ������ �ʾ����Ƿ�
			// ������ ������ �ؽð��� �ٲ��� �ʴ� ���� Ȯ���� �� �ִ�.
			bean.execute();
			bean.execute();
			bean.execute();
			System.out.println("-----------------------------");

			
		} finally {
			context.close();// ���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
