package com.latewind.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.latewind.bean.City;

public class CityDAOImpl  extends HibernateDaoSupport implements CityDAO {

	@Override
	public void queryById(int id) {
		// TODO Auto-generated method stub
		List list= this.getHibernateTemplate().find("select city from City city where city.id = '" + id + "'");
		if(list.size()>0){
		City c=(City) list.get(0);
		System.out.println("query"+c.getName());
		}
		
	}

	@Override
	public List<City> listAll() {
		// TODO Auto-generated method stub
		List list=this.getHibernateTemplate().find("from City");
		return list;
	}

}
