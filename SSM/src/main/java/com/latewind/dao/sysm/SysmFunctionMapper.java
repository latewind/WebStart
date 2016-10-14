package com.latewind.dao.sysm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.sysm.SysmFunction;

public interface SysmFunctionMapper {
	int deleteByPrimaryKey(Integer functionId);

	int insert(SysmFunction record);

	int insertSelective(SysmFunction record);

	SysmFunction selectByPrimaryKey(Integer functionId);
	
	SysmFunction selectFunctionByName(String funcName);
	
	
	

	Integer selectRoleFunctionCount(@Param("actionUrl") String actionUrl, @Param("roleId") Integer roleId);
	/**
	 * 根据 Role Name or Id  选出 FUnction 
	 * @param roleId
	 * @param roleName
	 * @return
	 */
	List <SysmFunction> selectRoleFuncByRole(@Param("roleId") Integer roleId,@Param("roleName")String roleName);

	List<SysmFunction> selectAllFunction();

	int updateByPrimaryKeySelective(SysmFunction record);

	int updateByPrimaryKey(SysmFunction record);
}