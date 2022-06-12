package com.kh.chap5;

import com.kh.chap4.constructor.User;
import com.kh.chap5.method.A_Method;
import com.kh.chap5.method.C_StaticMethod;

public class Application {
	
	public static void main(String[] args) {
//		A_Method methodTest = new A_Method();
//		
//		// 1. 매개 변수와 반환값이 없는 메소드 호출
//		methodTest.method1();
//		
//		// 2. 매개 변수가 없고 반환값이 있는 메소드 호출
//		String str = methodTest.method2();
//		System.out.println(str);
//		
//		// 3. 매개 변수가 있고 반환값이 없는 메소드 호출
//		methodTest.method3(10, 20);
//		
//		// 4. 매개 변수가 있고 반환값도 있는 메소드 호출
//		System.out.println(methodTest.method4(30, 20));
//		
//		// 5. 매개 변수로 객체를 전달받는 메소드 호출
//		User user = new User("isname", "1234", "가나다");
//		
//		System.out.println(user.information());
//		methodTest.method5(user);
//		System.out.println(user.information());
//		
//		// 6. 매개 변수로 가변인자를 전달받는 메소드
//		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//		methodTest.method6(arr);
////		methodTest.method6(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
//		methodTest.method7("홍길동", 1, 2, 3);
//		methodTest.method7("james",1, 2, 3, 5, 7, 9, 11);
//		methodTest.method7("grace",1, 2, 3, 4, 5);	// 값 목록
//		methodTest.method7("lily");
		
//		System.out.printf("%d, %s",1, "a", 0, 0);
//		System.out.printf("%d, %s", new Object[] {1, "a", 0, 0}); // 번거로움
	
		
		System.out.println("=======================");
		
		// 1. 매개 변수와 반환값이 없는 메소드 호출 (객체생성 안 하고 바로 호출 가능)
		C_StaticMethod.method1();
		
		// 정적 멤버는 객체 참조 변수로도 접근이 가능하지만, 정적 멤버는 클래스 이름으로 접근하는 것이 좋다.
//		new C_StaticMethod().method1();
	
		
		// 2. 매개 변수가 없고 반환값이 있는 메소드 호출 (증감연산자 사용)
		System.out.println("Result : " + C_StaticMethod.method2());
		
		// 3. 매개 변수가 있고 반환값이 없는 메소드 호출
		C_StaticMethod.method3("grace");
		
		
		// 4. 매개 변수가 있고 반환값도 있는 메소드 호출
		int result = 0;
		
		result = C_StaticMethod.method4(3, 2, 1);
		System.out.println(result);
		
		result = C_StaticMethod.method4(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(result);

		
		
		
		
		
	}
}
