package com.kh.chap2._class;

	/*
	 *  클래스에서 사용 가능한 접근 제한자
	 * 	
	 *  1. public
	 * 	 	- 동일한 패키지뿐만 아니라 다른 패키지에도 아무런 제약 없이 사용할 수 있다.
	 *  	
	 *  2. default
	 * 	 	- 클래스를 선언할 때 public을 생략했다면 클래스는 자동으로 default 접근 제한을 가진다.
	 * 		- 동일한 패키지에는 아무런 제약 없이 사용할 수 있지만, 다른 패키지에서는 사용할 수 없도록 접근이 제한된다.
	 * 
	 */

public class Person {		// 클래스를 사용자 정의 자료형이라고도 부른다.
	private String name;
	
	private int age;
	
	// Phone 클래스는 접근 제한이 default라서 동일한 패키지에 존재하는 Person 클래스에서 생성할 수 있다.
//	private Phone phone;
	private Phone phone = new Phone();
	
	
//	public String getName() {
//		return name;
//	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getAge() {
//		return age;
//	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public void setPhone(String name, String color, String brand) {
		this.phone = new Phone();
		
		phone.setName(name);
		phone.setColor(color);
		phone.setBrand(brand);
		
	}
	
	
	
	// getter역할을 하는 메소드를 만들었으니 위애있는 getter를 지워도 된다.
//	public String whoAreYou() {
//		return "안녕하세요. 저는 " + this.name + "입니다. 나이는 " + this.age + "세 입니다.";
//	}
	

		public void whoAreYou() {
			System.out.println("안녕하세요. 저는 " + this.name + "입니다. 나이는 " + this.age + "세 입니다.");
			System.out.println("" + phone.getBrand() + " 브랜드의 " + phone.getName() + "을 가지고 있습니다.");
		
		}
	
}
