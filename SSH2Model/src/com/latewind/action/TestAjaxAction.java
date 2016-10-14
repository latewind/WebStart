package com.latewind.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.latewind.bean.Orders;
import com.latewind.bean.UserInfo;
import com.latewind.domain.Materials;
import com.latewind.service.MaterialsService;
import com.latewind.service.OrdersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAjaxAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> sendData = new HashMap<String, String>();
	private Map<String,HashMap<String,String>> tbData=new HashMap<String,HashMap<String,String>>();
	private OrdersService ordersService;
	private MaterialsService materialsService;

	public OrdersService getOrdersService() {
		return ordersService;
	}



	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}




	@Override
	//aJax 更新订单的一行
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(sendData.size()+"json");
	
		ordersService.updateFormTr(sendData);
		
//		System.out.println("length of dString"+dStrings.length);
		//	ordersService.updateOrders(o);
		//ordersService.updateFromTable(dStrings)
	
	//ordersService.updateFromTable(dStrings);
//		System.out.println(result.get(0));
//		System.out.println(result.get(1));
//		result.add("success1");
//		result.add("success2");
//		result.add("success3");
//		System.out.println("TestAjaxAction");
//		System.out.println(result.size()+"result size");
		return SUCCESS;
	}
	//多行 materials
	public String rowsJson(){
		
		System.out.println(tbData.get("0").get("0"));//多选表格
		System.out.println("多行上传0 , 0");
		List<Materials> mlist=new LinkedList<>();
		Integer mapSize=tbData.size();
		for(Integer i=0;i<mapSize;i++){
			Map m=tbData.get(String.valueOf(i));
			Materials materials=new Materials();
			materials.setName((String)m.get("0"));
			System.out.println(m.get("0")+"get 0");
			materials.setModel((String)m.get("1"));
			materials.setNum(Integer.valueOf((String) m.get("2")));
			materials.setUnit((String)m.get("3"));
			materials.setPrince((String)m.get("4"));
			materials.setTotalprice(Integer.valueOf((String) m.get("5")));
			materials.setSort((String)m.get("6"));
			materials.setRemark((String)m.get("7"));
			materials.setStatus("审批中");
			
			Map<String , Object>session= ActionContext.getContext().getSession();
			UserInfo uInfo=(UserInfo) session.get("userInfo");
			System.out.println("物资申请人ID=" +uInfo.getId());
			//设置申请人id
			materials.setApplicantId(uInfo.getId());
			materials.setUserinfoId(uInfo.getId());
			mlist.add(materials);			
		}
		materialsService.addMaterials(mlist);
		
		
		return SUCCESS;
	}
	
	//同意
	public String agree(){
		List idList=new ArrayList<Integer>();
		Integer mapSize=tbData.size();
		for(Integer i=0;i<mapSize;i++){			
			Map m=tbData.get(String.valueOf(i));
			String idString=(String) m.get("1");
			System.out.println(idString+"同意订单ID");//get
			idList.add(Integer.valueOf(idString));//通关的订单的id号放入List中
		}
		
		materialsService.agreed2Approve(idList);
		
		return SUCCESS;
	}
	//撤回
	public String revoke(){
		
		Integer mapSize=tbData.size();
		for(Integer i=0;i<mapSize;i++){
			
			Map m=tbData.get(String.valueOf(i));
			System.out.println(m.get("1")+"撤销订单ID");//get
			/*
			 * 这里添加撤销代码 根据ID值
			 * 
			 */
		}
		return SUCCESS;
	}


	public Map<String, String> getSendData() {
		return sendData;
	}

	public void setSendData(Map<String, String> sendData) {
		this.sendData = sendData;
	}



	/**
	 * @return the tbData
	 */
	public Map<String,HashMap<String,String>> getTbData() {
		return tbData;
	}



	/**
	 * @param tbData the tbData to set
	 */
	public void setTbData(Map<String,HashMap<String,String>> tbData) {
		this.tbData = tbData;
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



	/**
	 * @return the tbData
	 */


	/**
	 * @return the sendData
	 */

}
