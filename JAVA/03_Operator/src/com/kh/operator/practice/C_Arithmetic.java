package com.kh.operator.practice;

public class C_Arithmetic {
	/*
	 * 산술 연산
	 * 		+ (더하기)
	 * 		- (빼기)
	 * 		* (곱하기)
	 * 		/ (나누기)
	 * 		% (나누고 난 나머지 값)
	 */
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		double dNum1 = 35;
		double dNum2 = 10;
		
		System.out.println("=====정수형의 사칙연산=====");
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		// 소수점 첫째자리까지만 출력한다.
//		System.out.println("num1 / num2 = " + ((double)num1 / num2));	// 나누기의 몫
		System.out.printf("num1 / num2 = %f.1\n", ((double)num1 / num2));	// 나누기의 몫
		System.out.println("num1 % num2 = " + (num1 % num2));			// 나누기의 나머지
		System.out.println();
		
		System.out.println("=====실수형의 사칙연산=====");
		System.out.println("dNum1 + dNum2 = " + (dNum1 + dNum2));
		System.out.println("dNum1 - dNum2 = " + (dNum1 - dNum2));
		System.out.println("dNum1 * dNum2 = " + (dNum1 * dNum2));
		System.out.println("dNum1 / dNum2 = " + (dNum1 / dNum2));
		System.out.println("dNum1 % dNum2 = " + (dNum1 % dNum2));

		// 참고
//		System.out.println(5/0);	// ArithmeticException
		System.out.println(5/0.0);	// Infinity(무한대) 
		System.out.println(5%0.0);	// NaN(Not a Number) 값 (숫자가 아니라는)
		System.out.println((5/0.0) + 2);	// Infinity(무한대) 
		System.out.println((5%0.0) + 2);	// NaN(Not a Number) 값 (숫자가 아니라는)

		System.out.println(Double.isInfinite(5/0.0));	// 연산 결과가 Infinity인지 검사하는 코드
		System.out.println(Double.isNaN(5/0.0));		// 연산 결과가 NaN인지 검사하는 코드


	}
	
}
