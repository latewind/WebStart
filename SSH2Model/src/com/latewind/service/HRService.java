/**
 * 
 */
package com.latewind.service;

import java.util.List;

import com.latewind.bean.UserInfo;
import com.latewind.domain.Department;
import com.latewind.domain.Employee;
import com.latewind.domain.Position;

/**
 * @author Administrator
 *
 */
public interface HRService {
	
	public Employee findEmployee(Integer id);
	public void addEmployee(Employee e);
	public Department findDepartment(Integer id);
	public Department findDeparmentByName(String name);
	public Position  findPosition(Integer id);
	
	public String addAccount(UserInfo u,Integer id);
	
	public List<Department> listAllDepartment();
	public List<Position> listAllPosition();
	public List<Employee> listAllEmployee();
	/**
	 * @param e
	 */
	void updateEmployee(Employee e);
}
