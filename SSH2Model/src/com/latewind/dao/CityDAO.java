package com.latewind.dao;

import java.util.List;

import com.latewind.bean.City;

public interface CityDAO {
	
	public void queryById(int id);
	public List<City> listAll();

}
