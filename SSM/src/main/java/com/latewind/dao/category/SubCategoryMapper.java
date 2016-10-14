package com.latewind.dao.category;

import java.util.List;

import com.latewind.pojo.SubCategory;

public interface SubCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubCategory record);

    int insertSelective(SubCategory record);

    SubCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubCategory record);

    int updateByPrimaryKey(SubCategory record);
    
    List<SubCategory> selectAllSub();
}