package com.kh.chap2.set;

import java.util.Set;
import java.util.TreeSet;

import com.kh.chap2.set.model.vo.Music;

public class B_TreeSet {
	
	public void method1() {
		TreeSet<String> ts = new TreeSet<>();
		
		// 중복 제거, 저장 순서 유지 안됨(단, 객체를 오름차순으로 정렬한다.)
		ts.add("다다다");	
//		ts.add(null);					// treeSet같은 경우에는 null을 사용할 수 없다.
//		ts.add(null.compareTo());		// NullPointerException 발생
		ts.add("나나나");
		ts.add("가가가");
//		ts.add(null);
		ts.add("마마마");
		ts.add("라라라");
//		ts.add(null);
		ts.add("가가가");

		System.out.println(ts);
		System.out.println();
		
		// iterator, 향상된 for문 사용 가능
		for(String str : ts) {
			System.out.println(str);
		}
	}


	public void method2() {
		Set<Music> set = new TreeSet<>();
		
		// 중복제거 같은 경우는 hashComde(), equals() 메소드를 가지고 판단해서 중복을 제거한다.
		// 저장 순서는 유지되지 않지만 우리가 재정의한 compareTo() 메소드에 의해 오름차순으로 정렬된다.
		// 강의 다시 듣기 - 0913 3,4교시?
		set.add(new Music("Permission to Dance", "BTS", 1));	
		set.add(new Music("Permission to Dance", "BTS", 1));		
		set.add(new Music("Butter", "BTS", 3));
		set.add(new Music("Butter", "BTS", 3));
		set.add(new Music("Solo", "Jenny",5));
		set.add(new Music("뜨거운 여름밤은 가고 남은 건 볼품없지만","잔나비",2));
		set.add(new Music("밤편지","IU",4));	
		set.add(new Music("밤편지","IU",4));	
		
		
		for (Music music : set) {
			System.out.println(music);
		}

	}
}
