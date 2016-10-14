/**
 * 
 */
package com.latewind.action;

import java.util.Map;

import javax.lang.model.type.PrimitiveType;

import com.latewind.bean.UserInfo;
import com.latewind.domain.Department;
import com.latewind.domain.Employee;
import com.latewind.domain.Position;
import com.latewind.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class UserInfoAction extends ActionSupport {
	private String oldPw;
	private String newPw;
	private String newPw2;
	private UserInfoService userInfoService;
	private String errorInfo;
	private UserInfo userInfo;
	private Employee employee;
	private Position position;
	private Department department;

	public String modifyPw(){
		
		Map<String , Object>session= ActionContext.getContext().getSession();
//		session.put("userInfo", uInfo);
		UserInfo u=(UserInfo) session.get("userInfo");
		int userId=u.getId();
		u=userInfoService.findUserById(userId);
		
		System.out.println(oldPw+" "+ newPw+" "+newPw2+" "+u.getPassword());
		if (oldPw.equals(u.getPassword())&&newPw.equals(newPw2)) {
			
			u.setPassword(newPw2);
			userInfoService.addUser(u);//add=save+update£»
			
		}else{
			
			errorInfo="modify ´íÎó";
		}
			
		return "modify";
	}
	public String personalInfo(){
		Map<String , Object>session= ActionContext.getContext().getSession();
		userInfo=(UserInfo) session.get("userInfo");
		employee=userInfo.getEmployee();
//		System.out.println(e.getAddress());
		position =employee.getPosition();
		department=position.getDepartment();
//		department.getn
		
		return "personalInfo";
	}
	public String getOldPw() {
		return oldPw;
	}
	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	public String getNewPw2() {
		return newPw2;
	}
	public void setNewPw2(String newPw2) {
		this.newPw2 = newPw2;
	}
	/**
	 * @return the userInfoService
	 */
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	/**
	 * @param userInfoService the userInfoService to set
	 */
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	/**
	 * @return the errorInfo
	 */
	public String getErrorInfo() {
		return errorInfo;
	}
	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
