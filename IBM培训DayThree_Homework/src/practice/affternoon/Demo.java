package practice.affternoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * 
 * @author GuangMing
 *
 */
public class Demo {
	public static void main(String[] args) throws IOException {	
		File srcFile=new File("e:/TestSplitFile/木叶村上忍名册.txt");
		readFromFile(srcFile);
		writeToFile(srcFile);
		System.out.println("\n-----写入文件后-----\n");
		readFromFile(srcFile);
	}
	public static void readFromFile(File srcFile) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), "utf-8"));
		String msg = null;
		while (null != (msg = br.readLine())) {
			System.out.println(msg);
		}
		br.close();
	}
	public static void writeToFile(File srcFile) throws IOException {
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(srcFile, true),"utf-8"));
		bw.newLine();
		bw.write("我最喜欢卡卡西！");
		bw.close();
	}
}
