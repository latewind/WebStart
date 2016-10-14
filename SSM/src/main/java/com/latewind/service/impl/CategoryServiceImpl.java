package com.latewind.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.CategoryMapper;
import com.latewind.pojo.Category;
import com.latewind.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	@Resource
	private CategoryMapper categoryDAO;
	
	@Override
	public List<Category> getAllCategory() {
				return categoryDAO.getAll();
	}

	@Override
	public Category getCategoryById(Integer id) {
				return categoryDAO.selectByPrimaryKey(id);
	}

}
