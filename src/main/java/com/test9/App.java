package com.test9;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 xml에서처럼 scope 속성을 지정할 수 있다.
 @Scope(value="prototype")
 * */
public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/test9/applicationContext.xml");

		try {
			// 컨테이너에서 해당 객체 가져오는 방법
			Movie mv1 = context.getBean(Movie.class);
			Movie mv2 = context.getBean(Movie.class);

			Music ms1 = context.getBean(Music.class);
			Music ms2 = context.getBean(Music.class);

			mv1.play();
			mv2.play();

			ms1.play();
			ms2.play();
			
			if(mv1==mv2) {
				System.out.println("mv1, mv2 는 같은 객체이다.");
			}else {
				System.out.println("mv1, mv2 는 다른 객체이다.");
			}
			
			if(ms1==ms2) {
				System.out.println("ms1, ms2는 같은 객체이다.");
			}else {
				System.out.println("ms1, ms2는 다른 객체이다.");
			}

		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
