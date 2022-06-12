package com.kh.chap3;

import com.kh.chap3.assiststream.A_BufferedStream;
import com.kh.chap3.assiststream.B_ByteToCharStream;
import com.kh.chap3.assiststream.C_DataStream;
import com.kh.chap3.assiststream.D_ObjectStream;

public class Application {

	public static void main(String[] args) {
		
//		new A_BufferedStream().fileSave();
//		new A_BufferedStream().fileRead();

//		new B_ByteToCharStream().input();
//		new B_ByteToCharStream().output();
		
//		new C_DataStream().fileSaveAndRead();
		
		new D_ObjectStream().fileSave();
		new D_ObjectStream().fileRead();

	}
}
