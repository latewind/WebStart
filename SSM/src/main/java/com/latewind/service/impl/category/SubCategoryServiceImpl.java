package com.latewind.service.impl.category;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.category.SubCategoryMapper;
import com.latewind.pojo.Category;
import com.latewind.pojo.SubCategory;
import com.latewind.service.ICategoryService;
import com.latewind.service.category.ISubCategoryService;
@Service("subCategoryService")
public class SubCategoryServiceImpl implements ISubCategoryService {
@Resource
private SubCategoryMapper subCategoryDAO;

@Override
public SubCategory getSubCategoryById(Integer id) {
		return subCategoryDAO.selectByPrimaryKey(id);
}

@Override
public List<SubCategory> getAllSub() {
		return subCategoryDAO.selectAllSub();
}



}
