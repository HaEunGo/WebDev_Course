package com.kh.chap1.list;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.chap1.list.compare.ArtistAscending;
import com.kh.chap1.list.compare.TitleAscending;
import com.kh.chap1.list.model.vo.Music;

public class A_ArrayList {
	
	
	public void method1() {
		// ArrayList를 생성, 데이터 저장, 출력 테스트
		
		/*
		 *  ArrayList
		 * 	 	- ArrayList를 생성하면 내부적으로 10개의 객체를 저장할 수 있는 공간이 생성된다.(공간이 넘어가면 자동으로 추가해서 늘려준다. - 저장용량 유동적)
		 * 		- 저장 순서가 유지되고 인덱스를 통해서 관리된다.
		 * 		- 객체만 저장할 수 있고 null값도 저장이 가능하다.
		 * 		- 중복되는 객체의 저장도 허용한다.
		 *  
		 *  
		 */
		
		ArrayList list = new ArrayList();		// 객체 생성
		
		System.out.println(list);				
		System.out.println(list.isEmpty());		// 저장된 객체가 없기 때문에 true가 뜬다.
		
		list.add("안녕하세요.");
		list.add(3.14);			// Wrapper - AutoBoxing 적용됨
		list.add(LocalDateTime.now());
		
		System.out.println("list : " + list);			// toString
		System.out.println("Size : " + list.size());
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			// 인덱스에 해당하는 값을 가져올 때는 get() 메소드를 사용한다.
			System.out.println(list.get(i));
			
		}
		
		// list에서 값을 꺼내서 대입하기 위해서는 해당 자료형에 맞게 형변환을 해주어야 한다.
//		String str = (String) list.get(0);
//		int num = (int) list.get(3);				// 제네릭스를 지정해주지 않으면 get이 리턴해주는 타입은 object이기 때문에 형변환이 필요하다.
		
		
		// 객체의 중복 저장을 허용한다.
		list.add("안녕하세요.");
		System.out.println("list : " + list);
		
		// 원하는 인덱스 위치의 객체를 추가할 수 있다.
		list.add(2, 12345000);
		System.out.println("list : " + list);
		
		// 원하는 인덱스 위치의 객체를 변경할 수 있다.
		list.set(2, false);
		System.out.println("list : " + list);
		
		// 저장된 객체를 삭제할 때 remove() 메소드를 사용한다.
		list.remove(2);
		list.remove("안녕하세요.");			// 앞에서부터 찾아서 발견이 되면 지우고 나머지는 지우지 않는다. -> 뒤의 안녕하세요는 그대로 유지됨)
		list.remove(3.14);
		System.out.println("list : " + list);
		System.out.println("list.isEmpty() : " + list.isEmpty());		// add된 데이터가 남아있어서 false가 뜬다. -> 비어있을 때만 true가 뜬다.
		
		// 저장된 객체를 모두 삭제할 때는 clear() 메소드를 사용한다.
		list.clear();					// 객체는 존재하지만 객체 안에 있는 또다른 객체는 모두 삭제됨.
		System.out.println("list : " + list);
		System.out.println("list.isEmpty() : " + list.isEmpty());

		
	}


	public void method2() {
		/*
		 * 
		 * 	list 정렬
		 * 		- 기본 자료형, 문자열의 경우엔 Comparable 인터페이스가 내부적으로 구현되어 있어 Collections.sort() 메소드를 통해서 정렬이 가능하다.
		 * 		- 사용자가 작성하는 클래스의 객체도 Collections.sort() 를 통해서 정렬이 가능하게 하고 싶다면 Comparable 인터페이스를 구현하면 된다.
		 * 
		 *  제네릭스(<>)를 사용하는 이유
		 *  		- 명시된 타입의 객체만 저장하도록 제한을 두기 위해서 사용한다.
		 *  		- 컬렉션에 저장된 객체를 꺼내서 사용할 때 매번 형변환을 하지 않아도 된다.
		 *  
		 */
		List<String> list = new ArrayList<>();	// Comparable이라는 인터페이스가 자동으로 구현 되어있어서 sort, reverse가 이루어질 수 있다.
//		List<int> list2 = new A_ArrayList<>();	// 객체 타입만 지정할 수 있다. 자료형 저장X
		List<Integer> list2 = new ArrayList<>();
		
		list.add("apple");
		list.add("peach");
		list.add("watermelon");
		list.add("orange");
		list.add("mango");				// 저장한 순서대로 인덱스 번호가 매겨진다.
		
		list2.add(3);
		list2.add(32);
		list2.add(456);
		list2.add(21);
		list2.add(74);
		list2.add(76);					// Auto Boxing

		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
		
		// 오름차순으로 리스트 정렬하는 메소드
		Collections.sort(list);
		Collections.sort(list2);

		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
		
		// 내림차순으로 리스트 정렬하는 메소드
		Collections.reverse(list);		
		Collections.reverse(list2);		

		
		System.out.println(list);
		System.out.println(list2);

		
	}
	
	
	public void method3() {
		// Music 객체를 list에 담아서 출력하고 정렬해보기
		
		List<Music> list = new ArrayList<>();
		
		list.add(new Music("Permission to Dance", "BTS", 1));		
		list.add(new Music("Butter", "BTS", 3));
		list.add(new Music("Solo", "Jenny",5));
		list.add(new Music("뜨거운 여름밤은 가고 남은 건 볼품없지만","잔나비",2));
		list.add(new Music("밤편지","IU",4));			// 저장된 순서대로 출력
		
		for(Music music : list) {
			System.out.println(music);
		}
		
		Collections.sort(list);		// comparable인터페이스를 구현해 주지 않아서 생기는 오류 -> Music -> implements 추가해주면 에러가 해결된다.
		System.out.println();
		
		Collections.sort(list);	
		
		for(Music music : list) {
			System.out.println(music);
		}
		
		System.out.println();
		
//		Collections.reverse(list);		// 역순
//		
//		for(Music music : list) {
//			System.out.println(music);
//		}
		
		Collections.sort(list, new TitleAscending());	
		
		for(Music music : list) {
			System.out.println(music);
		}	
		
		System.out.println();
		
		Collections.sort(list, new ArtistAscending());	
		
		for(Music music : list) {
			System.out.println(music);
		}	
		
	}

}
