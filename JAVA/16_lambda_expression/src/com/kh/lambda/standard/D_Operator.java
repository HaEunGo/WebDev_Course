package com.kh.lambda.standard;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import com.kh.lambda.standard.model.vo.Student;

public class D_Operator {
	/*
	 *	Operator
	 *		- Operator 함수적 인터페이스는 매개값과 리턴 값이 있는 applyXXX() 메소드를 가지고 있다.
	 *		- Function 함수적 인터페이스와 다르게 주로 매개값을 이용해서 연산하고 동일한 타입으로 결과를 리턴하는 역할을 한다.
	 */
	
	public void method1() {
		IntBinaryOperator intBinaryOperator = (a, b) -> a * b;
		
		System.out.println(intBinaryOperator.applyAsInt(10, 20));
		
		IntUnaryOperator intUnaryOperator = (a) -> a * a;
		
		System.out.println(intUnaryOperator.applyAsInt(10));
		
//		두 개의 타입을 받아서 둘 중 수학점수가 더 높은 객체 리턴할 수 있도록 한다.
		BinaryOperator<Student> binaryOperator = (s1, s2) -> {
			if(s1.getMath() > s2.getMath()) {
				return s1;
			} else {
				return s2;
			}
		};
		
		Student stu1 = new Student("동동이", 20, "남자", 80, 98);
		Student stu2 = new Student("당당이", 20, "여자", 78, 100);
		System.out.println(binaryOperator.apply(stu1, stu2));
	}
}
