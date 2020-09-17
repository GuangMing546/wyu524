package practice.moring;

import java.io.File;

/**
 * 打印文件夹的信息
 * @author GuangMing
 *
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("-表示一级文件夹，--表示二级文件夹，以此类推\n");
		
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
