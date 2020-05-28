package com.user7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/user7/applicationContext.xml");

		try {
			//prototype:객체를 컨테이너에서 호출할 때마다 객체를 생성
			Movie mv1 = context.getBean(Movie.class); // 프로토타입
			Movie mv2 = context.getBean(Movie.class); //

			Music ms1 = context.getBean(Music.class);// 프로토타입
			Music ms2 = context.getBean(Music.class);//

			System.out.println(mv1 + ", " + mv2); // 서로 다른 객체이다.
			System.out.println(ms1 + ", " + ms2); // 서로 다른 객체이다.

			System.out.println("-----------------------------");

			Movie mv = context.getBean(Movie.class);
			Music ms = context.getBean(Music.class);
			
			//mv는 객체를 getBean을 한 번 했으므로 두 개의 play메서드의 결괏값은(해시) 같다.
			
			mv.play();
			mv.play();
			
			//분명히 applicationContext.xml에서 scope를 prototype으로 설정하였으므로 객체가 호출될 때만 생성되어야 한다.
			//그런데 Music클래스 객체의 경우에는 객체가 여러 번 실행된다는 것을 알 수 있다.
			//<aop:scoped-proxy/>
			// 
			
			ms.play();
			ms.play();
			
			System.out.println("-----------------------------");
			UserBean bean = context.getBean(UserBean.class); // 객체 호출
			// UserBean의 Movie와 Music은 applicationContext에서 객체를 1번밖에 호출하지 않았으므로
			// 실행할 때마다 해시값은 바뀌지 않는 것을 확인할 수 있다.
			bean.execute();
			bean.execute();
			bean.execute();
			System.out.println("-----------------------------");

			
		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}
