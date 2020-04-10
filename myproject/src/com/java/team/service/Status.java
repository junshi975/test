package com.java.team.service;
/**
 * 
* @Description 封装员工的状态  (空闲，已经加入团队中，正在休假）
* @author JUNSHI  Email:405773808@qq.com  
* @version   （枚举类）
* @date 2020年3月2日下午12:40:01  
*
 */
public class Status {
	
	/**
	 * 枚举类对象的属性
	 */
	private final String NAME;

	private Status(String name) {
		this.NAME = name;
	}
	//单例 有限格的
	public static final Status FREE = new Status("FREE");
	public static final Status VOCATION = new Status("VOCATION");
	public static final Status BUSY = new Status("BUSY");

	public String getNAME() {//因为是final所以没有set方法
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}
}
