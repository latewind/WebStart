package com.latewind.service.category;

import java.util.List;
import java.util.Map;

import com.latewind.pojo.ThirdCategory;

public interface ICategoryManService {
	Map getProduct123Category(Integer prtId);	
	/**
	 * 根据 一级分类 得出所属的三级分类
	 * @param topId
	 * @return
	 */
	public List<ThirdCategory> getThirdByTop( Integer topId);
}
