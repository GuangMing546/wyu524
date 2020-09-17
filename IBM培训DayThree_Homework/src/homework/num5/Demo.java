package homework.num5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import homework.num1.Emp;

public class Demo {
	/**
	 * 5����ȡ��ǰ��Ŀ��Ŀ¼�����к�׺Ϊ.obj���ļ�������ЩEmp�����ȡ�����������뵽һ��List�����У�Ȼ����Ա�����ʴӶൽ�ٵ�˳���������Ա����Ϣ
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String dirPath=System.getProperty("user.dir");
		File srcFile=new File(dirPath);
		//������
		File[] files = srcFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File src, String name) {
				File file = new File(src, name);
				return file.isFile() && name.endsWith(".obj");
			}
		});

		sortEmp(files);
		
	}
	
	public static void printEmp(File[] files) throws FileNotFoundException, IOException, ClassNotFoundException {
		//��Emp�������
		ObjectInputStream ois=null;
		for (File file : files) {
			ois=new ObjectInputStream(new FileInputStream(file));
			Emp emp=(Emp) ois.readObject();
			System.out.println(emp.toString());
		}
		ois.close();
	}
	
	public static void sortEmp(File[] files) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Emp> list=new ArrayList<Emp>();
		ObjectInputStream ois=null;
		for (File file : files) {
			ois=new ObjectInputStream(new FileInputStream(file));
			Emp emp=(Emp) ois.readObject();
			list.add(emp);
		}
		ois.close();
		List<Integer> listSalary=new ArrayList<Integer>();
		Map<Integer, Emp> mapping=new HashMap<Integer, Emp>();
		for (Emp emp : list) {
			mapping.put(emp.getSalary(), emp);
			listSalary.add(emp.getSalary());
		}
		Collections.sort(listSalary);
		for (Integer integer : listSalary) {
//			System.out.println(integer);
			Emp emp=mapping.get(integer);
			System.out.println(emp.toString());
		}
		
//		Collections.sort(list, new SalaryComparator());
//		for (Emp emp : list) {
//			System.out.println(emp.toString());
//		}
	}
}
