package com.kh.chap4;

import java.util.List;

import com.kh.chap4.generics.MyGenerics;

public class Application {

	public static void main(String[] args) {
		String[] strArr = {"홍길동", "고길동", "둘리", "짱구", "코난"};
		Integer[] intArr = {11, 22, 33, 44, 55};
		Double[] doubleArr = {22.1, 23.4, 57.2, 88.9, 24.7};
		
//		MyGenerics<String> myGenerics = new MyGenerics<>(strArr);
		MyGenerics<Double> myGenerics = new MyGenerics<>(doubleArr);
		MyGenerics<Integer> myGenerics2 = new MyGenerics<>(intArr);

		
		myGenerics.print();
		myGenerics2.print();
		
//		List<String> list = myGenerics.toList();
		List<Double> list = myGenerics.toList();
		List<Integer> list2 = myGenerics2.toList();
		
//		for (String str : list) {
//			System.out.println(str);
//		}
		
		for (Double d : list) {
			System.out.println(d);
		}
		
		for (Integer i : list2) {
			System.out.println(i);
		}

	}

}
