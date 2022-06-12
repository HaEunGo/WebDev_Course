package com.kh.chap1;

import com.kh.chap1.thread.Thread1;
import com.kh.chap1.thread.Thread2;

public class Application {

	public static void main(String[] args) {
		Thread1 th1 = new Thread1();
		
		//thread 스케쥴링 방식
		th1.setPriority(Thread.MAX_PRIORITY);		// Max_Priority 대신 정수값을 입력해도 된다.
		
		
//		th1.run();
		th1.start();
		
		Thread th2 = new Thread(new Thread2());
		
		//thread 스케쥴링 방식
		th2.setPriority(Thread.MAX_PRIORITY);
//		th2.run();
		th2.start();
		
		// 2-1) 익명 구현 객체
		// [표현법]
		// 		- new 인터페이스() { ... 구현내용 ... }
		//
		//	- 자바에서는 소스 파일을 만들지 않고도 구현 객체를 만들 수 있는 방법을 제공하는데 그 방법을 익명 구현 객체라고 한다.
		//	- 객체를 생성할 때 인터페이스를 직접 구현해서 객체를 생성할 수 있다.
		//	- 중괄호{ ... }에는 인터페이스에 선언된 모든 추상 메소드들을 재정의해서 작성해야 한다.
		
		Thread th3 = new Thread(new Runnable() {		// 추상메소드로 구현
			
			@Override
			public void run(){
				for (int i = 0; i < 1000; i++) {
		
					System.out.println(Thread.currentThread().getName() + "[" + i + "]");
				}
			}
		});
		
		th3.start();

		// 2-2) 람다식을 통한 익명 구현 객체 (참고)
		Thread th4 = new Thread(() -> {
			try {
				for (int i = 0; i < 1000; i++) {
					Thread.sleep(5);		// Daemon Thread 실습
					System.out.println(Thread.currentThread().getName() + "[" + i + "]");
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		th4.setDaemon(true);		// Daemon Thread 실습
		th4.start();
		
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인스레드 종료");
		
	}
}
