# 룩업 메서드 인젝션

- 컨테이너가 관리하는 빈의 메서드를 재정의하여 컨테이너에 있는 다른 빈을 찾을 수 있도록 하는 기능이다.
- 기본적으로 인터페이스에서도 가능하다.
- 그러나 다음의 규칙을 따라야 한다. (룩업 메서드 인젝션 규칙)
  1. 접근제어자는 반드시 public, protected여야 한다.
  2. 메서드의 반환 자료형이 void이면 안 된다.
  3. 인잣값(매개변수)는 없어야 한다. ()
  4. 추상 메서드로도 가능하다.
  5. final은 재정의할 수 없으므로 예약어를 사용해서는 안 된다.
- 단지 메서드의 반환형에 맞게 객체를 반환"만"해주는 것이므로 추상 메서드에 로직을 추가하거나 명세할 수는 없다. (어찌 보면 당연.. 그러므로 추상클래스를 직접 구현하지 않고 스프링 단에서 구현된 객체가 넘어온다고 해서 놀랄 필요는 없다.)

## 참고: 동시성 제어

- 연산이 빠른 환경에서는 동시성의 제어가 중요해진다. 그런데 동시성의 문제를 제어하고자 synchronized 블록을 자주 사용하기가 번거롭다. 따라서 숫자를 증감시킬 떄는 Atomic클래스를 사용하여 코드를 작성한다.

```java
	// AtomicLong
	// 동시성에 문제가 생기는 것인데 synchronized를 일일이 사용하기가 버겁다.
	// 그러므로 동시성에 문제가 생기는 영역에서 숫자를 증가시킬 경우 Atomic클래스를 이용한다.
	// 동시성을 보장하는 환경 하에서 숫자를 증감할 수 있는 클래스 객체이다.
public class 클래스명{
	private static AtomicLong count = new AtomicLong(0);
}
```

- 룩업 메서드를 이용하면 추상 클래스를 직접 상속하여 메서드를 구현하지 않고 lookup-method속성을 이용하면 스프링 단에서 구현이 된다.

> Pizza.java

```java
import java.util.concurrent.atomic.AtomicLong;

public class Pizza {// 피자 만드는 기계
	// AtomicLong
	// 동시성에 문제가 생기는 것인데 synchronized를 일일이 사용하기가 버겁다.
	// 그러므로 동시성에 문제가 생기는 영역에서 숫자를 증가시킬 경우 Atomic클래스를 이용한다.
	// 동시성을 보장하는 환경 하에서 숫자를 증감할 수 있는 클래스 객체이다.
	private static AtomicLong count = new AtomicLong(0);
	private boolean isVeg;

	public Pizza() {
		count.incrementAndGet();
	}

	@Override
	public String toString() {
		return "새로운 피자 " + (isVeg ? "Veggie" : "") + " Pizza, count(" + count.get() + ")";
	}

	public void setIsVeg(boolean veg) {
		this.isVeg = veg;
	}

}

```

> PizzaShop.java

```java
public abstract class PizzaShop {
	//추상클래스를 스프링 컨테이너에 넘겨서 스프링에 구현을 위탁할 수도 있다... (오!!!???)
	public abstract Pizza makePizza();
	public abstract Pizza makeVeggiePizza();
}
```

> App.java

```java
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		// 생성하고자 하는 객체를 가지고 있는 것은 xml파일이다. (applicationContext.xml)
		// 스프링 컨테이너를 생성하는 구문
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:com/user8/applicationContext.xml");

		try {
			PizzaShop shop = context.getBean(PizzaShop.class);

			Pizza p1 = shop.makePizza();
			System.out.println("처음: " + p1);

			Pizza p2 = shop.makePizza();
			System.out.println("두 번째: " + p2);

			Pizza p3 = shop.makeVeggiePizza();
			System.out.println("세 번째: " + p3);

		} finally {
			context.close();// 리소스 개념이므로 자원을 닫아야 한다.
		}
	}
}

```

- 분명히 추상클래스를 구현하지 않았다.
- 그런데...

> ApplicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- -->
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:util="http://www.springframework.org/schema/util"
	xmlns:task="http://www.springframework.org/schema/task"
	xsi:schemaLocation="
		    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
			http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd
	        http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task.xsd">

	<!-- 일반 피자 -->
	<bean id="pizza" class="com.user8.Pizza" scope="prototype" />
	<!-- 배지 피자 -->
	<bean id="veggiePizza" class="com.user8.Pizza" scope="prototype">
		<property name="isVeg" value="true" />
	</bean>

	<bean id="pizzaShop" class="com.user8.PizzaShop">
		<lookup-method name="makePizza" bean="pizza"/>
		<lookup-method name="makeVeggiePizza" bean="veggiePizza" />
	</bean>

</beans>
```

- 위와 같이 lookup-method로 메서드이름(name)과 반환되는 객체식별자(bean)을 명시하면 추상 클래스를 알아서 구현하여 객체를 생성하고 반환해 준다.
