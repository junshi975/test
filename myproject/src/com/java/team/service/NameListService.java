package com.java.team.service;

import static com.java.team.service.Data.*;

import com.java.teamd.domain.Architect;
import com.java.teamd.domain.Designer;
import com.java.teamd.domain.Employee;
import com.java.teamd.domain.Equipment;
import com.java.teamd.domain.NoteBook;
import com.java.teamd.domain.PC;
import com.java.teamd.domain.Printer;
import com.java.teamd.domain.Programmer;

/**
 * 
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author JUNSHI Email:405773808@qq.com
 * @version V1.0
 * @date 2020年3月5日上午11:42:26
 *
 */
public class NameListService {
	/**
	 * 用来保存公司所有员工对象
	 */
	// 如： 2 马化腾 32 18000.0 架构师 FREE 15000.0 2000 联想T4(6000.0)这就是一条对象

	private Employee[] employees;

	/**
	 * 给employees及数组元素进行初始化
	 */
	public NameListService() {
//		1.根据项目提供的Data类构建相应大小的employees数组
//		2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		3.将对象存于数组中
		// 1.调用Data类中的静态结构
		employees = new Employee[EMPLOYEES.length];// 开辟一条长度EMPLOYEES数组
		// 2.先判断需要new 什么类型的员工 则需要在数组的外层元素一一判断 取决于Data中第一个常量
		// 如果是10的话就是一个employees 获取员工的类型
		for (int i = 0; i < employees.length; i++) {
			// EMPLOYEES[i][0]这个位置中是一个String类型的对象，每个类型员工都有相应的常量，要比常量所以转为包装类
			int type = Integer.parseInt(EMPLOYEES[i][0]);// String转int包装类 type得到的是10或11或12.。。

			// 获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);// 在数组里id是String型
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);// String 转Double型

			// 判断得到什么类型得员工就new相应的员工对象
//			Equipment equipment = createEquipment(i);//有可能有员工没有设备不然会报错
			Equipment equipment;// 声明设备让员工拥有相应的设备
			double bonus;// 有可能有员工没有奖金不然会报错，这样可以让有员工的时候再去赋值就不会出错
			int stock;// 有可能有员工没有股票不然会报错
			switch (type) {// 对应什么常量就new什么

			case EMPLOYEE:// 此时输出的type为10
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				// 只有成员以下的才有设备，看成员的第i项找对应得设备数组 EQUIPMENTS的第一项的常数
				// 把EQUIPMENTS数组中的元素转化成一条条对象，而对象又有好几种，是PC还是NOTEBOOK取决于第一个常数
				equipment = createEquipment(i);// 第i个员工的设备
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break; //不能漏掉 否则在同一个元素中创建两个对象导致角标异常
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}

		}

	}

	/**
	 * 
	 * @Description 获取指定index上的员工设备
	 * @author JUNSHI
	 * @date 2020年3月5日下午7:50:24
	 * @param index
	 * @return
	 */
	private Equipment createEquipment(int index) {// 返回类型Equipment
		// 先判断需要什么类型的设备 则需要在数组的外层元素一一判断 取决于Data中第一个常量
		int into = Integer.parseInt(EQUIPMENTS[index][0]);// String型转int型

		String modelOrName = EQUIPMENTS[index][1];// 对应的电脑
		switch (into) {

		case PC:// 21
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName, display);
		case NOTEBOOK:// 22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);
		case PRINTER:// 23
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		}
		return null;
	}
	/**
	 * 
	* @Description   获取当前所有员工。
	* @author JUNSHI  
	* @date 2020年3月5日下午9:11:49  
	* @return 获取当前所有员工。
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	* @Description 获取指定ID的员工对象。
	* @author JUNSHI  
	* @date 2020年3月5日下午9:13:42  
	* @param id 指定员工的ID
	* @return 指定员工对象
	 */
	public Employee getEmployee(int id) throws TeamException{
		for(int i = 0;i < employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
			throw new TeamException("找不到指定的员工！");
			
	
	}
}