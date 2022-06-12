package com.kh.chap3.assiststream.model.vo;

import java.io.Serializable;

public class Member implements Serializable {
	
	// serialVersionUID : 직렬화된 데이터를 역직렬화 될 때 클래스가 동일해야 하기 때문에 그 클래스를 구분하는 식별자 역할을 한다.
	// -> 임의로 명시해주는 것이 좋다.
	private static final long serialVersionUID = 8034257641078435575L; 
	
	// 5개의 필드 생성
	private String id;
	
	private transient String pwd;		// 직렬화하고 싶지 않은 객체가 있으면 transient를 붙여주면 된다.
	
	private String name;
	
	private transient int age;
	
	private transient char gender;
	
	// 기본 생성자
	public Member() {
	}

	// 매개변수 있는 생성자
	public Member(String id, String pwd, String name, int age, char gender) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	
	// getter, setter 
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// toString
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
