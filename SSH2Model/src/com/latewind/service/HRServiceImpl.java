/**
 * 
 */
package com.latewind.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.latewind.bean.UserInfo;
import com.latewind.dao.UserInfoDAO;
import com.latewind.domain.Department;
import com.latewind.domain.DepartmentDAO;
import com.latewind.domain.DepartmentHome;
import com.latewind.domain.Employee;
import com.latewind.domain.EmployeeDAO;
import com.latewind.domain.Position;
import com.latewind.domain.PositionDAO;

/**
 * @author Administrator
 *
 */
public class HRServiceImpl implements HRService {
	
	private EmployeeDAO employeeDAO;
	private PositionDAO positionDAO;
	private DepartmentDAO departmentDAO;
	private UserInfoDAO   userInfoDAO;
	
	private static final Log log = LogFactory.getLog(HRServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#findEmployee(java.lang.Integer)
	 */
	@Override
	public Employee findEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#addEmployee(com.latewind.domain.Employee)
	 */
	@Override
	public void addEmployee(Employee e) {
//		employeeDAO.persist(e);
		employeeDAO.attachDirty(e);
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#findDepartment(java.lang.Integer)
	 */
	@Override
	public void updateEmployee(Employee e){
		
		employeeDAO.merge(e);
	}
	public Department findDepartment(Integer id) {
		// TODO Auto-generated method stub
		return departmentDAO.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#findDeparmentByName(java.lang.String)
	 */
	@Override
	public Department findDeparmentByName(String name) {
		// TODO Auto-generated method stub
		return departmentDAO.findByName(name);
	}
	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#findPosition(java.lang.Integer)
	 */
	@Override
	public Position findPosition(Integer id) {
		// TODO Auto-generated method stub
		return positionDAO.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#listAllDepartment()
	 */
	@Override
	public List<Department> listAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDAO.listAll();
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#listAllPosition()
	 */
	@Override
	public List<Position> listAllPosition() {
		// TODO Auto-generated method stub
		return positionDAO.listAll();
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#listAllEmployee()
	 */
	@Override
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.listAll();
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public PositionDAO getPositionDAO() {
		return positionDAO;
	}

	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	/**
	 * @return the userInfoDAO
	 */
	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	/**
	 * @param userInfoDAO the userInfoDAO to set
	 */
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.HRService#addAccount(com.latewind.bean.UserInfo, java.lang.Integer)
	 */
	@Override
	public String addAccount(UserInfo u, Integer id) {
		
		Employee e=employeeDAO.findById(id);
		if(e==null){
		log.info("没用根据ID找到指定的员工");
		return "没用根据ID找到指定的员工";	
		}
		else if(e.getUserInfo()!=null){
			log.info("此员工已经拥有账号");
			return "此员工已经拥有账号";
		}
		else {
			
			if(userInfoDAO.findUser(u.getUserName())!=null){
				log.info("用户名重复");
				return "用户名重复";
			}else{
			//账号与员工建立关联
			u.setEmployee(e);
			u.setChnName(e.getName());
			userInfoDAO.save(u);
			e.setUserInfo(u);
			employeeDAO.attachDirty(e);
			return "申请成功";
			
			}
			
		}
		// TODO Auto-generated method stub
		
	}

	
	

}
