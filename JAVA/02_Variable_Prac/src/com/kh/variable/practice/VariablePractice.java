package com.kh.variable.practice;

import java.util.Scanner;

public class VariablePractice {

	public void method1() {
	// 이름(String), 성별(char), 나이(int), 키(double)를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
		Scanner scanner = new Scanner(System.in);
		String name = "";
		char gender = '\u0000';
		int age = 0;
		double height = 0;
		
		
		System.out.println("이름을 입력하세요 : ");
		name = scanner.nextLine();
		
		System.out.println("나이를 입력하세요 : ");
		age = scanner.nextInt();
		
		System.out.println("성별을 입력하세요(남/여) : ");
		scanner.nextLine();
		String line = scanner.nextLine();
		gender = line.charAt(0);
		
		System.out.println("키를 입력하세요(cm) : ");
		height = scanner.nextDouble();
		
		System.out.printf("\n키 %.1fcm인 %d살 %c자 %s님 환영합니다^^\n", height, age, gender, name);
		
		
	}
	

	public void method2() {
	// 키보드로 정수 두 개를 입력 받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
		Scanner scanner = new Scanner(System.in);
		int iNum = 0;
		int iNum2 = 0;
		
		System.out.println("첫 번째 정수를 입력하세요 : ");
		iNum = scanner.nextInt();
		
		
		System.out.println("두 번째 정수를 입력하세요 : ");
		iNum2 = scanner.nextInt();
		
		
		System.out.printf("\n더하기 결과 : %d\n빼기 결과 : %d\n곱하기 결과 : %d\n나누기 몫 결과 : %d\n", (iNum+iNum2),(iNum-iNum2),(iNum*iNum2),(iNum/iNum2));
		
	}
	
	public void method3() {
	// 키보드로 가로, 세로 값을 실수형으로 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	// 참고 (면적 = 가로*세로, 둘레 = (가로+세로)*2)
		Scanner scanner = new Scanner(System.in);
		double a = 0;
		double b = 0;
		
		
		System.out.println("가로길이를 입력하세요.");
		a = scanner.nextDouble();
		
		System.out.println("세로길이를 입력하세요.");
		b = scanner.nextDouble();
		
		System.out.printf("\n면적 : %.2f\n둘레 : %.1f", (a*b),((a+b)*2));
		
		
	}
	
	public void method4() {
	// 영어 문자열 값을 키보드로 입력 받아 앞의 문자 세 개를 출력하세요.
	// hint > charAt(인덱스) 메소드 활용해보기.
		
		Scanner scanner = new Scanner(System.in);
		char name = '\u0000';
		char name2 = '\u0000';
		char name3 = '\u0000';
		
		System.out.println("문자열을 입력하세요.");
		String str = scanner.nextLine();
		name = str.charAt(0);
		name2 = str.charAt(1);
		name3 = str.charAt(2);
		
		
		System.out.printf("\n첫 번째 문자 : %c\n두 번째 문자 : %c\n세 번째 문자 : %c\n", name, name2, name3);

	}

		
	}

