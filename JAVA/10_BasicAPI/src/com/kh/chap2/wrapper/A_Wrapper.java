package com.kh.chap2.wrapper;

/*
 * 	Wrapper 클래스
 * 		- 기본 자료형을 객체로 포장해 주는 클래스이다.
 * 		- 기본 자료형으로 사용해도 되지만 프로그램에 따라서 해당 기본 타입을 객체로 취급해서 처리해야 하는 경우에 사용한다.
 * 		(ex. 메소드의 매개변수로 객체 타입만 요구될 때, 컬렉션에 데이터를 저장하려고 할 때)
 * 		- 기본 자료형을 Wrapper 클래스로 포장해주는 것을 Boxing이라고 한다. 
 * 		- 반대로 Wrapper 클래스를 기본 자료형으로 변경해주는 것을 UnBoxing이라고 한다.
 * 
 */
public class A_Wrapper {
	// @Deprecated
	public void method1() {
		// Boxing : 기본 자료형 -> Wrapper 클래스의 객체로
		int iNum = 10;
		double dNum = 3.14;
		double dNum2 = 3.15;
		
		// 1. 객체 생성을 통한 방법 (Deprecated(비권장) : java 9 버전부터 더 나은 방법 추천해주게 된다. 삭제되지 않는이유 : 9이전 버전에서는 저렇게 썼기 때문에 호환을 위해 유지된다.)
		Integer integer = new Integer(iNum);
		Double double1 = new Double(dNum);
		Double double2 = new Double(dNum2);
		
		System.out.println(integer);
		System.out.println(double1);
		System.out.println(double2);
		// 주소값 비교
		System.out.println(double1 == double2);
		
		// 클래스에서 제공하는 메소드들을 사용할 수 있다. (equals, comparTo ...)
		System.out.println(double1.equals(double2));
		System.out.println(double1.compareTo(double2)); // 두 값을 비교해서 앞쪽의 값이 크면 1을 반환, 뒤쪽이 크면 -1, 값이 동일하면 0을 반환한다.
		System.out.println();
		
		// 2. 객체를 직접 생성하지 않고 정적 메소드를 통한 방법
		Integer integer2 = Integer.valueOf(3);
		Double double3 = Double.valueOf("1.11");			// 문자열을 숫자화 시켜준다. 단, 문자열에 숫자가 아닌 값이 있으면 오류가 발생한다.
		
		System.out.println(integer2);
		System.out.println(double3);
		System.out.println();
		
		// 3. Auto Boxing
		Integer integer3 = 5;		// 같은 타입만 Auto Boxing이 가능하다.
		Double double4 = 3.555;
		
		// UnBoxing : Wrapper -> 기본 자료형으로 변경하는 작업
		int iNum2 = integer2.intValue();
		int iNum3 = integer3.intValue();
		
		System.out.println(iNum2 + iNum3);
		
		int iNum4 = integer3;		// Auto UnBoxing
//		int iNum4 = double4;			// 같은 타입만 UnBoxing이 가능하다.
		
		System.out.println(iNum4);
		System.out.println(integer2 + integer3);		// Auto UnBoxing
		
//		System.out.printf("%s, %d", "Hi", 4);	// 객체(Object) 타입으로 받기 때문에 Auto Boxing이 이루어진다.
		
	}

	public void method2() {
		String str1 = "10";
		String str2 = "3.14";
		
		System.out.println(str1 + str2);		// 문자열 연결 연산
		
		// 1. 문자열을 기본 자료형으로 변경 (Wrapper 클래스에서 제공하는 parseXXX() 이용)
		int iNum = Integer.parseInt(str1);
		double dNum = Double.parseDouble(str2);
		
//		int iNum = Integer.parseInt(str2);	// 반대로 출력할 경우 오류 발생 : 자료형이 다르기 때문
//		double dNum = Double.parseDouble(str1);	// 형변환이 가능
		
		System.out.println(iNum + dNum);
		
		// 2. 기본 자료형을 문자열로 변경
		// String 클래스의 valueOf() 메소드를 사용하는 방법
		String str3 = String.valueOf(iNum);
		String str4 = String.valueOf(dNum);
		
		System.out.println(str3);
		System.out.println(str4);
		
		// Wrapper 클래스에서 제공하는 valueOf().toString() 메소드를 사용하는 방법
//		Integer valueOf = Integer.valueOf(iNum);		// 객체의 주소값을 valueOf에 대입 후 리턴

		String str5 = Integer.valueOf(iNum).toString();		// 객체의 정보를 문자열로 바꿔주는 것.
		String str6 = Double.valueOf(dNum).toString();
		
		System.out.println(str5);
		System.out.println(str6);
	
	
	
	
	}
}
