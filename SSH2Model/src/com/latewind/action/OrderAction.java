/**
 * 
 */
package com.latewind.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.latewind.bean.Orders;
import com.latewind.bean.UserInfo;
import com.latewind.common.ConstantValue;
import com.latewind.service.OrdersService;
import com.latewind.service.UserInfoService;
import com.latewind.tools.IdentifyCode;
import com.latewind.tools.OfficeConvert;
import com.latewind.tools.TypeTransform;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author jhon
 *
 */
public class OrderAction extends ActionSupport {
	
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
	private byte[] figure;
	
//	接受文件
	private File file;
	private String fileFileName;//固定写法
	private String fileContentType;
	private UserInfoService userInfoService;          
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	private OrdersService ordersService;
//	所有订单列表
	private List<Orders> orderses;
// 图片id	
	private String fid;
//文件输入流
	private ByteArrayInputStream iStream;
	private String randomCode;
	public ByteArrayInputStream getiStream() {
		return iStream;
	}
	public void setiStream(ByteArrayInputStream iStream) {
		this.iStream = iStream;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public OrdersService getOrdersService() {
		return ordersService;
	}
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String addOrders() {//增加订单
		/*
		System.out.println("remarks");	
		figure=TypeTransform.FileToByte(file.getAbsolutePath());		
		Orders orders=new Orders();
		orders.setAlloystate(alloyState);
		orders.setCustomer(customer);
		orders.setDeliverydate(deliveryDate);
		orders.setFigure(figure);
		orders.setFigureno(figureNo.toUpperCase());
		orders.setLength(length);
		orders.setModel(model);
		orders.setMould(mould);
		orders.setNo(no);
		orders.setOrderdate(new Date());
		orders.setOrderno(orderNo.toUpperCase());
		orders.setPlancount(planCount);
		orders.setRemarks(remarks);
		orders.setWeight(weight);		
		String chn=(String) ActionContext.getContext().getSession().get("userCHNName");
		System.out.println(" chn is "+chn);
		System.out.println(userInfoService.isRight("admin", "admin"));
		UserInfo u=userInfoService.findUser(chn);
		System.out.println(u.getId());
		orders.setUserinfo(u);
		ordersService.addOrders(orders);
		System.out.println("add Order");
		ordersService.updateOrders(orders);
		*/
		return "addOrders";
	}
	public String listOrders(){
		//查询所有数据
		System.out.println("list");
		orderses=ordersService.findAll();
		
		return "listOrders";
		
		
		
	}
	public String listPlans(){
		//查询所有数据
		System.out.println("list");
		orderses=ordersService.findAll();
		
		
		return "listPlans";		
		
	}
	public String tdOrders(){
		
		ActionContext.getContext().getSession().put("fid", fid);
		System.out.println(fid);
		
		return "TdOrders";
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
	/**
	 * @return the orderses
	 */
	public List<Orders> getOrderses() {
		return orderses;
	}
	/**
	 * @param orderses the orderses to set
	 */
	public void setOrderses(List<Orders> orderses) {
		this.orderses = orderses;
	}



	

}
