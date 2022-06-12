package com.kh.test2.server;

import java.util.Scanner;

public class abc {
	public void aaa() {
	int result = 0;
	java.util.Scanner sc = new java.util.Scanner(System.in);
	
	System.out.print("정수 1 : ");
	int num1 = sc.nextInt();
	
	System.out.print("정수 2 : ");
	int num2 = sc.nextInt();
	
	try {
		result = num1 / num2;
		System.out.println("두 수의 나눗셈 결과 : " + result );
		
		} catch (Exception e) {
			System.out.println("부적절한 나눗셈을 시도하였습니다");
		
		}
	}
}

