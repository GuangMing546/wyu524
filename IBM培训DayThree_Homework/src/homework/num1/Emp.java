package homework.num1;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 1������Emp�� ����˽������: String name��int age��String gender ��int salary�� Date hiredate;��ְʱ�� 
 * ���幹�췽�����Լ�����get,set����. ����toString��������ʽ��:
 * ����:����,����:25,�Ա�:��,н��:5000,��ְʱ��:2020-01-11 ����equals������Ҫ�����֣����䣬�Ա�н�ʶ���ͬ������Ϊ����һ�¡�
 * ʵ�����л��ӿڣ�������汾�š�
 * 
 * @author GuangMing
 *
 */
public class Emp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //�汾��
	
	private String name;
	private int age;
	private String gender;
	private int salary;
	private Date hireDate;
	
	public Emp() {
		
	}

	/**
	 * @param name
	 * @param age
	 * @param gender
	 * @param salary
	 * @param hireDate
	 */
	public Emp(String name, int age, String gender, int salary, Date hireDate) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Emp [������" + name + ", ���䣺" + age + ", �Ա�" + gender + ", н�ʣ�" + salary + ", ��ְʱ�䣺"
				+ formatDate(hireDate) + "]";
	}
	
	public String formatDate(Date hireDate) {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=df.format(hireDate);
		return dateString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	

	
	
	
}
