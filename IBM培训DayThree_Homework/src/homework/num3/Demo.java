package homework.num3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo {

	public static void main(String[] args) throws IOException {
		File srcFile=new File("d:/Test/myfile.txt");
		BufferedReader br=new BufferedReader(new FileReader(srcFile));
		BufferedWriter bw=new BufferedWriter(new FileWriter("d:/Test/myfile_cp.txt"));
		String msg=null;
		while(null!=(msg=br.readLine())) {
			bw.write(msg);
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
