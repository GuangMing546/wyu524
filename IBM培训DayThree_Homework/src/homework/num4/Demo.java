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
	 * Ҫ���û�����̨�����������Ա������������5������
	 * Ȼ����������Ա����Ϣ��ÿ��Ϊ һ��Ա����Ϣ����ʽ��:����,25,��,5000,2019-3-18��
	 * Ȼ�󽫸ö���д�뵽�ļ�<name>.obj�����浽��ǰ��Ŀ��Ŀ¼�У�����:����.obj��
	 */
	public static void main(String[] args) throws ParseException, IOException {
		Scanner scanner=new Scanner(System.in);
//		System.out.println("��������Ҫ¼����Ϣ��Ա��������");
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
