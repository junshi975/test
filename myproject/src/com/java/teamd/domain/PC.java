package com.java.teamd.domain;

/**
 * 
 * @Description 实现Equipment的类 放电脑
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月2日下午12:23:23
 *
 */
public class PC implements Equipment {

	/**
	 * 机器型号
	 */
	private String model;// 机器型号
	/**
	 * 显示器名称
	 */
	private String display;// 显示器名称

	public PC() {
		super();
	}

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override // 需要重写的方法 领用的设备
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + display + ")";
	}
	

}
