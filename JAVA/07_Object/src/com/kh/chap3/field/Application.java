package com.kh.chap3.field;

// protected, default 접근 제한자 확인을 위한 Application.java
public class Application {

	public static void main(String[] args) {
		A_Field fieldTest = new A_Field();
		
		fieldTest.test(10);		// 매개 값으로 정수형 하나를 메소드 호출 시에 넘겨주어야 한다.
		
		// 2. 접근 제한자 테스트
		// public -> 필드에 집적 접근이 가능하다.
		System.out.println(fieldTest.publicField);
		
		// protected -> 같은 패키지 내에 존재하거나, 상속 구조에서만 접근 가능
		System.out.println(fieldTest.protectedField); 	// 다른 패키지면서 상속 구조도 아니어서 접근 불가.
		
		// default -> 같은 패키지 내에서만 접근이 가능하다.
		System.out.println(fieldTest.defaultField); 		// 다른 패키지이기 때문에 접근 불가
		
		// private -> 같은 클래스 내에서만 접근이 가능하다.
//		System.out.println(fieldTest.privateField);
		
		// 3. 클래스 변수 테스트
		// 클래스 변수는 프로그램 실행과 동시에 메모리(static)에 생성되었기 때문에 객체를 생성하지 않아도 접근이 가능하다.("클래스명.클래스변수명")
		System.out.println(B_StaticField.pubSta);
		System.out.println(B_StaticField.getPriSta());
		
		
		// 정적 멤버는 객체 참조 변수로도 접근이 가능하지만 정적 멤버는 클래스 이름으로 접근하는 것이 좋다.
//		System.out.println(new B_StaticField().pubSta);
		
		// 4. 상수 필드 테스트
//		Integer.MAX_VALUE;
//		Double.MAX_VALUE;
		System.out.println(C_StaticFinalField.MAX_LEVEL);
		
		// final 키워드로 인해서 값을 변경할 수 없다.
//		C_StaticFinalField.MAX_LEVEL = 30;
		
		
	}

}
