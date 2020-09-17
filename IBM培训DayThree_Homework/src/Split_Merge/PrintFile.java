package Split_Merge;

import java.io.File;

public class PrintFile {
	public void printFile(File src) {
		System.out.println("-表示一级文件夹，--表示二级文件夹，以此类推\n");
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


