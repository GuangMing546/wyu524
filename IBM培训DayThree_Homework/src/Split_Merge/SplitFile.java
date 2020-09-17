package Split_Merge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SplitFile {
	private long fileLength;
	private int size; //一共要分多少块
	private List<String> blockName=new ArrayList<String>(); //每一块的名字
	private long blockSize; //每一块的大小
	
	private File src; //源文件的数据源
	private File dest; //目的地文件夹
	
	public SplitFile(File src,File dest,long blockSize) {
		this.src=src;
		this.dest=dest;
		this.blockSize=blockSize;
		this.fileLength=src.length();
		init();
	}
	public SplitFile(File src,File dest) {
		this.src=src;
		this.dest=dest;
		this.blockSize=1024;
		this.fileLength=src.length();
		init();
	}
	private void init() {
		//确定一共分几块
		if(blockSize>=fileLength) {
			size=1;
			blockSize=fileLength;
		}else {
			size=(int) (fileLength/blockSize);
			if(0!=(fileLength%blockSize)) {
				size++;
			}
		}
		//为每一个文件块设置一个名字
		setName();
		splitFile();
	}
	private void setName() {
		String fileName=src.getName();
		String[] str=fileName.split("\\.");
		for (int i = 0; i < size; i++) {
			blockName.add(str[0] + "_part"+i +"."+ str[1]);
		}
	}
	private void splitFile() {
		long actuallyBlockSize=blockSize;
		long beginPos=0;
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				actuallyBlockSize=fileLength-beginPos;
			}
			splitFileDetil(beginPos, actuallyBlockSize, i);
			beginPos+=actuallyBlockSize;
		}
	}
	private void splitFileDetil(long beginPos,long actuallyBlockSize,int i) {
		RandomAccessFile raf=null;
		OutputStream os=null;
		File destPart=new File(dest, blockName.get(i));
		try {
			raf=new RandomAccessFile(src, "r");
			raf.seek(beginPos);
			os=new FileOutputStream(destPart);
			byte[] buffer=new byte[1024];
			int len=0;
			while(-1!=(len=raf.read(buffer))) {
				if(actuallyBlockSize<=len) {
					os.write(buffer, 0, (int) actuallyBlockSize);
					break;
				}else {
					os.write(buffer, 0, len);
					actuallyBlockSize-=len;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			CloseUtil.closeAll(os,raf);
		}
	}
}
