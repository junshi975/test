package com.java.teamd.domain;

import com.java.team.service.Status;

/**
 * 
 * @Description 程序员
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月5日下午12:37:13
 *
 */
public class Programmer extends Employee {
	/**
	 * 记录开发团队中的TID
	 */
	private int memberId;
	/**
	 * 员工的状态
	 */
	private Status status = Status.FREE;;// 空闲
	/**
	 * 表示该成员领用的设备
	 */
	private Equipment equipment;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public Programmer() {
		super();
	}

	// 2 马化腾 32 18000.0 架构师 FREE 15000.0 2000 联想T4(6000.0)
	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}

	public String getTeamBaseDetails() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t";
	}

	public String getTeamDetails() {
		return getTeamBaseDetails() + "程序员\t";
	}

}
