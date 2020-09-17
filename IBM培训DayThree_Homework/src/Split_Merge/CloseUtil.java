package Split_Merge;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class CloseUtil {
	public static void closeAll(Closeable ...cs) {
		for (Closeable c : cs) {
			try {
				if (null != c) {
					c.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		File src=new File("d:/TestSplitFile/ͼƬ.jpg");
//		System.out.println(src.isFile());
//		int i=1;
//	}
	
}
