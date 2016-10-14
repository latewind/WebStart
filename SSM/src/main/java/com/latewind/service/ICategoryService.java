package com.latewind.service;

import java.util.List;

import com.latewind.pojo.Category;

public interface ICategoryService {
	public List<Category> getAllCategory();
	
	public Category getCategoryById(Integer id);
}
