# 스프링의 Scope 속성

## 싱글톤 (Singleton)

- 스프링에서는 기본적으로 자바 객체를 생성할 때 싱글톤 패턴을 사용한다.

> App.class

```java
    //mv1, mv2는 서로 동일한 객체가 반환된다.
    Movie mv1 = context.getBean(Movie.class);
    Movie mv2 = context.getBean(Movie.class);
```

> applicationContext.xml

```xml
	<bean id="movie" class="com.user6.Movie" />
```

기본적으로 자바의 scope는 싱글톤이다.
호출할 떄마다 동일한 객체가 호출된다.

## 프로토타입(Prototype)

- 객체를 컨테이너에서 호출할 때마다 객체를 생성하여 반환한다.

> App.class

```java
    //m1, m2는 서로 다른 객체이다.
    Music ms1 = context.getBean(Music.class);
    Music ms2 = context.getBean(Music.class);
```

> applicationContext.xml

```xml
	<bean id="music" class="com.user6.Music" scope="prototype"/>
```

### <aop:scoped-proxy>

- 참고로 자주 사용하는 옵션은 아니다.
- beans의 네임스페이스: [xmlns:aop="http://www.springframework.org/schema/aop"](http://www.springframework.org/schema/aop")
- 해당 객체의 메서드를 접근할 떄마다 새로운 객체를 생성하는 옵션이다.
- 다음과 같이 선언하면 된다.

```xml
	<bean id="music" class="com.user7.Music" scope="prototype">
		<aop:scoped-proxy/>
 	</bean>
```
