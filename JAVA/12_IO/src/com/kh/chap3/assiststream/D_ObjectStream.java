package com.kh.chap3.assiststream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap3.assiststream.model.vo.Member;

public class D_ObjectStream {
	
	// 객체 입출력 보조 스트림
	public void fileSave() {
		Member member = new Member("mrhong", "1234", "홍길동", 20, 'M');
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.dat"))) {
			System.out.println("객체 입력 전");
			
			oos.writeObject(member);
			
			System.out.println("객체 입력 후");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileRead() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.dat"))) {
			System.out.println("객체 출력 전");
			
			Member member = (Member) ois.readObject();
			
			System.out.println(member);
			System.out.println("객체 출력 후");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void objectsSave() {
		// Member 객체를 배열에 담아서 반복문을 통해서 파일에 저장하기("f_objects.dat");
	}
	
	public void objectsRead() {
		// 파일에 저장 된 Member 객체를 읽어서 배열에 저장 후 각 객체의 toString() 메소드를 출력
	}


}
