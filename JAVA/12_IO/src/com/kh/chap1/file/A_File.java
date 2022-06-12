package com.kh.chap1.file;

import java.io.File;
import java.io.IOException;

public class A_File {
	
	public void method1() {
		// File 클래스 테스트
		
		try {
			// 경로를 지정하지 않으면 현재 project 폴더에 파일이 생성된다.
			File file = new File("test.txt");	// 메모리상(Heap)에서만 존재하는 객체
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("절대 경로 : " + file.getAbsolutePath());
			System.out.println("상대 경로 : " + file.getPath());
			System.out.println("파일 용량 : " + file.length());
			System.out.println("하드디스크에 파일 존재 여부 : " + file.exists());
			System.out.println();
			
			file.createNewFile();		// 메소드를 실행해야지만 하드디스크에 실제 파일이 만들어진다.
			
			// 존재하는 경로까지 지정해 주면 해당 위치에 파일을 생성한다.
			// 만약에 존재하지 않는 경로를 제시하면 IOException이 발생한다. -> 경로 확인 먼저 해줘야 한다.
//			File file2 = new File("/Users/test2.txt");	// IOException ->  강사님은 이렇게 해도 잘 되던데 왜 내 컴퓨터에서는 아래껄로만 실행이 될까?
			File file2 = new File("/Users/hani/dev/test2.txt");
			
			file2.createNewFile();
//			file2.mkdirs();		// 생성은 가능하지만 디렉토리(폴더)로 생성이 된다. (test2.txt를 폴더명으로 인식함) -> mkdir에는 파일을 찾을 수 없기 때문에 IOException이 만들어진다.
			
			// 디렉토리(폴더) 만들기
			File tempDir = new File("/Users/hani/dev");
			
			tempDir.mkdir();		// 경로 및 디렉토리 생성
				
			File file3 = new File("/Users/hani/dev/test2.txt");
			
			file3.createNewFile();
			
			System.out.println("파일2 존재 여부 : " + file2.exists());
			System.out.println("파일3 존재 여부 : " + file3.exists());
			System.out.println("tempDir.isDirectory() : " + tempDir.isDirectory());
			System.out.println("file2.isFile() : " + file2.isFile());
			System.out.println("file3.isFile() : " + file3.isFile());
			System.out.println("file3.isDirectory() : " + file3.isDirectory());

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
}
