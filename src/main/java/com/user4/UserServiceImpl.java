package com.user4;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

	//�����δ� �������� ��ü ���� ������ ������ ���̱� ������ ��ü�� ���� �������� �ʴ´�.
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
		String s = "�̸�: " + name + "\n";
		s+="---------------------------------\n";
		s+="-----------ģ�� �ּҷ�------------\n";
		
		Iterator<String> it = address.keySet().iterator();
		while(it.hasNext()) {
			String k = it.next();
			User u = address.get(k);
			
			s += k + ": " + u +"\n";
		}
		s+="---------------------------------\n";
		s+="���-------------------------------\n";
		for(String h : hobby) {
			s += h + " ";
		}
		s += "\n";
		
		return s;
	}

}
