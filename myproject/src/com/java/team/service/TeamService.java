package com.java.team.service;

import com.java.teamd.domain.Architect;
import com.java.teamd.domain.Designer;
import com.java.teamd.domain.Employee;
import com.java.teamd.domain.Programmer;

/**
 * 
 * @Description 关于开发团队成员的管理：添加、删除等。
 * @author JUNSHI Email:405773808@qq.com
 * @version
 * @date 2020年3月6日上午9:26:52
 *
 */
public class TeamService {
	/**
	 * 用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。
	 */
	private static int counter = 1;
	/**
	 * 限制开发团队最大成员数
	 */
	private final int MAX_MEMBER = 5;
	/**
	 * 用来保存当前团队中的各成员对象
	 */
	private Programmer[] team = new Programmer[MAX_MEMBER];
	/**
	 * 记录团队成员的实际人数
	 */
	private int total = 0;

	/**
	 * 
	 * @Description 返回当前团队的所有对象
	 * @author JUNSHI
	 * @date 2020年3月6日上午9:42:41
	 * @return 包含所有成员对象的数组，数组大小与成员人数一致
	 */
	public Programmer[] getTeam() {
//		return team; //可能空指针异常
		// 创造一个新的数组储存已有的成员
		Programmer[] team = new Programmer[total];// 长度为已拥有的成员
		for (int i = 0; i < team.length; i++) {// 给数组每个元素赋值
			team[i] = this.team[i];

		}

		return team;
	}

	/**
	 * 
	 * @Description 向团队中添加成员
	 * @author JUNSHI
	 * @date 2020年3月6日上午9:43:06
	 * @param e待添加成员的对象
	 */
	public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
		if (total >= team.length) {
			throw new TeamException("添加失败,团队成员已满！");
		}
//		该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {// 如果添加的成员不是Programmer的实例对象
			throw new TeamException("该成员不是开发人员，无法添加！");
		}

//		该员工已在本开发团队中
		if (isExist(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员 
//		该员正在休假，无法添加
		// 在上方已经判断过e能走下来肯定不是普通成员
		Programmer p = (Programmer) e;// 一定不会出现ClassCastException
		// 这样出现空指针异常的概率就减少了
		if ("BUSY".equals(p.getStatus().getNAME())) {// if(p.getStatus().getNAME().equals."BUSY")
			throw new TeamException("该员工已是某团队成员 !");
		} else if ("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加!");
		}

//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员

		// 获取team中已有架构师，设计师，程序员的人数
		int numOfPro = 0, numOfDes = 0, numOfArc = 0;
		for (int i = 0; i <= total; i++) {
			if (team[i] instanceof Architect) {// 如果该对象是架构师
				numOfArc++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}

		}
		// 正确的
		if (p instanceof Architect) {
			if (numOfArc >= 1) {
				throw new TeamException("团队中至多只能有一名架构师！");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中至多只能有两名设计师！");
			}
		} else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员!");
			}
		}
		// 错误的
//		if (p instanceof Architect && numOfArc >= 1) {
//			throw new TeamException("团队中至多只能有一名架构师！");
//		}else if(p instanceof Designer && numOfDes >= 2) {
//			throw new TeamException("团队中至多只能有两名设计师！");
//		}else if(p instanceof Programmer && numOfPro >= 3) {
//			throw new TeamException("团队中至多只能有三名程序员!");
//		}

		// 将e或p 添加到现有的team[]中
		team[total++] = p;
		// p的属性赋值
		p.setStatus(Status.BUSY);// 更改状态
		p.setMemberId(counter++);// 团队Id赋值

	}

	/**
	 * 
	 * @Description 判断员工是否在团队里面
	 * @author JUNSHI
	 * @date 2020年3月6日上午10:34:35
	 * @param e成员
	 * @return
	 */
	private boolean isExist(Employee e) {

		for (int i = 0; i < total; i++) {
//			if(team[i].getId() == e.getId()) {//如果团队中成员的id等于添加对象的ID
//				return true;//代表员工存在于成员列表中
//			}
			return team[i].getId() == e.getId();
		}
		return false;
	}

	/**
	 * 
	 * @Description 从团队中删除成员
	 * @author JUNSHI
	 * @date 2020年3月6日上午9:43:36
	 * @param 待删除成员的
	 * @throws TeamException
	 */
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {// 团队成员数组中遍历寻找
			if (team[i].getMemberId() == memberId) {// 如果团队中TID = 需要删除的ID
				team[i].setStatus(Status.FREE);// 让需要删除的成员的状态变回FREE
				break;
			}
		}
		// 如果未找到要删除元素的情况
		if (i == total) {
			throw new TeamException("找不到指定memberId的员工，删除失败!");
		}

		// 后一个元素覆盖前一个元素，实现删除操作
		for (int j = i; j < total - 1; j++) {
			team[j] = team[j + 1];
		}
//		for (int j = i + 1; j < total; j++) {
//			team[j - 1] = team[j];
//		}
		// 方式一：
//		team[total - 1] = null;//已有成员最后一个 - 1 将这个设为null
//		total--;//删去了一个已有成员就要-1
		// 方式二：
		team[--total] = null;

	}

}
