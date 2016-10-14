package com.latewind.service.impl.category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.category.TopCategoryMapper;
import com.latewind.pojo.TopCategory;
import com.latewind.service.category.ITopCategoryService;

@Service("topCategoryService")
public class TopCategoryServiceImpl implements ITopCategoryService {

@Resource
private TopCategoryMapper topCategoryDAO;
	@Override
	public TopCategory geTopCategoryById(Integer id) {
				return topCategoryDAO.selectByPrimaryKey(id);
	}
	@Override
	public List<TopCategory> getAllTop() {
				return topCategoryDAO.selectAllTop();
	}
	@Override
	public LinkedHashMap getAllTopMap() {
		
		LinkedHashMap<Integer, List> retMap=new LinkedHashMap<>();
		//获取所有一级分类
		List<TopCategory> allList=this.getAllTop();
		//获取一级分类数量
		Integer length=allList.size();
		//将 [index:List<SubCategory>] 放入Map中
		for(Integer i=0;i<length;i++){
			
			retMap.put(i+1, allList.get(i).getSubCategories());
		}
		
				return retMap;
	}

}
