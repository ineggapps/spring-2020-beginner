package com.user8;

public abstract class PizzaShop {
	//추상클래스를 스프링 컨테이너에 넘겨서 스프링에 구현을 위탁할 수도 있다... (오!!!???)
	public abstract Pizza makePizza();
	public abstract Pizza makeVeggiePizza();
}