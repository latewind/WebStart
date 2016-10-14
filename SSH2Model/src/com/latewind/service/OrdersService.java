/**
 * 
 */
package com.latewind.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.latewind.bean.Orders;

/**
 * @author jhon
 *
 */
public interface OrdersService {
	public Orders findOrders(int id);
	public void addOrders(Orders orders);
	public void updateOrders(Orders o);
	public List findAll();
	public List findByOrderDate(Date date);
	public void updateFormTr(Map<String, String> sendData);
	public void updateFromTable(String[] dStrings);
}
