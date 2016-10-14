/**
 * 
 */
package com.latewind.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.apache.log4j.Logger;

import com.latewind.bean.Orders;
import com.latewind.bean.UserInfo;
import com.latewind.service.OrdersService;
import com.latewind.service.UserInfoService;
import com.latewind.tools.TypeTransform;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 增加订单FormAction
 *
 */
public class AddOrdersAction extends ActionSupport {
	

	//订单各参数
	private int id;
	private UserInfo userinfo;
	private String orderNo;
	private int no;
	private String customer;
	private String figureNo;
	private String mould;
	private String model;
	private int length;
	private int planCount;
	private double weight;
	private String alloyState;
	private Date deliveryDate;
	private Date orderDate;
	private String remarks;
	
	//	接受文件
	private File file;
	private String fileFileName;//固定写法
	private String fileContentType;
	private UserInfoService userInfoService; 
	static Logger logger=Logger.getLogger(AddOrdersAction.class);
	//订单服务层
	private OrdersService ordersService;
	
	//今日订单list
	private List listdate;
	
	public  List getListdate() {
		return listdate;
	}

	public  void setListdate(List listdate) {
		this.listdate = listdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getFigureNo() {
		return figureNo;
	}

	public void setFigureNo(String figureNo) {
		this.figureNo = figureNo;
	}

	public String getMould() {
		return mould;
	}

	public void setMould(String mould) {
		this.mould = mould;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPlanCount() {
		return planCount;
	}

	public void setPlanCount(int planCount) {
		this.planCount = planCount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getAlloyState() {
		return alloyState;
	}

	public void setAlloyState(String alloyState) {
		this.alloyState = alloyState;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public byte[] getFigure() {
		return figure;
	}

	public void setFigure(byte[] figure) {
		this.figure = figure;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	private byte[] figure;
	
	

	
	public String execute(){
		//
		System.out.println("AddOrdersAction");
		System.out.println("remarks");	
		
		if(this.file!=null){
		figure=TypeTransform.FileToByte(file.getAbsolutePath());		
		Orders orders=new Orders();
		orders.setAlloystate(alloyState);
		orders.setCustomer(customer);
		orders.setDeliverydate(deliveryDate);
		orders.setFigure(figure);
		orders.setFigureno(figureNo);
		orders.setLength(length);
		orders.setModel(model);
		orders.setMould(mould);
		orders.setNo(no);
		orders.setOrderdate(new Date());
		orders.setOrderno(orderNo);
		orders.setPlancount(planCount);
		orders.setRemarks(remarks);
		orders.setWeight(weight);
		//从session获取UserInfo
		UserInfo u=(UserInfo) ActionContext.getContext().getSession().get("userInfo");
		orders.setUserinfo(u);
		ordersService.addOrders(orders);
	    if(logger.isInfoEnabled()){
			  
			  logger.info("新增订单----来自"+u.getId()+u.getChnName());
		  }
		}
		listdate=ordersService.findByOrderDate(new Date());
		for(Object o:listdate){
			System.out.println("今日新增订单："+((Orders) o).getOrderno()+"下单人："+((Orders) o).getUserinfo().getChnName());		
		}
		
		
		return SUCCESS;
	}

}
