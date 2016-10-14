package com.latewind.bean;

import java.util.HashSet;
import java.util.Set;

import com.latewind.domain.Employee;

public class UserInfo {
	private int id;
	private String userName;
	private String  password;
	private String chnName;
	private String profession;
	private String opLimit;
	private Set orderses = new HashSet(0);
	private Set notices=new HashSet(0);
	private Set sendMsgs=new HashSet(0);
	private Set receptMsgs=new HashSet(0);
	private Employee employee;
	
/*
	public UserInfo(){
		
	}
	
	public UserInfo(String username, String password, String chnname, String profession, String limit) {
		this.userName = username;
		this.password = password;
		this.chnName = chnname;
		this.profession = profession;
		this.limit = limit;
	}

	public UserInfo(String username, String password, String chnname, String profession, String limit, Set orderses) {
		this.userName = username;
		this.password = password;
		this.chnName = chnname;
		this.profession = profession;
		this.limit = limit;
		this.orderses = orderses;
	}
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChnName() {
		return chnName;
	}
	public void setChnName(String chnName) {
		this.chnName = chnName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * @return the orderses
	 */
	public Set getOrderses() {
		return orderses;
	}
	/**
	 * @param orderses the orderses to set
	 */
	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}
	/**
	 * @return the opLimit
	 */
	public String getOpLimit() {
		return opLimit;
	}
	/**
	 * @param opLimit the opLimit to set
	 */
	public void setOpLimit(String opLimit) {
		this.opLimit = opLimit;
	}
	/**
	 * @return the notices
	 */
	public Set getNotices() {
		return notices;
	}
	/**
	 * @param notices the notices to set
	 */
	public void setNotices(Set notices) {
		this.notices = notices;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * @return the sendMsgs
	 */
	public Set getSendMsgs() {
		return sendMsgs;
	}
	/**
	 * @param sendMsgs the sendMsgs to set
	 */
	public void setSendMsgs(Set sendMsgs) {
		this.sendMsgs = sendMsgs;
	}
	/**
	 * @return the receptMsgs
	 */
	public Set getReceptMsgs() {
		return receptMsgs;
	}
	/**
	 * @param receptMsgs the receptMsgs to set
	 */
	public void setReceptMsgs(Set receptMsgs) {
		this.receptMsgs = receptMsgs;
	}
	

}
