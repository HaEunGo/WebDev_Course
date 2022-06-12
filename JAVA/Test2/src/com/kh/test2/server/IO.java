package com.kh.test2.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	public void output() {
		
		try (FileWriter fw = new FileWriter("test.txt", true)) {
			
			fw.write(97);
			fw.write(65);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void read() {
		try (FileReader fr = new FileReader("test.txt")) {
			int value = 0;
			
			while((value = fr.read()) != -1) {
				System.out.println((int) value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		}





}

