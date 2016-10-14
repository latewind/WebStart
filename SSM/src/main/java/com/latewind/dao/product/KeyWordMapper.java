package com.latewind.dao.product;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.product.KeyWord;

public interface KeyWordMapper {
	Set<Integer> selectByKeyWord(@Param("keywordSet")Set<String> keywordSet);
	
    int insert(KeyWord record);

    int insertSelective(KeyWord record);
}