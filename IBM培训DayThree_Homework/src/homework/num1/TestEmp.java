package homework.num1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author GuangMing
 *
 */
public class TestEmp {

	public static void main(String[] args) throws ParseException {
		//��������
		Emp emp=new Emp("��ľ������", 18, "��", 8000, new Date(System.currentTimeMillis()));
		//��дtoString����
		System.out.println(emp.toString());
		//��newһ���¶���
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Emp emp2=new Emp("��ľ������", 18, "��", 8000, df.parse("2019-10-18")); //��ʽ��ʱ��
		//��дtoString����
		System.out.println(emp2.toString());
		//��д��equals����
		System.out.println("emp==emp2 ? ---> "+emp.equals(emp2));
		
	}
	
}
