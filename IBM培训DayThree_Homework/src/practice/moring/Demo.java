package practice.moring;

import java.io.File;

/**
 * ��ӡ�ļ��е���Ϣ
 * @author GuangMing
 *
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("-��ʾһ���ļ��У�--��ʾ�����ļ��У��Դ�����\n");
		
		File srcFile=new File("e:/TestSplitFile");
		printFile(srcFile, 0);
	}
	public static void printFile(File srcFile,int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(srcFile.getName());
		if(srcFile.isDirectory()) {
			for (File file : srcFile.listFiles()) {
				printFile(file, level+1);
			}
		}
	}
}
