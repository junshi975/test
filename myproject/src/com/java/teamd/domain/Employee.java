package com.java.teamd.domain;
/**
 * 一般类都需要提供toString方法
* @Description   雇员最大的父类（员工）
* @author JUNSHI  Email:405773808@qq.com  
* @version   
* @date 2020年3月5日上午11:21:38  
*
 */
public class Employee {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 工资
	 */
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	/**
	 * 
	* @Description   方便在Employee的子类重写toString
	* @author JUNSHI  
	* @date 2020年3月5日下午11:05:59  
	* @return
	 */
	public String getDetails() {
		return id + "\t" + name + "\t" + age + "\t" + salary + "\t";
	}
	
	@Override
	public String toString() {
		
		return getDetails();
		
	}

}
