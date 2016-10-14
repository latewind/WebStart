package com.latewind.service.impl.sysm;

import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

import javax.annotation.Resource;
import javax.sound.midi.MidiDevice.Info;

import org.springframework.stereotype.Service;

import com.latewind.common.constants.CommonConstants;
import com.latewind.dao.sysm.SysmFunctionMapper;
import com.latewind.dao.sysm.SysmRoleMapper;
import com.latewind.dao.sysm.SysmUserMapper;
import com.latewind.pojo.admin.user.SysmLoginInfo;
import com.latewind.pojo.sysm.SysmFunction;
import com.latewind.pojo.sysm.SysmRole;
import com.latewind.pojo.sysm.SysmUser;
import com.latewind.service.sysm.ISystemManService;

@Service("systemManService")
public class SystemManServiceImpl implements ISystemManService {

	@Resource
	private SysmRoleMapper sysmRoleDAO;
	
	@Resource
	private  SysmUserMapper sysmUserDAO;
	
	@Resource
	private SysmFunctionMapper sysmFunctionDAO;
	
	@Override
	public List<SysmRole> listAllRole() {
				return sysmRoleDAO.selectAllRole();
	}

	@Override
	public SysmRole getRoleByName(String roleName) {
				return sysmRoleDAO.selectByRoleName(roleName);
	}

	@Override
	public Boolean addSysUser(String loginName, String oncePassword, String twicePassword, String actualName,
			String roleName) {
		// TODO 验证 申请信息
		Integer roleId=sysmRoleDAO.selectByRoleName(roleName).getRoleId();
		SysmUser record=new SysmUser();
		record.setActualName(actualName);
		record.setLoginName(loginName);
		record.setLoginPwd(oncePassword);
		record.setRoleId(roleId);
		sysmUserDAO.insertSelective(record);
//		SysmRole sysmRole=new SysmRole();
		
		
		return true;
	}

	@Override
	public List<SysmFunction> listAllFunction() {
				return sysmFunctionDAO.selectAllFunction();
	}

	@Override
	public Boolean hasFunction(String actionUrl,Integer roleId) {
			Boolean b=	sysmFunctionDAO.selectRoleFunctionCount(actionUrl, roleId)>0 ? true:false;
		return b;
	}

	@Override
	public List<SysmFunction> listFunctionByRole(Integer roleId, String roleName) {
				return sysmFunctionDAO.selectRoleFuncByRole(roleId, roleName);
	}

	@Override
	public Integer addRoleFunction(List<Integer> list, Integer roleId) {
				sysmRoleDAO.deleteRoleFunction(roleId);
		
		return sysmRoleDAO.insertRoleFunction(list, roleId);
	}

	@Override
	public String createNewRole(String roleName) {
				if(sysmRoleDAO.selectByRoleName(roleName)!=null)
			{
			return "已经存在该角色";
			}else{
				SysmRole role =new SysmRole();
				role.setRoleName(roleName);
				role.setCreateTime(new Date());
				sysmRoleDAO.insertSelective(role);
				return "";
			}
				
	}

	@Override
	public String updateRole(String origRole, String newRole) {
				if(sysmRoleDAO.selectByRoleName(newRole)!=null)
		{
		return "已经存在该角色";
		}
		 SysmRole role=sysmRoleDAO.selectByRoleName(origRole);
		 role.setRoleName(newRole);
		 role.setCreateTime(new Date());
		 sysmRoleDAO.updateByPrimaryKeySelective(role);
		 return "";
	}

	@Override
	public SysmFunction getFuncionByName(String funcName) {
				return sysmFunctionDAO.selectFunctionByName(funcName);
	}

	@Override
	public Integer addFunction(String funcName, String parentName, Integer funcType, String url) {
			SysmFunction parent=sysmFunctionDAO.selectFunctionByName(parentName);
	if(parent==null){
		return null;}
	SysmFunction child=sysmFunctionDAO.selectFunctionByName(funcName);
		
	if(child!=null){
		return null;
	}
	Boolean b=funcType>0?true:false;
	SysmFunction newFunc=new SysmFunction();
	newFunc.setFunctionName(funcName);
	newFunc.setFunctionType(b);
	newFunc.setFunctionUrl(url);
	newFunc.setParentId(parent.getFunctionId());
	return sysmFunctionDAO.insertSelective(newFunc);
	}

	@Override
	public String updateFunction(String funcName, String parentName, Integer funcType, String url) {
					SysmFunction parent=sysmFunctionDAO.selectFunctionByName(parentName);
	Integer parentId=0;
	if(parent!=null){
	parentId=parent.getFunctionId();	
	}
	SysmFunction child=sysmFunctionDAO.selectFunctionByName(funcName);
		
	if(child==null){
		return "FAIL";
	}
	Boolean b=funcType>0?true:false;
	child.setFunctionName(funcName);
	child.setFunctionType(b);
	child.setFunctionUrl(url);
	child.setParentId(parentId);
	sysmFunctionDAO.updateByPrimaryKeySelective(child);
	return "SUCCESS";
		
	}

	@Override
	public SysmFunction getFunctionById(Integer id) {
				return sysmFunctionDAO.selectByPrimaryKey(id);
	}

	@Override
	public SysmLoginInfo sysmLlogin(String loginName, String password, String autoLogin) {
				SysmUser user=	sysmUserDAO.selectByLoginName(loginName);
		SysmLoginInfo info=new SysmLoginInfo();
//		info.setAutoLogin(autoLogin);
		if(user!=null&&user.getLoginPwd().equals(password)){
			
			System.out.println("success login in system");
			Integer roleId=user.getRoleId();
			String roleName=sysmRoleDAO.selectByPrimaryKey(roleId).getRoleName();
			info.setAlertMsg(CommonConstants.LOGIN_SUCCESS_INFO);
			info.setSuccess(true);
			info.setLoginName(user.getLoginName());
			info.setLoginTime(new Date());
			info.setUserId(user.getUserId());
			info.setRoleId(roleId);
			info.setRoleName(roleName);
			
		}else{
			info.setAlertMsg(CommonConstants.LOGIN_SUCCESS_INFO);
			info.setSuccess(false);
		}
	
		
		return info;
	}
		
}
