package com.kh.first;

import com.kh.first.practice.*;	// * 패키지에 속하는 모든 클래스를 import 시킨다.



/*
 	주석(Comment)
 	- 소스 코드와는 무관하고 코드로 인식되지 않는다.
 	- 주로 코드에 대한 설명을 작성할 때 사용한다.
 */

//  한 줄 주석
//	추가로 주석 작
/**
 *  도큐먼트 주석
 *  - 도큐먼트 주석은 javadoc.exe를 통해 API도큐먼트를 생성하는데 사용된다.
 *  
 * @author devhani
 *
 */

// 클래스 명은 클래스 파일명과 동일해야 한다.
// 클래스 안에는 여러 개의 메소드를 가질 수 있고 메소드 안에 소스코드를 작성한다.


public class Application {

	// main method는프로그램의 시작점으로 
	// java.exe가 Applicatio.class를 실행시킬 때 실행되는 메소드이다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// 1. 실행할메소드가 있는 클래스를 생성(new)해야 한다. 
	// [표현법]
	//	클래스명 사용할 이름 = new 클래스명();
	
	// 방법 1) import문을 사용하지 않고 클래스 생성
	//com.kh.first.practice.ValuePrinter printer = new com.kh.first.practice.ValuePrinter();
	
	// 방법 2) import문을 사용하여 클래스 생성
	// command + shift + o키를 누르면 자동으로 import를 정리해준다.
	// command + . 키를 누르면 에러가 발생한 곳으로 이동한다.
	// command + 1 키를 누르면 해당 에러에 대한 해결 방법을 제시해준다.
		ValuePrinter printer = new ValuePrinter();
		
	// 2. 클래스를 생성 -> method를 호출(실행)시킨다.
	// [표현법]
	//  사용할이름.호출할메소드명(); (도트 연산자로 구분한다.)
		printer.printTest();
	}

}
