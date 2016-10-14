package com.latewind.service.sysm;

import java.util.List;

import com.latewind.pojo.admin.user.SysmLoginInfo;
import com.latewind.pojo.sysm.*;

public interface ISystemManService {

	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	/*================================角色=====================================*/
	List<SysmRole> listAllRole();

	SysmRole getRoleByName(String roleName);
	
	String createNewRole(String roleName);
	
	Integer addRoleFunction(List<Integer> list,Integer roleId);

	
	/*==================================权限===================================*/
	List<SysmFunction> listAllFunction();
	
	List<SysmFunction> listFunctionByRole(Integer roleId,String roleName);
	
	SysmFunction getFuncionByName(String funcName);
	
	SysmFunction getFunctionById(Integer id);
	
	Boolean hasFunction(String actionUrl,Integer roleId) ;
	
	Integer addFunction(String funcName,String parentName,Integer type,String url);
	
	
	/*====================================用户=======================================*/

	Boolean addSysUser(String loginName, String oncePassword, String twicePassword,
			String actualName, String role);

	String updateRole(String origRole, String newRole);

	String updateFunction(String funcName, String parentName, Integer type, String url);
	
	SysmLoginInfo sysmLlogin(String loginName,String password,String autoLogin);
	

}
