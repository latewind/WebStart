package com.latewind.service;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;

import com.latewind.bean.City;
import com.latewind.dao.CityDAO;




public class CityServiceImpl implements CityService {
	private CityDAO cityDAO;
	
	
	 public CityServiceImpl() {
	System.out.println("City Service construtor");
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<City> listAll() {
	
		System.out.println("list all in service");
		// TODO Auto-generated method stub
		return cityDAO.listAll();
		
	}

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

}
