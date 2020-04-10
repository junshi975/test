package com.java.team.jutil;

import org.junit.Test;

import com.java.team.service.NameListService;
import com.java.team.service.TeamException;
import com.java.teamd.domain.Employee;
/**
 * 
* @Description 对NameListServiceTest类的测试
* @author JUNSHI  Email:405773808@qq.com  
* @version   
* @date 2020年3月5日下午9:50:57  
*
 */
public class NameListServiceTest {
	
	@Test
	
	public void testGetAllEmloyees() {
		NameListService service = new NameListService();
		
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i < employees.length;i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	@Test
	public void testGetEmloyees() {
		NameListService service = new NameListService();
		
		int id = 101;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
