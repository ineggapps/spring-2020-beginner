package com.test9;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 xml����ó�� scope �Ӽ��� ������ �� �ִ�.
 @Scope(value="prototype")
 * */
public class App {
	public static void main(String[] args) {
		// �����ϰ��� �ϴ� ��ü�� ������ �ִ� ���� xml�����̴�. (applicationContext.xml)
		// ������ �����̳ʸ� �����ϴ� ����
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/test9/applicationContext.xml");

		try {
			// �����̳ʿ��� �ش� ��ü �������� ���
			Movie mv1 = context.getBean(Movie.class);
			Movie mv2 = context.getBean(Movie.class);

			Music ms1 = context.getBean(Music.class);
			Music ms2 = context.getBean(Music.class);

			mv1.play();
			mv2.play();

			ms1.play();
			ms2.play();
			
			if(mv1==mv2) {
				System.out.println("mv1, mv2 �� ���� ��ü�̴�.");
			}else {
				System.out.println("mv1, mv2 �� �ٸ� ��ü�̴�.");
			}
			
			if(ms1==ms2) {
				System.out.println("ms1, ms2�� ���� ��ü�̴�.");
			}else {
				System.out.println("ms1, ms2�� �ٸ� ��ü�̴�.");
			}

		} finally {
			context.close();// ���ҽ� �����̹Ƿ� �ڿ��� �ݾƾ� �Ѵ�.
		}
	}
}
