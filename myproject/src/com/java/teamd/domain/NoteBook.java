package com.java.teamd.domain;
/**
 * 
* @Description 笔记本电脑  
* @author JUNSHI  Email:405773808@qq.com  
* @version   
* @date 2020年3月5日下午12:37:45  
*
 */
public class NoteBook implements Equipment {

	/**
	 * 机器型号
	 */
	private String model;
	/**
	 * 价格
	 */
	private double price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public NoteBook() {
		super();
	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + price + ")";
	}

}
