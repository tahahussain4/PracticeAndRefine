package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class TestingDS {
	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("sampleText.txt",false);
			fileReader = new FileReader("sampleText.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.append("testString");
			for(int i =0;i<10000000;i++);
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			bufferedReader = new BufferedReader(fileReader);
			System.out.println(bufferedReader.readLine());
		} catch (IOException e) {
			try {
				bufferedReader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}				
}
