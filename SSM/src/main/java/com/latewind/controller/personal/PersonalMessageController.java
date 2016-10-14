package com.latewind.controller.personal;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PersonalMessageController {
	
	
	@RequestMapping("/front/personal/message")
	public String personalAllOrders(HttpServletRequest request, Model model) {

		model.addAttribute("msg", "没有相关消息");
		return "front/personal/messages";
	}

}
