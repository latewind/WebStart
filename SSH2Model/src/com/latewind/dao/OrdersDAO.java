package com.latewind.dao;

import java.util.Date;
import java.util.List;

import com.latewind.bean.Orders;

public interface OrdersDAO {
	public boolean addOrders(Orders o);
	public Orders queryOrders(int i);
	public List queryByOrderDate(Date date);
	public List listOrders();
	public void updateOrders(Orders o);
	

}
