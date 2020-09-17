package homework.num5;

import java.util.Comparator;

import homework.num1.Emp;

public class SalaryComparator implements Comparator<Emp> {
	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		int age1=o1.getSalary();
		int age2=o1.getSalary();
		return age1-age2;
	}
}
