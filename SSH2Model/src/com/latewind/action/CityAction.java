package com.latewind.action;

import java.util.List;

import com.latewind.bean.City;
import com.latewind.service.CityService;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport {
private CityService cityService;
private List<City> cities;

public CityService getCityService() {
	return cityService;
}

public void setCityService(CityService cityService) {
	this.cityService = cityService;
}

public List<City> getCities() {
	return cities;
}

public void setCities(List<City> cities) {
	this.cities = cities;
}

public String showCity1(){
	cities=cityService.listAll();
	System.out.println(" in City ac show city"+cities.size());
	return "success";
}
public String execute(){
	cities=cityService.listAll();
	System.out.println(" in City ac exe"+cities.size());
	return SUCCESS;
}

public String showCity2(){
	cities=cityService.listAll();
	System.out.println(" in City ac show city"+cities.size());
	return "success";
}
	
}
