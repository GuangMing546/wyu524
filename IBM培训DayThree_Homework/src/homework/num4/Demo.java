package homework.num4;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import homework.num1.Emp;

public class Demo {
	/*
	 * 要求用户控制台输入想输入的员工人数（至少5个），
	 * 然后依序输入员工信息，每行为 一条员工信息，格式如:张三,25,男,5000,2019-3-18，
	 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
	 */
	public static void main(String[] args) throws ParseException, IOException {
		Scanner scanner=new Scanner(System.in);
//		System.out.println("请输入你要录入信息的员工个数：");
//		int num=scanner.nextInt();
//		
		String[] empStrings=new String[3];
		
		for(int i=0;i<empStrings.length;i++) {
			empStrings[i]=scanner.nextLine().trim();
		}
		
		List<Emp> empList=Util.stringToEmps(empStrings);
		String dirPath=System.getProperty("user.dir");
		System.out.println(dirPath);
		Util.objToFile(empList);
	}
	
	

}
