package com.latewind.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.product.PrtComment;

public interface PrtCommentMapper {

	int deleteByPrimaryKey(Integer commentId);

	int insert(PrtComment record);

	int insertSelective(PrtComment record);

	List<PrtComment> selectByPrtId(@Param("prtId") Integer prtId, @Param("startPos") Integer startPos,

			@Param("step") Integer step);

	Integer selectCountByPrtId(Integer prtId);

	PrtComment selectByPrimaryKey(Integer commentId);

	int updateByPrimaryKeySelective(PrtComment record);

	int updateByPrimaryKey(PrtComment record);
}