package homework.num7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ConsoleToFile {
	public static void main(String[] args) throws IOException {
		File parentFile=new File("d:/TestConsoleToFile");
		if(!parentFile.isDirectory()) {
			parentFile.mkdir();
		}
		System.out.println("-----�ļ���������d:/TestConsoleToFile-----");
		System.out.print("������һ���ļ�����");
		Scanner scanner=new Scanner(System.in);
		String filePath=scanner.nextLine();
		File destFile=new File(parentFile, filePath);
		System.out.println("���������������ݣ�������exit�˳���");
		
		BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile,true),"gbk"));
		String msg =scanner.nextLine();
		while(!msg.equals("exit")) {
			bWriter.write(msg);
			bWriter.newLine();
			msg=scanner.nextLine();
		}
		System.out.println("�˳��ɹ�~");
		bWriter.close();
	}
}
