package homework.num4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import homework.num1.Emp;

public class Util {

	public static List<Emp> stringToEmps(String[] employee) throws ParseException{
		List<Emp> emplList=new ArrayList<Emp>();
		for (String empString : employee) {
			Emp emp=new Emp();
			String[] arrays=empString.split(",");
			emp.setName(arrays[0]);
			emp.setAge(Integer.parseInt(arrays[1]));
			emp.setGender(arrays[2]);
			emp.setSalary(Integer.parseInt(arrays[3]));
			DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd");
			emp.setHireDate(dFormat.parse(arrays[4]));
			emplList.add(emp);
		}
		return emplList;
	}
	
	public static void objToFile(List<Emp> empList) throws IOException {
		String dirPath=System.getProperty("user.dir");
		List<File> fileList=new ArrayList<File>();
		OutputStream os=null;
		ObjectOutputStream oos=null;
		for (Emp emp : empList) {
//			fileList.add(new File(dirPath, "/"+emp.getName()+".obj"));
			File file=new File(dirPath, "/"+emp.getName()+".obj");
			os = new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			oos.writeObject(emp);
		}
		oos.close();
		os.close();
	}
}
