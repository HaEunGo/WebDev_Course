package com.kh.prac1;

public class Member {
	//회원 클래스
		final int num;
		String name;
		public Member(int num, String name){
			this.num = num;
			this.name = name;
		}
		public int getNum(){
			return num;
		}
		public String toString(){
			return String.format("번호:%d 이름:%s", num, name);		
		}
}
