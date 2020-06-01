# MVC 프로젝트 사용하기

- 스프링 MVC 프로젝트에서도 마찬가지로 서블릿이 내부에 존재한다.
- 이 서블릿을 이용하여 웹 서비스를 제공한다.

1. 웹브라우저가 요청을 Dispatcher 서블릿에 전송
2. 요청URL과 매칭되는 컨트롤러를 HandlerMapping에서 검색
3. HandlerAdapter에게 처리를 요청하면 Spring bean 컨트롤러에서 실행하고 결과를 반환
4. 컨트롤러 실행 결과를 ModelAndView로 변환하여 다시 Dispatcher Servlet으로 반환
5. 컨트롤러의 실행 결과를 보여줄 View를 ViewResolver에서 검색
6. View가 응답을 만들고 JSP를 만듦
7. 최종적으로 클라이언트(웹브라우저)에 결과를 반환

```xml
<servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 환경설정파일이 언급되어있지 않으면 dispatcher.xml -->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/mvc-config.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
```

## @Service

- 각 프로젝트별 비지니스 로직을 처리하는 클래스에 붙인다.

## @Controller

- 객체 생성 및 컨트롤러 역할

### @RequestMapping

- 해당 URI를 처리하도록 주소를 매핑하기 위한 어노테이션
- method속성을 명시하지 않으면 GET방식과 POST방식 모두를 처리한다.

### @GetMapping, @PostMapping

- @GetMapping과 @PostMapping이 지원되지 않는 경우에는 @RequestMapping을 이용하여 다음과 같이 설정한다.

```java
@RequestMapping(value = "user2/request", method = RequestMethod.GET)
	public String form() {
		return "user2/write";// 뷰(jsp) 이름
	}

@RequestMapping(value = "user2/request", method = RequestMethod.POST)
public ModelAndView submit(String name, String tel, int age) {
    // 메서드의 인수명과 request 파라미터의 이름이 동일한 경우 파라미터를 전달받는다.
    String s = service.message(age);
    // ModelAndView: 컨트롤러 처리 결과를 보여줄 뷰와 뷰에 전달할 값을 저장하는 용도
    ModelAndView mav = new ModelAndView("user2/view");//생성자의 인수는 뷰이름이 들어가면 된다.
    mav.addObject("name", name);
    mav.addObject("tel", tel);
    mav.addObject("result", s);
    return mav;
}
```

## @Repository

- DB작업 등 로그를 출력할 때 유리 (추후 정리 필)

## 리턴 타입

### String

- mvc-config.xml에 선언된 prefix와 postfix를 제외한 나머지 주소를 반환하면 viewResolver가 결합하여 view페이지를 가져다 반환할 것이다.
- 매개변수 Model객체를 통하여 addAttribute메서드를 이용하여 jsp(뷰) 단으로 데이터를 전달할 수 있다.
- Model객체의 장점은 Map처럼 제네릭을 사용하지 않아도 된다는 점이다.

```java
@RequestMapping(value = "user2/request", method = RequestMethod.GET)
	public String form() {
		return "user2/write";// 뷰(jsp) 이름
	}
```

- 참고: /WEB-INF/mvc-config.xml 에는 viewResolver bean 객체에 관한 정보가 담겨 있다.

```xml
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="order" value="1" />
    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
    <property name="prefix" value="/WEB-INF/view/" />
    <property name="suffix" value=".jsp" />
</bean>
```

### ModelAndView

- View의 경로와 이름을 생성자로 전달한다.
- addObject의 메서드를 이용하여 jsp(뷰) 단으로 데이터를 전달할 수 있다.
- 매개변수를 input태그의 name속성의 이름과 일치하게 설정하면 파라미터에 값이 설정되어 자동으로 넘어 온다.
- 만약에 input태그의 name속성의 이름과 하나라도 일치하지 않으면 다음의 예외가 발생한다.

> input태그의 name 속성이 age인 경우에서 age1로 변경한 경우 (public ModelAndView submit(String name, String tel, int age) )
>
> > 그런데 int는 null타입을 가질 수 없다. 그러므로 예외가 발생한다.
> >
> > > org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.IllegalStateException: Optional int parameter 'age' is present but cannot be translated into a null value due to being declared as a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.

```java
@RequestMapping(value = "/user2/request", method = RequestMethod.POST)
public ModelAndView submit(String name, String tel, int age) {
    // 메서드의 인수명과 request 파라미터의 이름이 동일한 경우 파라미터를 전달받는다.
    String s = service.message(age);
    // ModelAndView: 컨트롤러 처리 결과를 보여줄 뷰와 뷰에 전달할 값을 저장하는 용도
    ModelAndView mav = new ModelAndView("user2/view");//생성자의 인수는 뷰이름이 들어가면 된다.
    mav.addObject("name", name);
    mav.addObject("tel", tel);
    mav.addObject("result", s);
    return mav;
}
```

### @ModelAttribute("항목명") 🍟

- Model 객체나 Map 등을 사용하지 않아도 파라미터 앞에 이 어노테이션을 붙이면 바로 전달이 가능하다.
- 메서드의 인수에서 사용되는 경우 JSP파일에 반환되는 Model 객체에 속성값을 주입하거나 바인딩할 수 있음.
- req.setAttribute("항목명", 객체)와 동일한 효과를 낸다.
- 그런데 @ModelAttribute가 메서드의 윗부분에 설정된 경우 @ModelAttribute는 @RequestMapping보다 먼저 실행된다. 이 경우 @REquestMapping이 적용되지 않는 별도의 메서드에서 모델에 추가될 객체를 생성한다.

