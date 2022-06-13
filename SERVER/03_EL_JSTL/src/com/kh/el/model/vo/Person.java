package com.kh.el.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
//@Getter
@AllArgsConstructor
@NoArgsConstructor

//public class Person {
//	String name;
//	
//	int age;
//	
//	char gender;
//}

// private으로 변경할 시 EL로 직접 접근하는 것 같지만 getter를 통해 값을 읽어온다.
public class Person {
	private String name;
	
	private int age;
	
	private char gender;
}