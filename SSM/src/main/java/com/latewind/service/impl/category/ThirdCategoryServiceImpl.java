package com.latewind.service.impl.category;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.category.ThirdCategoryMapper;
import com.latewind.pojo.ThirdCategory;
import com.latewind.service.category.IThirdCategoryService;


@Service("thirdCategoryService")
public class ThirdCategoryServiceImpl implements IThirdCategoryService {

	@Resource
	private ThirdCategoryMapper thirdCategoryDAO;
	@Override
	public ThirdCategory geThirdCategoryById(Integer id) {
				return thirdCategoryDAO.selectByPrimaryKey(id);
	}
	@Override
	public List<ThirdCategory> getAllThird() {
				return thirdCategoryDAO.selectAllThird();
	}

}
