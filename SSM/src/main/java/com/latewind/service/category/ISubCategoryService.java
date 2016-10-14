package com.latewind.service.category;

import java.util.List;

import com.latewind.pojo.SubCategory;

public interface ISubCategoryService {
	public SubCategory getSubCategoryById(Integer id);
	public List<SubCategory> getAllSub();
}
