package com.kh.chap2;

import com.kh.chap2._class.Person;

public class Application {
	
	public static void main(String[] args) {
		
		Person isname = new Person();
		// Phone 클래스는 접근 제한이 default 클래스로 패키지 외부에서(다른 패키지) 접근이 불가능하다.(Phone 클래스를 가지고 객체 생성 불가)
//		Phone phone = new Phone(); (X)
		
		isname.setName("홍길동");
		isname.setAge(20);
		isname.setPhone("iphone11 pro", "블랙", "애플");
		isname.setPhone("iphone12 미니", "화이트", "애플");

//		System.out.println(isname.whoAreYou());
		isname.whoAreYou();
	}
}
