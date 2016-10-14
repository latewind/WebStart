/**
 * 
 */
package com.latewind.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.latewind.bean.Orders;
import com.latewind.dao.OrdersDAO;

/**
 * @author jhon
 *
 */

public class OrdersServiceImpl implements OrdersService {

	private OrdersDAO ordersDAO;
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}

	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#addOrders(com.latewind.bean.Orders)
	 */
	@Override
	public void addOrders(Orders orders) {
		// TODO Auto-generated method stub
		ordersDAO.addOrders(orders);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#updateOrders(com.latewind.bean.Orders)
	 */
	@Override
	public void updateOrders(Orders o) {
		// TODO Auto-generated method stub
		ordersDAO.updateOrders(o);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#findOrders(int)
	 */
	@Override
	public Orders findOrders(int id) {
		// TODO Auto-generated method stub
		
		
		
		return ordersDAO.queryOrders(id);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#findAll()
	 */
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return ordersDAO.listOrders();
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#updateFromTable(java.lang.String)
	 */
	public void updateFromTable(String[] dString) {
		System.out.println("updateFromTable");
		int id=Integer.valueOf(dString[0]).intValue();//将id转换成int型的
		System.out.println(id);
		Orders o=findOrders(id);
		System.out.println(dString[9]);
		String str=dString[9].replaceAll("\\s*", "");
		int count=Integer.valueOf(str).intValue();
		System.out.println(count+"tranform");
		o.setProduce(count);
		updateOrders(o);
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#findByOrderDate(java.util.Date)
	 */
	@Override
	
	public List findByOrderDate(Date date) {
		// TODO Auto-generated method stub
		return ordersDAO.queryByOrderDate(date);
	}

	/* (non-Javadoc)
	 * @see com.latewind.service.OrdersService#updateFormTr(java.util.Map)
	 */
	public void updateFormTr(Map<String, String> sendData) {
		
		int id=Integer.valueOf(sendData.get("0")).intValue();//获取ID
		Orders o=this.findOrders(id);
		//更改已生产数
		int produce =Integer.valueOf(sendData.get("9")).intValue();
		o.setProduce(produce);	
		//更改备注
		String remark=sendData.get("14");
		o.setRemarks(remark);
		
		this.updateOrders(o);
		
		// TODO Auto-generated method stub
		
	}



}
