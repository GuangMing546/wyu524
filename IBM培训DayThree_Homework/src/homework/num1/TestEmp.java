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
		//创建对象
		Emp emp=new Emp("旗木卡卡西", 18, "男", 8000, new Date(System.currentTimeMillis()));
		//重写toString方法
		System.out.println(emp.toString());
		//再new一个新对象
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Emp emp2=new Emp("旗木卡卡西", 18, "男", 8000, df.parse("2019-10-18")); //格式化时间
		//重写toString方法
		System.out.println(emp2.toString());
		//重写了equals方法
		System.out.println("emp==emp2 ? ---> "+emp.equals(emp2));
		
	}
	
}
