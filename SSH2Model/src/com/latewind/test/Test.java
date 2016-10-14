package com.latewind.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.latewind.bean.Notice;
import com.latewind.bean.Orders;
import com.latewind.bean.UserInfo;
import com.latewind.dao.OrdersDAO;
import com.latewind.dao.UserInfoDAO;
import com.latewind.domain.Department;
import com.latewind.domain.DepartmentDAO;
import com.latewind.domain.Employee;
import com.latewind.domain.Msg;
import com.latewind.domain.MsgDAO;
import com.latewind.domain.Position;
import com.latewind.service.*;

import com.latewind.tools.IdentifyCode;
import com.latewind.tools.MD5Util;
import com.latewind.tools.TypeTransform;

public class Test {
	private OrdersDAO ordersDAO;
	private UserInfoDAO userInfoDAO;
	private UserInfoService userInfoService;
	private OrdersService ordersService;
	private NoticeService noticeService;
	private HRService  hrService;
	private MsgService msgService;
	
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public Test(){
		
		System.out.println(" Test  Construts");
		
	}
	public void show(){
		
		IdentifyCode ic=new IdentifyCode();
		
		Vector<Object> vector=ic.CreateImage("n");
		String  random=(String) vector.get(0);
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("identifyCOde", random);
		ByteArrayInputStream imageStream = (ByteArrayInputStream) vector.get(1);
		System.out.println(random);
		try {
			FileOutputStream fo=new FileOutputStream(new File("D:\\test.jpg"));
			
			  int bytesRead = 0;
			   byte[] buffer = new byte[8192];
			   while ((bytesRead = imageStream.read(buffer, 0, 8192)) != -1) {
			    fo.write(buffer, 0, bytesRead);
			   }
			   fo.close();
			   imageStream.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		System.out.print("show");
	}
	
	public void testOrders(){
		if(ordersDAO==null){
		System.out.println(" 1324");}
		Orders list=ordersDAO.queryOrders(1);
		if(list==null){
			System.out.println("no have");
		}
		else {
			Orders o=list;
			System.out.println(o.getCustomer());
			o.setCustomer("���԰�");
			ordersService.updateOrders(o);
		}
		
		
		
		
	}
	public void testUserInfo(){
		
		//System.out.println(userInfoService.isRight("admin", "admin"));
		
		UserInfo u=new UserInfo();
		u.setChnName("����");
		u.setOpLimit("10111");
		u.setPassword("seller");
		u.setProfession("����");
		u.setUserName("seller");
//		u.setOrderses(null);
		userInfoService.addUser(u);
		
	}
	public void testOrdersService() {
		
		Orders orders=new Orders();
		orders.setAlloystate("6082-T6");
		orders.setCustomer("DONGCHANG");
		orders.setDeliverydate(new Date(2016, 4, 1));
		orders.setFigureno("T-Z-001");
		orders.setLength(2000);
		orders.setModel("MU-001");
		orders.setMould("MOULD-001");
		orders.setNo(1);
		orders.setOrderdate(new java.util.Date());
		orders.setOrderno("XMLY-ORDERNO-001");
		orders.setPlancount(200);
		orders.setRemarks("weight");
		orders.setWeight(500.14);
		orders.setUserinfo(userInfoDAO.findUser("plan"));
		orders.setFigure(TypeTransform.FileToByte("D:/t1.jpg"));
		this.getOrdersService().addOrders(orders);			
		
	}
	
	
	public void testNotice(){
		List<Notice> list=noticeService.queryAll();
		for(Notice n:list){
			System.out.println(n.getTitle());
		}
		
	}
	/*
	public void testDeartment(){
		
		Department d=departmentHome.findById(1);
		Position leader=d.getLeader();
		Set<Position> positions=d.getPositions();
		System.out.println("Department function:"+d.getFunc()+"leader position name"+leader.getName());
		
		Set<Position> inferiors=leader.getPositions();
		for(Position pin:inferiors){
			
			System.out.println("inferior:"+pin.getName());
			Set<Position> ps=pin.getPositions();
			if(ps.size()>0){
				
				for(Position p:ps)
				System.out.println("    "+p.getName());
				
			}
			
			
		}
		
		for(Position p:positions){
			
			System.out.println("position name:"+p.getName());
			Set<Employee> es=p.getEmployees();
			for(Employee e:es){
				System.out.println("     employee name"+e.getName());
				
			}
		}
		
		
	}
	*/
	///////////////////////////////////////////////////////////////////
	
	public void testHRService(){
		
		Employee e=hrService.findEmployee(3);
		System.out.println(e.getUserInfo().getUserName());
		Department d=hrService.findDeparmentByName("���۲�");
		System.out.println(d.getFunc());
		
		
	}
	
	public void testMsg(){
		
//		Msg msg=msgDAO.findById(1);
		Msg msg=msgService.findMsgById(1);
		UserInfo sender=msg.getSender();
		System.out.println("������"+sender.getUserName()+msg.getContent());
		Set s=msg.getReceivers();
		Iterator<UserInfo> i=s.iterator();
		while(i.hasNext()){
			
			System.out.println("������"+i.next().getUserName());
		}
		//������Ϣ
		Msg m=new Msg();
		
		////		m.setId(6);
		m.setContent("ȫ�������յ���Ϣ��Ϣ");		
		m.setSender(sender);
//		Set<UserInfo> us=new HashSet<>(0);
//		us.add(userInfoService.findUserById(5));
//		us.add(userInfoService.findUserById(6));
//		
//		m.setReceivers(us);
//		msgService.saveOrUpdateMsg(m);
////		msgService.saveMsg(m);
//		
//		msgService.merge(m);
		msgService.sendMsg2All(m);

		
	}
	public void receiveMsg(){
		
		UserInfo u=userInfoDAO.findUserById(1);
		Set mset=u.getReceptMsgs();
		Iterator<Msg> i=mset.iterator();
		while (i.hasNext()){
			
			System.out.println(i.next().getContent());
		}
	}
	
	/**
	 * test the config
	 * @param args
	 */
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Test obj = (Test) context.getBean("test");
//			obj.testOrders();
//		obj.testHRService();	
//		String  md5=MD5Util.MD5("123456");
//		System.out.println(md5+" "+md5.length());
		
//obj.testMsg();	
		obj.receiveMsg();
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
	/**
	 * @return the ordersService
	 */
	public OrdersService getOrdersService() {
		return ordersService;
	}
	/**
	 * @param ordersService the ordersService to set
	 */
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	/**
	 * @return the departmentHome
	 */
	/**
	 * @return the hrService
	 */
	public HRService getHrService() {
		return hrService;
	}
	/**
	 * @param hrService the hrService to set
	 */
	public void setHrService(HRService hrService) {
		this.hrService = hrService;
	}

	/**
	 * @return the msgService
	 */
	public MsgService getMsgService() {
		return msgService;
	}
	/**
	 * @param msgService the msgService to set
	 */
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}

}
