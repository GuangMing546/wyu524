package Split_Merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MergeFile {
	File[] srcFiles;
	File destFile;
	Map<Integer, File> mapping=new HashMap<Integer, File>();
	
	public MergeFile(File srcFile,File destFile) {
		this.srcFiles=srcFile.listFiles();
		initMap();
		String destName=setName(srcFiles);
		this.destFile=new File(destFile, destName);
		mergeFile();
	}
	private String setName(File[] srcFiles) {
		String srcName=srcFiles[0].getName();
		String destNameHead=srcName.substring(0, srcName.indexOf("_"));
		String destNameFoot=srcName.substring(srcName.lastIndexOf("."));
		return destNameHead+destNameFoot;
	}
	//避免源文件夹中的排列方式问题，导致文件分割的到目标文件夹中，排列顺序不按顺序排列，后面的合并文件功能就会出问题
	private void initMap() {
		for (File file : srcFiles) {
			String fileName=file.getName();
			String num=fileName.substring(fileName.lastIndexOf("t")+1, fileName.indexOf("."));
//			System.out.println(num);
			mapping.put(Integer.valueOf(num), file);
		}
	}
	
	private void mergeFile() {
		InputStream is=null;
		OutputStream os=null;
		try {
			os=new FileOutputStream(destFile, true);
			for(int i=0;i<srcFiles.length;i++) {
				is=new FileInputStream(mapping.get(i));
				byte[] buffer=new byte[1024];
				int len=0;
				while(-1!=(len=is.read(buffer))) {
					os.write(buffer, 0, len);
				}
				os.flush();
				is.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			CloseUtil.closeAll(os);
		}
	}

}
