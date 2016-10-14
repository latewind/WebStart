package com.latewind.dao.category;

import java.util.List;

import com.latewind.pojo.ThirdCategory;

public interface ThirdCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThirdCategory record);

    int insertSelective(ThirdCategory record);

    ThirdCategory selectByPrimaryKey(Integer id);
    
    ThirdCategory selectByThirdName(String thirdName);

    int updateByPrimaryKeySelective(ThirdCategory record);

    int updateByPrimaryKey(ThirdCategory record);
    
    List<ThirdCategory> selectAllThird();
    
}