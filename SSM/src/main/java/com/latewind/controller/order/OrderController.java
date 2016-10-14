package com.latewind.controller.order;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latewind.common.constants.CommonConstants;
import com.latewind.common.security.CombineArgsContext;
import com.latewind.common.tools.PassKeyEncoder;
import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.OrderPageInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.order.ShoppingCart;
import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.LoginMessage;
import com.latewind.pojo.user.UserInfo;
import com.latewind.service.order.IOrderService;
import com.latewind.service.user.IUserInfoService;

@Controller
public class OrderController {
	Logger logger = Logger.getLogger(OrderController.class);

	@Resource
	private IOrderService orderService;
	
	@Resource
	private IUserInfoService userInfoService;
	
	@RequestMapping("/front/order/viewOrder")
	public String viewOrder(HttpServletRequest request,HttpSession session,Model model,HttpServletResponse response) {
		List<ProductPack> productPacks=null;	
		LoginInfo loginInfo=ValidateLogin.getLoginInfo(request);
		Integer userId=	loginInfo.getUserId();
		ShoppingCart shoppingCart=orderService.getCartByUserId(userId);
		try {
			productPacks=shoppingCart.getProductPacks();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("空异常");
			return "front/order/ajaxViewCartNull";
		}
		
		UserInfo u=userInfoService.getUserInfo(userId);
		model.addAttribute("productPacks", productPacks);	
		model.addAttribute("user", u);
		
		response.setDateHeader("Expires", -1); 
		response.addHeader( "Cache-Control", "no-cache" );//浏览器和缓存服务器都不应该缓存页面信息
		response.addHeader( "Cache-Control", "no-store" );//请求和响应的信息都不应该被存储在对方的磁盘系统中； 
		response.addHeader( "Cache-Control", "must-revalidate" );///于客户机的每次请求，代理服务器必

		return "front/order/order";
	}
	@ResponseBody
	@RequestMapping(value="/front/order/orderConfirm",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String confirmOrder(@RequestBody OrderPageInfo json,HttpServletRequest  request){
		LoginInfo loginInfo=ValidateLogin.getLoginInfo(request);
		Integer userId=	loginInfo.getUserId();
		Integer orderId=orderService.addOrder(json,userId);
		logger.info(json.getAddress());
		System.out.println(json.getPayMethod());
		return  "<p>"+orderId+"</p>";
	}
	
	@RequestMapping("/front/order/payfor")
	public String payfor(HttpServletRequest request,@RequestParam("orderId") Integer orderId ,Model model){
		
		LoginInfo loginInfo=ValidateLogin.getLoginInfo(request);
		Integer userId=	loginInfo.getUserId();
		String passKey=	PassKeyEncoder.encodePassKey(CombineArgsContext.getResult(userId, orderId, loginInfo.getSalt()),"MD5");
		
		model.addAttribute("orderId",orderId);
		
		model.addAttribute("passKey",passKey);
		logger.info(orderId);
		return "front/order/payfor";
		
		
	}
	@RequestMapping("/front/order/payforSuccess")
	public String payforSuccess(HttpServletRequest request,Integer orderId,String passKey){
		
		
		LoginInfo loginInfo=ValidateLogin.getLoginInfo(request);
		Integer userId=	loginInfo.getUserId();
		
		String passKeyCalcu=PassKeyEncoder.encodePassKey(CombineArgsContext.getResult(userId, orderId, loginInfo.getSalt()),"MD5");
		
		if(passKey.equals(passKeyCalcu)){
			if(orderService.updateProductWhenPayfor(orderId)){
				
				
				System.out.println("完成付款");
			}else{
				
				System.out.println("没有库存了");
				
			};
			
			
		}
		else{
			
				logger.info("OrderId passKey 不一致");
		}
		
		
		//返回个人订单页面
		return "redirect:/front/personal/orders";
		
		
		
	}

}
