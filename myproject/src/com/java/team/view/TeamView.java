package com.java.team.view;

import com.java.team.service.NameListService;
import com.java.team.service.TeamException;
import com.java.team.service.TeamService;
import com.java.team.util.TSUtility;
import com.java.teamd.domain.Employee;
import com.java.teamd.domain.Programmer;

public class TeamView {

	private NameListService listSvc = new NameListService();// 供类中的方法使用
	private TeamService teamSvc = new TeamService();// 供类中的方法使用

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

	/**
	 * 
	 * @Description 主页面
	 * @author JUNSHI
	 * @date 2020年3月6日下午2:26:15
	 */
	public void enterMainMenu() {
		boolean loopFlag = true;
		char key = 0;
		do {
			if (key != '1') {

				listAllEmployees();
			}

			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			key = TSUtility.readMenuSelection();
			switch (key) {

			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break; 
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char into = TSUtility.readConfirmSelection();
				if (into == 'Y') {
					loopFlag = false;
				}

			}
		} while (loopFlag);
	}

	/**
	 * 
	 * @Description 以表格形式列出公司所有成员
	 * @author JUNSHI
	 * @date 2020年3月6日下午2:26:40
	 */
	private void listAllEmployees() {
		System.out.println("-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {// 一般需要这样判断防止空指针的异常出现
			System.out.println("公司中没有员工信息！");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t\t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("-------------------------------------------------------------------------------");

	}

	/**
	 * 
	 * @Description 显示团队成员列表操作
	 * @author JUNSHI
	 * @date 2020年3月6日下午2:26:52
	 */
	private void getTeam() {
//		System.out.println("查看开发团队情况：");
		System.out.println("--------------------团队成员列表---------------------\n");
		Programmer[] team = teamSvc.getTeam();//判断团队是否有成员
		if(team == null || team.length == 0) {
			System.out.println("该开发团队没有成员！");
		}else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for(int i = 0;i < team.length;i++) {
				System.out.println(team[i].getTeamDetails());
			}
		}
		System.out.println("-----------------------------------------------------");
	}

	/**
	 * 
	 * @Description 实现添加成员操作
	 * @author JUNSHI
	 * @date 2020年3月6日下午2:27:01
	 */
	private void addMember() {
		System.out.println("---------------------添加成员---------------------");
		System.out.print("请输入需要添加的员工ID：");
		int id = TSUtility.readInt();
		
		try {
			Employee e = listSvc.getEmployee(id);//获取指定id的员工对象
			teamSvc.addMember(e);//向团队中添加成员
			System.out.println("添加成功！");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		TSUtility.readReturn();//按回车键继续
	}

	/**
	 * 
	 * @Description 实现删除成员操作
	 * @author JUNSHI
	 * @date 2020年3月6日下午2:27:15
	 */
	private void deleteMember() {
		System.out.println("---------------------删除成员---------------------");
		System.out.print("请输入需要删除的员工TID：");
		int memberId = TSUtility.readInt();
		
		System.out.print("确认是否删除(Y/N):");
		
		char isflag = TSUtility.readConfirmSelection();
		if(isflag == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功！");
		} catch (TeamException e) {
			System.out.println("删除失败，原因是：" + e.getMessage());
		}
		
		TSUtility.readReturn();//按回车键继续
		
	}

}
