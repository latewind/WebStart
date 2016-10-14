package com.latewind.service.category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.latewind.pojo.TopCategory;

public interface ITopCategoryService {
	public TopCategory geTopCategoryById(Integer id);
	
	public List<TopCategory> getAllTop();
	
	public LinkedHashMap getAllTopMap();
}
