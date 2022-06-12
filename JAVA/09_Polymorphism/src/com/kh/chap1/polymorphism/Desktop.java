package com.kh.chap1.polymorphism;


public class Desktop extends Product {
	
	private boolean allInOne;		// 일체형 여부
	
	public Desktop() {
//		System.out.println("자식 객체 기본 생성자.");
	}
	

	public Desktop(String brand, String pCode, String name, int price, boolean allInOne) {
		super(brand, pCode, name, price);
		
//		super name = "홍길동";
//		this.setBrand(brand);
//		this.setpCode(pCode);
//		this.setName(name);
//		this.setPrice(price);
		
		this.allInOne = allInOne;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

	@Override // 부모 클래스에 있는 information 메소드를 호출해서 자식 클래스에서 다시 재정의하겠다라는 뜻
	public String information(){
	return super.information() + ", " + this.allInOne;}

	
	
	
}
