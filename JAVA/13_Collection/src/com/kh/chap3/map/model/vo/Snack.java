package com.kh.chap3.map.model.vo;

public class Snack {
	
	public String flavor;
	
	public int kcal;
	
	public Snack() {
	}

	public Snack(String flavor, int kcal) {
		super();
		this.flavor = flavor;
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", kcal=" + kcal + "]";
	}
	
}
