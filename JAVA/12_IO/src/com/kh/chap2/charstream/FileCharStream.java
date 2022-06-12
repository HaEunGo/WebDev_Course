package com.kh.chap2.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharStream {
	public void fileSave() {
		System.out.println("fileSave() 호출");
		
		// try-with-resource 문을 통해서 사용한 리소스를 자동으로 close() 시킨다. 
		//	-> try(resource) { ... }
		// FileWriter를 사용해서 파일을 생성하고 데이터를 문자 단위로 저장한다.
		try (FileWriter fw = new FileWriter("b_char.txt", true)) {
			
			fw.write("녹차 백차 홍차");								// 문자열
			fw.write("오늘도 공부공부공부");
			fw.write('A');										// 문자
			fw.write(' ');
			fw.write('\n');
			
			fw.write(new char[] {'a', 'p', 'p', 'l', 'e'});		// 배열
//			fw.write(new char[] {'a', 'p', 'p', 'l', 'e'}, 1, 3);

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println("fileSave() 종료");
		}
	}
	
	public void fileRead() {
		System.out.println("fileRead() 호출");
		
		// FileReader를 사용해서 파일에서 데이터를 문자 단위로 읽어온다.
		try (FileReader fr = new FileReader("b_char.txt")) {
			int value = 0;
			
			while((value = fr.read()) != -1) {
				System.out.println((char) value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("fileRead() 종료");
		}
	}
}
