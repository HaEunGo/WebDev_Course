package com.kh.chap2._class;

class Phone {
	private String name;
	
	private String color;
	
	private String brand;
	
	// Phone 클래스는 접근 제한이 default라도 동일한 패키지에 존재하는 Person 클래스에서 생성할 수 있다.
	private Phone phone;
//	private Phone phone = new Phone();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPhone(String name, String color, String brand) {
		this.phone = new Phone();
		
		phone.setName(name);
		phone.setColor(color);
		phone.setBrand(brand);
		
	}
	
	
}
