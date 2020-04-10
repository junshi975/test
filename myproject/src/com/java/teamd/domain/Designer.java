package com.java.teamd.domain;

/**
 * 
 * @Description 设计师
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月5日上午11:37:15
 *
 */
public class Designer extends Programmer {

	/**
	 * 奖金
	 */
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	// 2 马化腾 32 18000.0 架构师 FREE 15000.0 2000 联想T4(6000.0)
	@Override
	public String toString() {
		return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	public String getTeamDetails() {
		return getTeamBaseDetails() + "设计师\t" + getBonus() + "\t";
	}
}
