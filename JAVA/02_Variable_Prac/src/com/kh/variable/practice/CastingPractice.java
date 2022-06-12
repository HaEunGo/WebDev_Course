package com.kh.variable.practice;

import java.util.Scanner;

public class CastingPractice {
	
	public void method1() {
	// 키보드로 문자 하나를 입력 받아 그 문자와 그 문자의 유니코드 값을 출력하세요.
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("문자 하나를 입력하세요.");
		char a = sc.nextLine().charAt(0);
//		int b = (int)a;
		int b = a;
		
		System.out.println("입력한 문자 : " + a);
		System.out.println(a + " Unicode : " + b);

	}

	
	public void method2() {
	// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	// 이 때 총점과 평균은 정수형으로 처리하세요.
		Scanner scanner = new Scanner(System.in);
		float kor = 0.0f;
		float eng = 0.0f;
		float math = 0.0f;
		
		System.out.println("국어 점수를 입력하세요. : ");
		kor = scanner.nextFloat();

		System.out.println("영어 점수를 입력하세요. : ");
		eng = scanner.nextFloat();

		System.out.println("수학 점수를 입력하세요. : ");
		math = scanner.nextFloat();
		
		System.out.println("\n총점 : " + (int)(kor + eng + math));
		System.out.println("평균 : " + (int)(kor + eng + math)/3);
	}
	
	public void method3() {
	// 선언 및 초기화된 5개의 변수를 가지고 알맞은 사칙연산(+,-,*,/)과 형변환을 이용하여 주석에 적힌 값과 같은 값이 나오도록 코드를 작성하세요.
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		double dNum = 2.5;
		
		char ch = 'A';
		
		System.out.println((int)(iNum1/iNum2));			// 2
		System.out.println((int) dNum );					// 2
		
		System.out.println();
		
		System.out.println( iNum2*dNum );				// 10.0
		System.out.println( (double)iNum1);				// 10.0
		
		System.out.println();

		System.out.println( (double)iNum1/iNum2 );		// 2.5
		System.out.println( dNum );						// 2.5	
		
		System.out.println();

		System.out.println( (int)fNum );					// 3
		System.out.println( iNum1/fNum );				// 3
		
		System.out.println();

		System.out.println( iNum1/fNum );				// 3.3333333
//		System.out.println((iNum1/(double)fNum));		// 3.333333333333335
		System.out.println(((double)iNum1/fNum));		// 3.333333333333335	
														// 값의 표현범위(자료형)에 따라 출력되는 값이 달라질 수 있다.
		System.out.println();

		System.out.println( ch ); 						// 'A'
		System.out.println( (int)ch );					// 65
		System.out.println( (int)(ch + iNum1) );			// 75
//		System.out.println( (char)((int)ch + iNum1) );	// 'K'
														// 문자 -> 정수형 변환 -> 숫자값을 다시 문자로 변환
		System.out.println( (char)(ch + iNum1) );		// 'K'
														// 문자는 자동으로 숫자로 변환이 된다 -> 연산 값을 문자로 변환


	}
	
}
