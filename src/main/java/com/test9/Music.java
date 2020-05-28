package com.test9;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Music {
	public void play() {
		System.out.println("À½¾Ç: " + toString());
	}
}
