package Split_Merge;

import java.io.File;

public class PrintFile {
	public void printFile(File src) {
		System.out.println("-��ʾһ���ļ��У�--��ʾ�����ļ��У��Դ�����\n");
		printFileDetil(src, 0);
	}
	public void printFileDetil(File src,int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if(src.isDirectory()) {
			for (File file : src.listFiles()) {
				printFileDetil(file, level+1);
			}
		}
	}
}


