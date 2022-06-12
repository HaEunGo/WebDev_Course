package com.kh.chap4;

import com.kh.chap4.constructor.User;

public class Application {

	public static void main(String[] args) {
		// 1. 기본 생성자로 객체 생성
		User user = new User();
		
		// 필드의 초기화가 되어있지 않기 때문에 JVM이 넣어준 초기값으로 설정되어 있다.
		System.out.println(user.information());
		
		
		// 2. 매개변수가 있는 생성자로 객체 생성 (3개의 값을 생성자로 전달)
		User user2 = new User("abcdeee", "1234", "홍길동");
		
		System.out.println(user2.information());
		
		
		// 3. 매개변수가 있는 생성자로 객체 생성 (5개의 값을 생성자로 전달)
		User user3 = new User("abcd2", "4567", "고길동", 23,'남');
		
		System.out.println(user3.information());
	}

}
