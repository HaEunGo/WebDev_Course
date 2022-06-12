package com.kh.chap1;

import com.kh.chap1.encapsulation.Student;

public class Application {
	/*
	 * 
	 * 추상화와 캡슐화
	 * 
	 * 1. 추상화
	 * 		- 프로그램에서 사용할 객체들이 가진 공통의 특성을 파악하고 불필요한 특성들을 제거하는 과정을 말한다.
	 * 		- 최종적으로 선정된 속성들을 가지고 어떤 자료형으로, 어떠한 변수명으로 사용할지 정리해서 코드로 작성한다. 
	 * 
	 * 
	 * 2. 캡슐화
	 * 		- 추상화를 통해서 정의된 속성들과 기능을 하나로 묶어서 관리하는 기법 중 하나로
	 * 			클래스의 가장 중요한 목적인 데이터 접근 제한을 원칙으로 외부로부터 데이터의 직접 접근을 막고 대신에 데이터를 간접적으로 처리하는 메소드들을 클래스 내부에 작성하여 제공하는 방법을 말한다.
	 * 		- 객체의 필드, 메소드를 하나로 묶고 실제 구현 내용을 감추는 것을 말한다.
	 * 		- 외부에서 객체의 내부를 알지 못하며 객체가 노출해서 제공하는 필드나 메소드만 이용할 수 있다.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		// 만약에 클래스를 사용하지 않고 변수만을 가지고 프로그램에서 필요한 객체를 만들어 본다면?
		// 홍길동 학생 객체 만들기
		String name = "홍길동";
		int age = 20;
		int id = 1001;
		int mathScore = 90;
		
		// 고길동 학생 객체 만들기
		String name2 = "고길동";
		int age2 = 400;
		int id2 = 1002;
		int mathScore2 = 30;
		
		// 클래스를 만들고 나서 객체로 만들기 위해서는 new 연산자를 통해서 Heap 영역에 생성해야 한다.
//		Student hong = new Student();	// 인스턴스(객체) 생성
//		Student go = new Student();
		
		// 필드에 직접 접근해서 값을 초기화
//		hong.id = 1001;			// 도트 연산자(.) - 객체에 필드나 메소드 속성에 직접적으로 들어갈 수 있는 연산자
//		hong.name = "홍길동";		
//		hong.age = 20;
//		hong.address = "서울특별시 강남구";
//		hong.gender = "남자";
//		hong.mathScore = 70;
//		hong.engScore = 80;
//		
//		
//		go.id = 1002;
//		go.name = "고길동";
//		go.age = 23;
//		go.address = "경기도 광주시";
//		go.gender = "남자";
//		go.mathScore = 54;
//		go.engScore = 100;
//		
//		// 필드에 직접 접근해서 값을 출력 - 외부에서 직접 접근이 가능해서 데이터의 값이 변질될 수 있음
//		System.out.printf("%s님의 수학점수는 %d점, 영어점수는 %d점 입니다. \n", hong.name, hong.mathScore, hong.engScore);
//		System.out.printf("%s님의 수학점수는 %d점, 영어점수는 %d점 입니다. \n", go.name, go.mathScore, go.engScore);
		
		Student hong = new Student();
		
		/*
		 * getter setter 실습
		 */
//		int hongId = hong.getId();	// getId 메소드를 통해서 필드의 값을 전달 받은 것.
//
//		System.out.println(hongId);
//
//		hong.setId(12837);
//		
//		hongId = hong.getId();
//		
//		System.out.println(hongId);
		
		
		Student go = new Student();
		
		// 캡슐화 작업으로 인해 직접 접근을 막았다면 간접적으로 접근을 할 수 있도록 메소드를 제공한다.
		hong.setId(1001);
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setAddress("서울특별시 강남구");
		hong.setGender("남자");
		hong.setMathScore(90);
		hong.setEngScore(60);
		
		go.setId(1002);
		go.setName("고길동");
		go.setAge(400);
		go.setAddress("경기도 광주시");
		go.setGender("남자");
		go.setMathScore(100);
		go.setEngScore(80);
		
//		System.out.printf("%s님의 수학점수는 %d점, 영어점수는 %d점 입니다. 주소는 %s 입니다.\n", hong.getName(), hong.getMathScore(),hong.getEngScore(), hong.getAddress());
		System.out.println(hong.information());	// 해당하는 객체에 대한 정보를 리턴
		System.out.println(go.information());

	}

}
