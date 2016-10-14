package com.latewind.dao.web;

import java.util.List;

import com.latewind.pojo.web.NavTabs;

public interface NavTabsMapper {
    int deleteByPrimaryKey(Integer navId);

    int insert(NavTabs record);

    int insertSelective(NavTabs record);

    NavTabs selectByPrimaryKey(Integer navId);

    int updateByPrimaryKeySelective(NavTabs record);

    int updateByPrimaryKey(NavTabs record);
    
    List<NavTabs> selectAllNavtabs();
}