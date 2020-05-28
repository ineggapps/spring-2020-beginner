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

- 스프링에서 scope를 prototype을 지정한 경우 객체를 요청할 때마다 생성하여 반환한다.

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
