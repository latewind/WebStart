/**
 * 
 */
package com.latewind.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Set;

import org.hibernate.dialect.function.VarArgsSQLFunction;

import com.latewind.domain.Department;
import com.latewind.domain.Employee;
import com.latewind.domain.Position;
import com.latewind.service.HRService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class EmployeeFormAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empId;
	private String name;
	private String sex;
	private Integer age;
	private String college;
	private String education;
	private String telephone;
	private String idcode;
	private String address;
	private String department;
	private String position;
	private Date entrytime;
	private String introduction;
	private HRService hrService;
	public HRService getHrService() {
		return hrService;
	}


	public void setHrService(HRService hrService) {
		this.hrService = hrService;
	}


	public String execute(){
		System.out.println(sex);
		System.out.println(department);
		//根据部门名称查找部门
		Department d=hrService.findDeparmentByName(department);
		Position pos = null;
		Set<Position> positions=d.getPositions();
		for(Position p:positions){//根据职位名称查找职位			
			if (p.getName().equals(position)) {
				pos=p;
				break;
			}
		}

		Employee e=new Employee(pos, name, sex, age, college, education, telephone, idcode, address, entrytime, introduction);
	
		if(empId!=null){
			System.out.println(empId);
			System.out.println("更新员工"+education);
			
			e.setId(empId);
			e.setEducation(education);
			hrService.addEmployee(e);//更新员工；
			hrService.updateEmployee(e);
			return "update";
		}
		hrService.addEmployee(e);//保存员工；
		System.out.println(name+"name form");
		return SUCCESS;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	/**
	 * @return the empId
	 */
	public Integer getEmpId() {
		return empId;
	}


	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	

}
