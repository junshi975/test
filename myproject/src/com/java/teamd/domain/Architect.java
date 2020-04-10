package com.java.teamd.domain;

/**
 * 
 * @Description 架构师
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月5日上午11:38:39
 *
 */
public class Architect extends Designer {

	/**
	 * 公司奖励的股票数量
	 */
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t"
				+ getStock() + "\t" + getEquipment().getDescription();
	}

	public String getTeamDetails() {
		return getTeamBaseDetails() + "架构师\t" + getBonus() + "\t" + getStock();
	}
}
