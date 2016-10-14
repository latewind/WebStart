package com.latewind.controller.admin.sysm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latewind.pojo.sysm.AjaxSubmitFunc;
import com.latewind.pojo.sysm.SysmFunction;
import com.latewind.pojo.sysm.SysmRole;
import com.latewind.service.sysm.ISystemManService;

@Controller
public class SystemFunController {
	Logger logger = Logger.getLogger(SystemFunController.class);
	
	@Resource
	private ISystemManService systemManService;
	
	//
	@RequestMapping("/admin/system/viewFunction.html")
	public String viewSysmFunc(Model model) {
//		Role List角色列表
		List<SysmRole> roleList=systemManService.listAllRole();
		model.addAttribute("roleList", roleList);
		List<SysmFunction> funcList=systemManService.listAllFunction();
		model.addAttribute("funcMap", handleSysmFunction(funcList));
		
		return "admin/system/viewFunction";
			
	}
	
	@ResponseBody
	@RequestMapping("/admin/system/ajax/roleFunc")
	public Map ajaxRoleFunc(Model model,String roleName) {
//		Role List角色列表
		List<SysmFunction> funcList =null;
		if(roleName!=null&&roleName!=""){
			
			 funcList =	systemManService.listFunctionByRole(null, roleName);
		}		
		
		Map<String,List> json=new HashMap<>();
		json.put("func", funcList);
		model.addAttribute("funcList", funcList);
		return json;			
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/system/ajax/submitFunc",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxSubmitFunc(@RequestBody AjaxSubmitFunc json) {
//		Role List角色列表
	
	logger.info("roleName"+json.getRoleName());
		
	Integer list=	systemManService.getRoleByName(json.getRoleName()).getRoleId();
		
	systemManService.addRoleFunction(json.getFuncId(), list);
		
		for(Integer i:json.getFuncId()){
		logger.info(i);
		}
		return "success";			
	}
	
	@RequestMapping(value="/admin/system/updateRole.html")
	public String updateRolePage(Model model) {
		
//		Role List角色列表
		List<SysmRole> roleList=systemManService.listAllRole();
		model.addAttribute("roleList", roleList);
		
		return "admin/system/updateRole";			
	}
	
/**
 * 新增角色	
 * @param model
 * @param newRole
 * @return
 */
	@RequestMapping(value="/admin/system/createRoleAction")
	public String createRoleAction(Model model,String newRole) {
	String msg=	systemManService.createNewRole(newRole);
	model.addAttribute("mag", msg);
	List<SysmRole> roleList=systemManService.listAllRole();
	model.addAttribute("roleList", roleList);

	logger.info("create new Role"+newRole);
		return "redirect:/admin/system/updateRole";			
	}
	/**
	 * 更新角色名
	 * @param model
	 * @param origRole
	 * @param newRole
	 * @return
	 */
	
	@RequestMapping(value="/admin/system/updateRoleAction")
	public String updateRoleAction(Model model,String origRole,String newRole) {
//		Role List角色列表
		systemManService.updateRole(origRole,newRole);
		logger.info("create new Role"+newRole);
		return "redirect:/admin/system/updateRole.html";			
	}
	
	
	
	@RequestMapping(value="/admin/system/updateFunction.html")
	public String updateFuncPage(Model model) {
		
	
		
		List<SysmFunction> funcList=systemManService.listAllFunction();
		model.addAttribute("funcMap", handleSysmFunction(funcList));
			
		
		return "admin/system/updateFunction";			
	}
	


	
	@RequestMapping(value="/admin/system/addFunctionAction")
	public String addFuncAction(Model model,String funcName,String parentName,Integer type,String url) {
//		Role List角色列表
		logger.info("create new Function"+ funcName+parentName+url+type);
		
		systemManService.addFunction( funcName, parentName, type, url);
		return "redirect:/admin/system/updateFunction.html";			
	}
	
	
	@RequestMapping(value="/admin/system/updateFunctionAction")
	public String updateFuncAction(Model model,String funcName,String parentName,Integer type,String url) {
		logger.info("update new Function"+ funcName+parentName+url+type);
		
		systemManService.updateFunction( funcName, parentName, type, url);
		
		return "redirect:/admin/system/updateFunction.html";			
	}
	
	
	@ResponseBody
	@RequestMapping(value="/admin/system/ajax/loadFunction")
	public Map ajaxLoadFunc(String  funcName) {
//		Role List角色列表
	
		SysmFunction func=	systemManService.getFuncionByName(funcName);
		String parentName="";
		Integer id=func.getParentId();
		
		if(id!=0){
			parentName=systemManService.getFunctionById(id).getFunctionName();
		}
		String type=func.getFunctionType()==true?"1":"0";
		Map<String, String> json=new HashMap<>();
		
		json.put("funcName", func.getFunctionName());
		json.put("parentName", parentName);
		json.put("type", type);
		json.put("url", func.getFunctionUrl());
		
		return json;			
	}
	
	
	public   static  Map<Integer, SysmFunction> handleSysmFunction( List<SysmFunction> funcList){
		
		HashMap<Integer, SysmFunction> map=new HashMap<>();
		for(SysmFunction func:funcList){
			if(func.getParentId()==0){
				func.setChildList(new LinkedList<>());
			map.put(func.getFunctionId(), func);
			
			}else{
				map.get(func.getParentId()).getChildList().add(func);		
			}		
			
		}
		
		return map;
	  }
		
	
	
	
}
