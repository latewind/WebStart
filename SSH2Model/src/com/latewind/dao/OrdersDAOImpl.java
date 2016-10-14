package com.latewind.dao;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.latewind.bean.Orders;


public class OrdersDAOImpl extends HibernateDaoSupport implements OrdersDAO{

	/**
	 * 
	 */
	public OrdersDAOImpl() {
	System.out.println("Orders IMPL");
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean addOrders(Orders o) {
		// TODO Auto-generated method stub
		System.out.println("addOrdes");
		this.getHibernateTemplate().save(o);
		return true;
	}
	public void updateOrders(Orders o){
		this.getHibernateTemplate().update(o);
			
		
	}
	public Orders queryOrders(int id) {
		System.out.println("list addOrdes by id");
		List list=this.getHibernateTemplate().find("select orders from Orders orders where orders.id= '" + id+ "'" );
		
		
		
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Orders.class, id);
	}
	public List queryByOrderDate(Date date){
		
//		DateFormat dfDateFormat=new DateFormat("");
		
		System.out.println("list addOrdes by id");
//		this.getSessionFactory().
		Session session=this.getSessionFactory().openSession();
		List list= session.createQuery("from Orders as orders where orders.orderdate = ?").setDate(0, date).list();
//		 List list=this.getHibernateTemplate().find("select orders from Orders orders where orders.orderDate= '" + df+ "'" );
		session.close();
		return  list;
		
		
	}

	@Override
	public List listOrders() {
		List list=this.getHibernateTemplate().find("from Orders");
		System.out.println(list.size()+"order list size");
		// TODO Auto-generated method stub
		return list;
	}

}