=== 이하 정리 필요

### Map

- 요청 주소(RequestMapping으로 설정한 URL)가 곧 view의 주소가 된다.

### void

- 파일의 다운로드를 제어할 때 사용

## 메서드의 매개변수

### Model 객체로 받기

- Model객체에 담긴 정보는 view에서도 \${el} 태그를 활용하여 데이터를 참조할 수 있다.

### HttpRequest, HttpResponse, HttpSession 등

- 기존 서블릿에서 사용했던 Request, Response, Session 객체도 파라미터에 추가하면 추가로 사용이 가능하다.

## 메서드의 파라미터

- 파라미터를 통해서 GET 또는 POST방식으로 데이터를 요청한 값을 Controller단에서 받아서 처리할 수 있다.
- 받아서 처리하는 방식에는 2가지가 있다. input태그의 name속성값과 이름이 일치하면 된다.
- 단, 기본자료형은 null값을 가질 수 없고 형이 맞지 않는 경우에는 오류가 날 수 있으므로 이에 관한 예외 처리가 필요하다.

### DTO 타입으로 받기

- 파라미터 이름과 일치한 자료형을 이용하여 값을 전달받을 수 있다.
- checkbox와 같이 여러 개의 값을 받는 경우에는 List<>와 같은 자료형을 선언하여 받을 수도 있다.

### 하나씩 받기

- checkbox와 같이 여러 개를 선택하는 경우에는 String이나 String[]로 받을 수 있다.
- String: ","로 구분지어 넘어옴
- String[]: 각 요소가 배열 원소 단위로 넘어 온다. 하지만, null체크를 꼭 해줘야 한다. (모두 체크하지 않고 전송하였을 경우의 수)
- @RequestParam 어노테이션을 이용한 List<> 선언도 가능하다
  - 어노테이션을 명시하지 않으면 Request processing failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [java.util.List]: Specified class is an interface 예외가 발생한다.
  - 그러나 @RequestParam을 붙인다고 하더라도 아무것도 보내오지 않으면(null이면) 예외가 발생한다. 그러므로 @RequestParam(required=false) 옵션을 붙여야 한다.
    - required 옵션을 붙이지 않은 경우: Required List parameter '항목명' is not present 예외 발생

### Map<String, String> 으로 받기

- 반드시 @RequestParam 어노테이션으 랑ㅍ에 선언하여야 정상적으로 수신이 가능하다. (없으면 null로 수신)
- 이름이 동일한 파라미터(ex: checkbox로 선택된 항목)는 단 한 개만의 요소로 넘어 온다.
  - 왜냐하면 Map은 해시 구조를 따르기 때문에 중복적으로 데이터 삽입이 불가능하기 때문이다.
  - 굳이 Map으로 같은 항목명 이하 (checkbox) 여러 항목을 수신하고 싶다면 name을 배열처럼 (name[0]) 수신하여 Iterator을 이용하여 값을 찾는다.

```html
<input type="checkbox" name="hobby[0]" value="운동" /> 운동하기
<input type="checkbox" name="hobby[1]" value="음악" /> 음악감상
<input type="checkbox" name="hobby[2]" value="웃기" /> 수업시간에 웃기
<input type="checkbox" name="hobby[3]" value="영화" /> 영화감상
<input type="checkbox" name="hobby[4]" value="여행" /> 여행하기
```

```java
Iterator<String> it = paramMap.keySet().iterator();
while(it.hasNext()) {
    String key = it.next();
    if(key.startsWith("hobby")) {
        String value = paramMap.get(key);
        s += value + " ";
    }
}
```

### Redirect할 때 값을 같이 넘기는 방법 (1회성, addFlashAttribute)

- 아래의 방법은 리다이렉트를 할지라도 값을 전달할 수 있으며, 단 1회만 가능하다.
- 리다이렉트를 한 최초 1회에는 값이 온전히 전달되지만, 이후에 새로고침을 한 경우 값이 넘어오지 않는다는 것에 주의한다.
- ex: 쇼핑몰의 구매 직후 구매 완료 안내 페이지, 회원정보 수정 완료 후 수정된 정보를 보여주고자 할 때 등.
- 내부적으로 세션으로 구현되어 있음.

1. 처리하는 메서드에서 RedirectAttributes 파라미터를 추가한다.

```java
@RequestMapping(value="/test3/request", method=RequestMethod.POST)
public String submit(User dto, RedirectAttributes rattr) {
    rattr.addFlashAttribute("dto",dto);
    rattr.addFlashAttribute("msg","end...");
}
```

2. 리다이렉트하는 곳에서 매개변수에 @ModelAttribute("항목명") 자료형 변수명을 받는다.

```java
@RequestMapping("/test3/show")
public String view(@ModelAttribute("dto") User dto) {// 위에서 보낸 dto를 받는 방법...
    System.out.println(dto.getName() + "... flashAttribute 테스트 중"); // 중간에 연산이 필요한 경우 @ModelAttribute 어노테이션을 붙이고 매개변수를 받아내면 된다.
    return "test3/view";
}
```

```java
@RequestMapping("/test3/show")
public String view(/*@ModelAttribute("dto") User dto*/) {// 위에서 보낸 dto를 받는 방법...
    //그런데 중간에 연산할 필요가 없다면 굳이 파라미터를 명시하여 받아 낼 필요가 없다.
    // jsp로 출력하고자만 한다면 명시하지 않아도 된다는 뜻이다.
    return "test3/view";
}
```

- 분명 리다이렉트되었지만 값은 분명 주소창의 GET파라미터를 이용하지 않고 잘 전달되었다.
