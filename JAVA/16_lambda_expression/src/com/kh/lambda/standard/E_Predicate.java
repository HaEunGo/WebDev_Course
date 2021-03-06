package com.kh.lambda.standard;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.kh.lambda.standard.model.vo.Student;

public class E_Predicate {
	/*
	 * Predicate
	 * 	- Predicate 함수적 인터페이스는 매개 변수와 boolean 리턴 값이 있는 testXXX() 메소드를 가지고 있다.
	 * 	- 이 메소드들은 매개값을 조사해서 true/false를 리턴하는 역할을 한다.
	 */
	
	public void method1() {
		Student stu1 = new Student("동동이", 20, "남자", 80, 98);
		Student stu2 = new Student("당당이", 20, "여자", 78, 100);
		
		Predicate<Student> predicate = (s) -> {
			return s.getGender().equals("남자");
		};
		
		System.out.println("동동이는 남자입니까?" + predicate.test(stu1));
		System.out.println("당당이는 남자입니까?" + predicate.test(stu2));
		
		IntPredicate intPredicate = (i) -> i > 100;
		
		System.out.println(intPredicate.test(100));
		System.out.println(intPredicate.test(101));
	}
}
