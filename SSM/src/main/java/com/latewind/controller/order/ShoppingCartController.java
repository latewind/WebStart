package com.latewind.controller.order;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latewind.common.constants.CommonConstants;
import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.order.ShoppingCart;
import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.LoginMessage;
import com.latewind.service.order.IOrderService;
/**
 * 购物车控制类
 * @author latewind
 *
 */
@Controller
public class ShoppingCartController {
	Logger logger = Logger.getLogger(ShoppingCartController.class);
	
	@Resource
	private IOrderService orderService;
	/**
	 * 往购物车添加商品
	 * @param prtId
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/front/ajax/cart/appendPrt",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String  appendProduct(Integer prtId,HttpSession session,HttpServletRequest request){
		
		
		LoginInfo loginInfo=ValidateLogin.getLoginInfo(request);
		Integer userId=	loginInfo.getUserId();
		
		// 
//		orderService.
		Integer count=1;
		orderService.appendProductPack(userId, prtId, count);
		logger.info("append product to cart"+prtId);
		
    return CommonConstants.APPEND_PRODUCT_TO_CART_SUCCESS;	
    }
	/**
	 * 展示购物车商品
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/front/ajax/cart/viewCart")
	public String viewShoppingCart(HttpSession session,Model model ,HttpServletRequest request){
		
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
		model.addAttribute("productPacks", productPacks);
		
		return "front/order/ajaxViewCart";
	}
	
	@ResponseBody
	@RequestMapping("/front/ajax/cart/deletePrt")
	public String deleteCartPrt(Integer prtPackId){
		
		orderService.deleteProductPack(prtPackId);
		return "delete ";
	}
	
}
