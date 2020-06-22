# AJAX 요청하는 방법

## 1. HTML raw 코드

## 2. JSON

### 2-1. @ResponseBody어노테이션 명시 + Map 객체로 반환

### 2-2. @RestController을 이용하여 JSON객체 반환

    - @ResponseBody 어노테이션이 필요하지 않다. 그러나 Springframework4 이후 버전부터 가능하다.

## 3. XML

### 3-1. JAVA코드(PrintWriter, String)를 이용한 방법

### 3-2. jsp를 이용한 방법

### 3-3. Xml관련 어노테이션을 DTO클래스에 명시한 객체를 이용한 방법

## TODO.

### RestfulAPI

- REpresentational State Transfer ful
- 대표적인 상태 전달
- 자원을 URI로 표시하고 해당 자원의 상태를 주고 받는 것

[REST API와 RESTful API](https://velog.io/@stampid/REST-API%EC%99%80-RESTful-API)

### Promise

- 자바스크립트 코드가 비동기로 작동하게 되면 함수의 실행이 완료되어야만 작업을 수행할 수 있는 것들이 있다.
  이럴 때 이벤트 리스너를 호출하도록 하는 방식으로 작업을 수행하지만, 비동기로 작업해야 하는 일련의 작업들이 많아질 때는 콜백헬이라고 불릴 만큼 코드의 가독성이 떨어진다.
- 이때 비동기 작업을 추상화시키는 목적으로 Promise라는 개념을 자바스크립트에 도입하였음.
- Promise 프로토타입 객체를 새로 만들고 일련의 작업들을 명시한 뒤 then메서드를 호출하면
