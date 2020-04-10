package com.java.teamd.domain;

/**
 * 
 * @Description 打印机
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月5日上午11:14:12
 *
 */
public class Printer implements Equipment {

	/**
	 * 机器的型号
	 */
	private String name;
	/**
	 * 机器的类型
	 */
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Printer() {
		super();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return name + "(" + type + ")";
	}

}
