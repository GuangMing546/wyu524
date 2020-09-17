package Split_Merge;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private static Properties pro=new Properties(); //创建一个无默认值的空属性列表;
	static {
		try {
			//加载.properties文件夹
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("Split_Merge/DB2.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File getSplitSrcFile() {
		String srcSplitPath=pro.getProperty("srcSplitPath");
		File srcFile=new File(srcSplitPath);
		if(!srcFile.isFile()) {
			System.out.println("源路径的File对象不存在或者是一个文件夹File");
			return null;
		}
		return srcFile;
	}
	
	public static File getSplitDestFile() {
		String destFilePath=pro.getProperty("destSplitPath");
		File destFile=new File(destFilePath);
		if(destFile.isFile()) {
			System.out.println("分割文件的目标File对象要为文件夹File对象！");
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
			System.out.println("合并文件的源File对象不是一个已存在的文件夹");
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
