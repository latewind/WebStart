/**
 * 
 */
package com.latewind.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.latewind.bean.UserInfo;
import com.latewind.dao.UserInfoDAO;
import com.latewind.domain.Department;
import com.latewind.domain.Employee;
import com.latewind.domain.EmployeeDAO;
import com.latewind.domain.Materials;
import com.latewind.domain.MaterialsDAO;
import com.latewind.domain.Position;
import com.latewind.domain.Processes;
import com.latewind.domain.ProcessesDAO;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Administrator
 *
 */
public class MaterialsServiceImpl implements MaterialsService {

	private  ProcessesDAO processesDAO;
	private MaterialsDAO materialsDAO;
	private EmployeeDAO employeeDAO;
	private UserInfoDAO userInfoDAO;
	
	/* (non-Javadoc)
	 * @see com.latewind.service.MaterialsService#addMaterials()
	 */
	@Override
	
	public List<Materials> approveMaterials(UserInfo u) {
		
		
		return materialsDAO.findByUserId(u.getId());
	}
	public void agreed2Approve(List<Integer> ids){
		
		/**
		 * 1、根据userInfo 找到审批账号
		 * 2、根据账号找出employee 
		 * 3、根据employee 找出职位
		 * 4、找出上级
		 * 5、找出部门最高领导
		 * 6、设置下一步的审批人
		 */
		Map<String , Object>session= ActionContext.getContext().getSession();//1
		UserInfo uInfo=(UserInfo) session.get("userInfo");
		
		Employee e=uInfo.getEmployee();//2
		Position p=e.getPosition();//3
		Position leaderP=p.getDepartment().getLeader();//部门首领导
		
		if(p.getPositionId().equals(leaderP.getPositionId())){//审批人就是部门首要领导
			for(Integer i:ids){
				
				Materials ms=materialsDAO.findById(i);
				String pString=ms.getProcessesInfo();
				pString=pString+ms.getUserinfoId()+" "+"同意"+",";//设置进度信息
				ms.setProcessesInfo(pString);
				
				ms.setStatus("审批通过");
				ms.setUserinfoId(10);//这里应该设置到采购人员信息 10为采购
				materialsDAO.attachDirty(ms);
			}
			
		}else{
		
		Employee es[] = new Employee[2];
		p.getSuperior().getEmployees().toArray(es);
		Integer userId=es[0].getUserInfo().getId();
		System.out.println("上级领导userInfo id="+userId);
		for(Integer i:ids){
			
			Materials ms=materialsDAO.findById(i);
			String pString=ms.getProcessesInfo();
			pString=pString+ms.getUserinfoId()+" "+"同意"+",";//设置进度信息
			ms.setProcessesInfo(pString);
			ms.setUserinfoId(userId);
			materialsDAO.attachDirty(ms);
		}
		}
		
	}
	
	public void disagree(List<Integer> ids){
		for(Integer i:ids){
			
			Materials ms=materialsDAO.findById(i);
			materialsDAO.delete(ms);//不通过就是删除
			/**
			 * 添加消息提醒
			 * 
			 */
		}
		
		
	}
	public void addMaterials(List<Materials> list) {	
		for(Materials m:list){	
			int userId=m.getUserinfoId();//申请人ID
			
			UserInfo u=userInfoDAO.findUserById(userId);//申请人
		Iterator<Employee>	ie=u.getEmployee().
							getPosition().
								getSuperior().
									getEmployees().
											iterator();
		int supId = 0;	
		while(ie.hasNext()){
				supId=ie.next().getUserInfo().getId();
				System.out.println("下一个上级的userInfo ID"+supId);
			}
		m.setProcessesInfo(userId+" "+"提交"+",");
		m.setUserinfoId(supId);//设置上级账号ID
		materialsDAO.attachDirty(m);
		
		}
		//
		// TODO Auto-generated method stub
		
	}
	public ProcessesDAO getProcessesDAO() {
		return processesDAO;
	}
	public void setProcessesDAO(ProcessesDAO processesDAO) {
		this.processesDAO = processesDAO;
	}
	public MaterialsDAO getMaterialsDAO() {
		return materialsDAO;
	}
	public void setMaterialsDAO(MaterialsDAO materialsDAO) {
		this.materialsDAO = materialsDAO;
	}
	/**
	 * @return the employeeDAO
	 */
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	/**
	 * @param employeeDAO the employeeDAO to set
	 */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
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


}
