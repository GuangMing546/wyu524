package Split_Merge;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private static Properties pro=new Properties(); //����һ����Ĭ��ֵ�Ŀ������б�;
	static {
		try {
			//����.properties�ļ���
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Split_Merge/DB2.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File getSplitSrcFile() {
		String srcSplitPath=pro.getProperty("srcSplitPath");
		File srcFile=new File(srcSplitPath);
		if(!srcFile.isFile()) {
			System.out.println("Դ·����File���󲻴��ڻ�����һ���ļ���File");
			return null;
		}
		return srcFile;
	}
	
	public static File getSplitDestFile() {
		String destFilePath=pro.getProperty("destSplitPath");
		File destFile=new File(destFilePath);
		if(destFile.isFile()) {
			System.out.println("�ָ��ļ���Ŀ��File����ҪΪ�ļ���File����");
			return null;
		}
		if(!destFile.exists()) {
			destFile.mkdirs();
		}
		return destFile;
	}
	
	public static File getMergeSrcFile() {
		String srcMergePath=pro.getProperty("srcMergePath");
		File srcFile=new File(srcMergePath);
		if(srcFile.isDirectory()) {
			return srcFile;
		}else {
			System.out.println("�ϲ��ļ���ԴFile������һ���Ѵ��ڵ��ļ���");
			return null;
		}
	}
	public static File getMergeDestFile() {
		String destMergePath=pro.getProperty("destMergePath");
		File destFile=new File(destMergePath);
		if(!destFile.exists()) {
			destFile.mkdirs();
		}
		if(destFile.isFile()) {
			return null;
		}
		return destFile;
	}
	
	public static File getPrintFile() {
		String printFilePath=pro.getProperty("printFilePath");
		File printFile=new File(printFilePath);
		return printFile;
	}
}
