package homework.num2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo {
	public static void main(String[] args) throws IOException {
		File srcFile=new File("d:/Test/myfile.txt");
		InputStream is=new FileInputStream(srcFile);
		OutputStream os=new FileOutputStream("d:/Test/myfile_cp.txt");
		byte[] buffer=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(buffer))) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}

}
