package Split_Merge;

import java.io.File;
/**
 * 运行类
 * @author GuangMing
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		//分割文件
		File src=FileUtil.getSplitSrcFile(); //是一个文件,必须真实存在
		File dest=FileUtil.getSplitDestFile(); //是一个文件夹，可以不存在
		new SplitFile(src, dest, 1024*6); //10240是一个long类型的数值，代表文件分块每一块的大小，单位是字节（B，1024B=1KB）
		
		File printFile=FileUtil.getPrintFile();
		new PrintFile().printFile(printFile);
		
		//合并文件
		File srcFile=FileUtil.getMergeSrcFile(); //是一个文件夹，必须真实存在
		File destFile=FileUtil.getMergeDestFile(); //也是一个文件夹
		new MergeFile(srcFile, destFile);
		
	}

}
