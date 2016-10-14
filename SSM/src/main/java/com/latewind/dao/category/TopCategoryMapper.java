package com.latewind.dao.category;

import java.util.List;

import com.latewind.pojo.TopCategory;

public interface TopCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopCategory record);

    int insertSelective(TopCategory record);

    TopCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopCategory record);

    int updateByPrimaryKey(TopCategory record);
    
    List<TopCategory> selectAllTop();
    /**
     * 根据 topId 找出所有 所属的 二级/三级分类
     * @param topId
     * @return
     */
   TopCategory selectThirdByTopId(Integer topId);
}