/**
 * 
 */
package com.latewind.action;

import java.util.List;
import java.util.Map;

import com.latewind.bean.Orders;
import com.latewind.bean.UserInfo;
import com.latewind.domain.Materials;
import com.latewind.service.MaterialsService;
import com.latewind.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class MaterialsAction extends ActionSupport {
	
	private UserInfoService userInfoService;
	private MaterialsService materialsService;
	
//	所有订单列表
	private List<Materials> materials;
	
	public String  approveMaterials(){
		//这里添加审批物资，从Process中查询到的处于审批过程中的。
		 //返回 materials
		System.out.println("审批物资Action");
		Map<String , Object>session= ActionContext.getContext().getSession();
		UserInfo userInfo=(UserInfo) session.get("userInfo");
		materials=materialsService.approveMaterials(userInfo);
		return SUCCESS;
		
	}
	/**
	 * @return the materials
	 */
	public List<Materials> getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(List<Materials> materials) {
		this.materials = materials;
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
	 * @return the materialsService
	 */
	public MaterialsService getMaterialsService() {
		return materialsService;
	}
	/**
	 * @param materialsService the materialsService to set
	 */
	public void setMaterialsService(MaterialsService materialsService) {
		this.materialsService = materialsService;
	}

}
