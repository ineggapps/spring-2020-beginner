package com.user4;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

	//앞으로는 스프링에 객체 생성 역할을 위임할 것이기 때문에 객체를 직접 생성하지 않는다.
	private String name;
	private Map<String, User> address;
	private List<String> hobby;

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Map<String, User> address) {
		this.address = address;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String message() {
		String s = "이름: " + name + "\n";
		s+="---------------------------------\n";
		s+="-----------친구 주소록------------\n";
		
		Iterator<String> it = address.keySet().iterator();
		while(it.hasNext()) {
			String k = it.next();
			User u = address.get(k);
			
			s += k + ": " + u +"\n";
		}
		s+="---------------------------------\n";
		s+="취미-------------------------------\n";
		for(String h : hobby) {
			s += h + " ";
		}
		s += "\n";
		
		return s;
	}

}
