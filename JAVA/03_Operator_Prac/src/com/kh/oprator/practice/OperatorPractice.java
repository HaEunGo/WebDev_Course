package com.kh.oprator.practice;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		// 실습문제 1. 키보드로 입력받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력하세요.
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		String result = "";
		
		System.out.println("숫자를 입력하세요.");
		num = scanner.nextInt();
		
		
		result = (num > 0) ? "양수다." : "양수가 아니다." ;
		System.out.println("정수 : " + num);
		System.out.println(result);
		
	}
	
	
	public void practice2() {
		// 실습문제 2. 키보드로 입력받은 하나의 정수가 양수이면 "양수다.",
		// 양수가 아닌 경우 중에서 0이면 "0이다", 0이 아니면 "음수다"를 출력하세요.
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		String result = "";
		
		System.out.println("숫자를 입력하세요.");
		num = scanner.nextInt();
		
		result = (num > 0) ? "양수다." : (num == 0) ? "0이다." : "음수다.";
		
		System.out.println("정수 : " + num);
		System.out.println(result);
		
	}
	
	
	public void practice3() {
		// 실습문제 3. 키보드로 입력받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력하세요.
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		String result = "";
		
		System.out.println("정수를 입력하세요.");
		num = scanner.nextInt();
		
		result = (num % 2 == 0) ? "짝수다." : "홀수다." ;
		System.out.println("정수 : " + num);
		System.out.println(result);
		
	}
	
	
	public void practice4() {
		// 모든 사람이 사탕을 골고루 나눠가지려고 한다.
		// 인원 수와 사탕 개수를 키보드로 입력 받고,
		// 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.
		
		Scanner scanner = new Scanner(System.in);
		int candy = 0;
		int people = 0;

		double per = ((double)people / candy);
		double per2 = ((double)people % candy);
		
		System.out.println("인원 수를 입력하세요.");
		people = scanner.nextInt();
		
		System.out.println("사탕 개수를 입력하세요.");
		candy = scanner.nextInt();
		
		System.out.println("인원 수 : " + people);
		System.out.println("사탕 개수 : " + candy);
		System.out.println("1인당 사탕 개수 : " + per);
		System.out.println("남는 사탕 개수 : " + per2);
		
		
		
	}
	
	
	public void practice5() {
		// 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
		// 성인(19세 초과)인지 출력하세요.
		
		
	}
	
	public void practice6() {
		// 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
		
		
		System.out.println("입력1 : ");
		System.out.println("입력1 : ");
		System.out.println("입력1 : ");
		
	}

}
