package com.kh.operator.practice;

public class F_Compound {
	/*
	 *  복합 대입 연산자
	 *  	- 다른 연산자와 대입 연산자를 함께 사용하는 연산자로, 내부적으로 연산 처리 속도가 빠르므로 사용을 권장한다.
	 *  		(메모리에서 직접 연산을 수행한다.)
	 *  	- 증감 연산자(++, --)와 비슷해 보이지만 증감 연산자는 값이 1씩만 증감이 되고, 복합 대입 연산자는 내가 원하는 숫자만큼 값 증감시킬 수 있다.
	 *  
	 *   +=, -=, *=, /=, %=
	 *   
	 *   a = a + 1;	=> a += 1;	// a라는 변수에 값을 대입 하는 과정이 훨씬 간결해진 것을 확인할 수 있다.
	 *   a = a - 3; => a -= 3;
	 *   a = a * 3; => a *= 3;
	 *   a = a / 3; => a /= 3;
	 *   a = a % 3; => a %= 3;
	 *   
	 *   
	 */
	
	public void method1() {
		int num = 12;
		String str = "Hello";
		
		str += "\tWorld!";		//str = str + "\tWorld!"; -> Hello     World! 이렇게 출력이 될 것이다.
		
		System.out.println(str);
		
		str += 1;		// str = str + 1;
		System.out.println(str);
		
		num += 3;		// num = num + 3;
		System.out.println("num += 3 은(는) " + num);
		
		num -= 5;		// num = num - 5;
		System.out.println("num -= 5 은(는) " + num);
		
		num *= 6;		// num = num * 6;
		System.out.println("num *= 6 은(는) " + num);
		
		num /= 3;		// num = num / 3;
		System.out.println("num /= 3 은(는) " + num);

		num %= 4;		// num = num % 4;
		System.out.println("num %= 4 은(는) " + num);

		
	}
}
