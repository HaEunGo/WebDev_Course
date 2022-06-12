package com.kh.chap1.string;

import java.util.StringTokenizer;

public class A_String {
	
	public void method1() {
		// 문자열 리터럴과 new 문으로 생성된 문자열 비교
		
		// str1, str2와 같이 리터럴로 값을 초기화하게 되면 StringPool이라는 영역(Heap)에 값이 저장된다.
		// StringPool 영역에 중복되는 값이 존재할 수 없다. 기존에 존재하는 값이 있을 경우에는 존재하는 값의 주소값을 전달해준다.
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");

		// 동등 비교 (주소값) - 상황에 따라 다르게 나올 수도 있다.
		System.out.println("str1 == str2 ? " + (str1 == str2));		// true
		System.out.println("str1 == str3 ? " + (str1 == str3));		// false
		System.out.println("str3 == str4 ? " + (str3 == str4));		// false
		
		// equals() => String 클래스에서 이미 오버라이딩 되어있다.
		// 문자열이 동일할 경우 true가 return되도록 이미 재정의 되어있다.
		System.out.println("str1.equals(str2) ? " + str1.equals(str2));
		System.out.println("str2.equals(str3) ? " + str2.equals(str3));
		System.out.println("str3.equals(str4) ? " + str3.equals(str4));

		// hashCode() => String 클래스에서 이미 오버라이딩 되어있다.
		// 실제 주소값은 재정의되어 있다.
		System.out.println("str1.hashCode() : " + str1.hashCode());
		System.out.println("str2.hashCode() : " + str2.hashCode());
		System.out.println("str3.hashCode() : " + str3.hashCode());
		System.out.println("str4.hashCode() : " + str4.hashCode());
		
		// 문자열 객체의 실제 주소값에 대해 알고 싶다면 System.identityHashCode() 메소드를 통해서 확인이 가능하다.
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		// toString() => String 클래스에서 이미 오버라이딩 되어있다.
		System.out.println(str1.toString());		// toString 말고 참조값만 넘겨도 동일하게 출력이 된다. -> Object 내부적으로 객체를 받으면 toString으로 호출해서 문자열 객체를 출력해준다.
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

	}
	

	public void method2() {
		// String 클래스에서 제공하는 메소드들 사용
		String str = "Hello World";
		
		// 1. charAt(int index) : 전달받은 index 위치에 있는 하나의 문자만 추출해서 리턴한다.
		char ch = str.charAt(3);
		System.out.println(ch);
		System.out.println();
		
		// 2. concat(String str) : 전달받은 str과 원본 문자열을 하나로 합친 뒤, 합쳐진 새로운 문자열을 생성해서 리턴한다.
		String str2 = str.concat("!!!!!");
		System.out.println(str2);
		System.out.println(str);
		System.out.println();
		
		// 3. substring(int beginIndex) : 문자열의 beginIndex 위치에서부터 끝까지의 새로운 문자열을 생성해서 리턴한다.
		//	  substring(int beginIndex, int endIndex) : 문자열의 beginIndex 위치에서부터 endIndex - 1(마지막 인덱스는 포함하지 않음)까지의 새로운 문자열을 생성해서 리턴한다.
		String str3 = str.substring(6);
		String str4 = str.substring(2, 6);

		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str);
		System.out.println();
		
		// 4. replace(char oldChar, char newChar) : 문자열에서 old 문자를 new 문자로 변경된 새로운 문자열을 생성해서 리턴한다.
		String str5 = str.replace('l', 'c');
		
		System.out.println(str5);
		System.out.println(str);
		System.out.println();
		
		// 5. toUpperCase() / toLowerCase() : 문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴한다.
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		System.out.println(str);
		System.out.println();
		
		// 6. trim() : 문자열 앞뒤의 공백을 제거한 뒤, 새로운 문자열을 생성해서 리턴한다.
		str = " java ";
		System.out.println(str.trim());
		System.out.println(str);				// 원본 문자열에는 변화 X
		
		// 7. toCharArray() : 문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값을 리턴한다.
		str = "Hello";
		char[] arr = str.toCharArray();
		
		System.out.println(arr[0]);		// H 출력
		System.out.println(arr[2]);		// l 출력
		System.out.println();
		
		// 8. valueOf([기본 자료형, 문자 배열, 객체]) : 입력받은 값들을 문자열로 변경해서 리턴한다.
		String str6 = String.valueOf(true);		// 정적 멤버 사용
		String str7 = String.valueOf(arr);
		String str8 = String.valueOf(3.141592F);	
		
		System.out.println(str6);
		System.out.println(str7);
		System.out.println(str8);
		System.out.println();
		
		
	}

	
	public void method3() {
		// 구분자를 이용하여 문자열 분리
		String str = "Java,Oracle,JDBC,HTML,CSS,Spring";
		
		
		// 1. String 클래스의 split 메소드를 이용하는 방법
		//	split(String regex) // regex(Regular expressio - 정규표현식)
		//		: 입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴한다. 
		//			-> split을 활용해 문자열을 쪼개고,그 쪼개진 문자들의 개수까지 출력
		
		String[] strArr = str.split(",");
		System.out.println("strArr.length : " + strArr.length);
		
		for(String s : strArr) {
			System.out.println(s);
		}
		
		System.out.println();
		
		// 2. StringTokenizer 객체를 이용하는 방법
		// 분리된 문자열을 가지고 있는 StringTokenizer를 활용해 출력
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("분리 후 문자열의 개수 : " + st.countTokens());
		
		// for 문을 통한 출력 방법
		int length = st.countTokens();		// 현재 남아있는 토큰을 출력
		
//		for(int i = 0; i < length; i++) {
//			System.out.println(st.nextToken());
//		}
		
//		for(int i = 0; i < countTokens();	 i++) {		// 1회전할 때마다 토큰을 사용하면서 하나씩 줄어 들 것이다. i = 0,1,2,3 Token = 6,5,4를 쓰고 반복문을 빠져나오게 된다.
//			System.out.println(st.nextToken());
//		}
		
		// while 문을 통한 출력 방법 - while 문이 더 간략하게 표현 가능하다.
		while(st.hasMoreTokens()) {			//token을 갖고 있으면 true, 없으면 false 출력
			System.out.println(st.nextToken());
		}
		
	}

}
