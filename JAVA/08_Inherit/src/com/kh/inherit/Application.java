package com.kh.inherit;

import com.kh.inherit.after.Desktop;
import com.kh.inherit.after.SmartPhone;
import com.kh.inherit.after.Tv;
import com.kh.inherit.override.Book;

public class Application {

	public static void main(String[] args) {
		// Desktop 객체 생성
		Desktop desktop = new Desktop("애플", "a1111", "imac 24'", 2000000, true);
		
		// SmartPhone 객체 생성
		SmartPhone phone = new SmartPhone("애플", "a2222", "iphone 12mini", 1000000, "SK");
		
		// TV 객체 생성
		Tv tv = new Tv("LG", "t-01", "OLED 벽걸이 TV", 2500000, 60);

		// 출력
		System.out.println(desktop.information());
		System.out.println(phone.information());
		System.out.println(tv.information());
		
		// 오버라이딩 테스트
		Book book1 = new Book("자바의 정석","남궁 성", 3000);
		Book book2 = new Book("자바의 정석","남궁 성", 3000);

		// toString() 테스트
		System.out.println(book1);
//		System.out.println(book1.toString());	// .information 대신 사용
		System.out.println();
		
		// equals() 테스트
		System.out.println("book1과 book2가 같은 책 입니까?" + (book1 == book2));
		System.out.println("book1과 book2가 같은 책 입니까?" + book1.equals(book2));
		System.out.println();
		
		// hashCode() 테스트
		System.out.println("book1의 해시코드 : " + book1.hashCode());	// 객체의 주소값 리턴
		System.out.println("book2의 해시코드 : " + book2.hashCode());
		
		
	}

}
