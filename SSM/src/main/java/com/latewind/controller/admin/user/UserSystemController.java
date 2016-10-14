package com.latewind.controller.admin.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.MidiDevice.Info;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.admin.user.SysmLoginInfo;
import com.latewind.pojo.sysm.SysmRole;
import com.latewind.service.sysm.ISystemManService;

@Controller
public class UserSystemController {

	@Resource
	private ISystemManService systemManService;

	/**
	 * 增加 系统用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/user/addUser.html")
	public String addSysmUser(Model model) {
		
		List<SysmRole> roleList=systemManService.listAllRole();
		model.addAttribute("roleList", roleList);
		return "admin/user/addUser";
	
	}

	@RequestMapping("/admin/user/addUserAction")
	public String addSysmUserAction(Model model,String loginName,String oncePassword,String twicePassword,
			
			 String actualName,String role) {

		systemManService.addSysUser(loginName, oncePassword, twicePassword, actualName, role);
	
//		List<SysmRole> roleList=systemManService.listAllRole();
//		model.addAttribute("roleList", roleList);
		return "redirect:/admin/user/addUser.html";
	
	}
	
	
	@RequestMapping("/admin/login.html")
	public String sysmLoginPage(Model model) {

		return "admin/user/login";
	}
	
	
	
	@RequestMapping("/admin/user/loginAction")
	public String sysmLoginAction(Model model,HttpServletRequest request,String loginName,String password, String autoLogin) {
		System.out.println(loginName+password+autoLogin);
		SysmLoginInfo info=systemManService.sysmLlogin(loginName, password, autoLogin);
		if(info.getSuccess()){
						
			ValidateLogin.setSysmLoginInfo(request, info);
			return "redirect:/admin/index.html";
			
		}else{
			
			return "redirect:/admin/login.html";
		}
			
	
//		List<SysmRole> roleList=systemManService.listAllRole();
//		model.addAttribute("roleList", roleList);
	
	}
	
	@RequestMapping("/system/user/logoutAction")
	public String sysmLogoutAction(HttpServletRequest request){
		
		SysmLoginInfo sInfo=ValidateLogin.getSysmLoginInfo(request);
		if(sInfo!=null){
			ValidateLogin.setSysmLoginInfo(request, null);
		}
		
		return "redirect:/admin/longin.html";
	}
	
	
	
}
