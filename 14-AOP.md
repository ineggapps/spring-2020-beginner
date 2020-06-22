# AOP

Aspect Oriented Programming
EX: 로그, 트랜잭션

## 1. 정의

관점 지향 프로그래밍 (공통 사항)
예를 들어 데이터베이스에 삽입, 수정, 삭제할 때 Connection을 가져와서 연결하고, 끊는 일련의 작업은 겹치는 부분이다.
이렇게 공통적으로 사용하는 작업을 별도로 작성하고 각각의 작업을 수행할 때마다 자동으로 실행되게끔 하는 것이 AOP라고 생각하면 된다.
마치 필터, 인터셉터와 같이 선행 작업이 수행된다고 생각하면 된다.
스프링 시큐리티도 내부적으로는 AOP로 구현되어 있다고 생각하면 된다. (사실 필터)

### 참고: 스프링 3대 기능

1. MVC
2. DI
3. AOP

## 2. AOP

1. Advice 클래스 작성: 공통 관심사항을 담고 있는 클래스 (공통사항 코드) => 공통사항을 따로 빼내 기술한다.
   1-1. 해당 메서드를 부르기 전에 실행
   1-2. 해당 메서드를 부르고 난 후에 실행
   1-3. 해당 메서드 부르기 전과 후
   1-4. namespace
   1-5. 어노테이션
   1-6. 트랜잭션

```xml
<!--실행 클래스에서 이 bean을 직접 생성요청하면 AOP적용이 되지 않는다는 것에 유의한다. 반드시 AOP가 설정적용된 bean의 id를 생성해야 한다.-->
<bean id="userServiceTarget" class="com.aop.before.UserServiceImpl" />

<!-- Advice -->
<bean id="BeforeAdvice" class="com.aop.before.BeforeLogAdvice" />
```

2. Pointcut: Joinpoint의 부분집합으로 실제 Advice가 적용되는 Joinpoint => 어떤 메서드에 적용할 것인지를 기술한다.

   - Pointcut은 Joinpoint의 부분집합으로서 어떤 메서드에 해당 Advice를 적용할지를 명세로 정의한 것.
   - 정규식이나 AspectJ의 문법을 사용한다.
   - Joinpoint: Advice를 적용할 지점(메서드 호출, 필드값 변경 등)

```xml
<!-- Pointcut -->
<bean id="myPointcut"
    class="org.springframework.aop.support.JdkRegexpMethodPointcut">
    <property name="pattern" value=".*write.*" />
</bean>
```

3. Advisor 설정: Advice와 Pointcut를 연결하는 작업 => 연결점을 설정한다.

   - Advisor에서는 Pointcut에서 명시한 명세와 Advice를 연결하는 작업을 수행

```xml
<!-- Advisor 설정 -->
<bean id="userAdvisor"
    class="org.springframework.aop.support.DefaultPointcutAdvisor">
    <property name="advice" ref="BeforeAdvice" />
    <property name="pointcut" ref="myPointcut" />
</bean>
```

4. AOP 적용 - org.springframework.aop.framework.ProxyFactoryBean 클래스를 이용하여 대상 빈 객체에 Advice를 적용

```xml
<!-- AOP 적용 -->
<bean id="userService" class="org.springframework.aop.framework.ProxyFactoryBean">
<!--target: 어떤 클래스의 메서드를 불렀을 때?-->
<property name="target" ref="userServiceTarget" />
<!--interceptorNames: 어떤 연결점을 설정?-->
<property name="interceptorNames">
    <list>
        <value>userAdvisor</value>
    </list>
</property>
</bean>
```

===============

5. 실행 클래스 작성

```java
package com.aop.before;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:com/aop/before/applicationContext.xml");
        try {
            UserService service = (UserService)context.getBean("userService");
            // APO적용된 bean의 did인 userService를 불러오는 것이 타당 (userServiecTarget을 바로 불러오면 AOP적용이 되지 않음.)
            service.setValue("AOP 예제");
            service.write();
        } finally {
            context.close();
        }
    }
}
```
