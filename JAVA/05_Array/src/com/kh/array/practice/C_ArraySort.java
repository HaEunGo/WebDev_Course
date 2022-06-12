package com.kh.array.practice;

import java.util.Arrays;
import java.util.Collections;

public class C_ArraySort {
	public void method1() {
		int[] arr = {2, 5, 7, 1, 3};
		
		for (int value : arr) {
			System.out.print(value + " ");
		}
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		System.out.println();
		
		for (int value : arr) {
			System.out.print(value + " ");
		}
		
		// 내림차순으로 정렬
		// 1. for 문을 사용해서 원본 배열의 값을 반대로 새로운 배열에 대입한다.
		// 2. 아래와 같이 작성하는 방법이 있다.
		Integer[] integerArray = {2, 5, 7, 1, 3};
		Arrays.sort(integerArray, Collections.reverseOrder());
		
		System.out.println();
		System.out.println(Arrays.toString(integerArray));
		
		}

	public void method2() {
		String[] strArray = {"apple", "orange", "banana", "메론", "레몬"};
		
		// 오름차순으로 정렬
		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));
		
		// 내림차순으로 정렬
		Arrays.sort(strArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(strArray));
		
	}

}
