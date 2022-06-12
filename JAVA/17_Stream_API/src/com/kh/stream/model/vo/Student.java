package com.kh.stream.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	
	private int age;
	
	private String gender;
	
	private int math;
	
	private int english;

	}

// C_Sorted.java 참고
//public class Student implements Comparable<Student>{
//	private String name;
//	
//	private int age;
//	
//	private String gender;
//	
//	private int math;
//	
//	private int english;
//
//	@Override
//	public int compareTo(Student o) {
//		return 0;
//	}
//
//}