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
		System.out.println("-----文件将保存在d:/TestConsoleToFile-----");
		System.out.print("请输入一个文件名：");
		Scanner scanner=new Scanner(System.in);
		String filePath=scanner.nextLine();
		File destFile=new File(parentFile, filePath);
		System.out.println("请在下面输入内容：（输入exit退出）");
		
		BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile,true),"gbk"));
		String msg =scanner.nextLine();
		while(!msg.equals("exit")) {
			bWriter.write(msg);
			bWriter.newLine();
			msg=scanner.nextLine();
		}
		System.out.println("退出成功~");
		bWriter.close();
	}
}
