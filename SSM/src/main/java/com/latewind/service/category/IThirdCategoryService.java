package com.latewind.service.category;

import java.util.List;

import com.latewind.pojo.ThirdCategory;

public interface IThirdCategoryService {
	public ThirdCategory geThirdCategoryById(Integer id);
	
	public List<ThirdCategory> getAllThird();

}
