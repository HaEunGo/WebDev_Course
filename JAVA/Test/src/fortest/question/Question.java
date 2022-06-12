package fortest.question;

import java.util.Scanner;

public class Question {
	
	public void count() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			} else {
				System.out.println(str.length() + "글자입니다.");
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
}

//public class Overloading{
//	public void test1() {}
//	public void test2(String str) {}
//	public void test3(int i) {}
//	public void test(String s) {}
//	public void test(char ch) {}
//	public void test(String str, int i) {}
//	public void test(int i, String str) {}
//	private void test(int i) {}
//	public int test() {return 0;}
//}
