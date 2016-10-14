package com.latewind.controller.personal;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.Case;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.latewind.common.constants.CommonConstants;
import com.latewind.common.security.CombineArgsContext;
import com.latewind.common.tools.Page;
import com.latewind.common.tools.PassKeyEncoder;
import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.personal.NewPassword;
import com.latewind.pojo.personal.NewUserInfo;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.pojo.product.PrtComment;
import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.UserInfo;
import com.latewind.service.order.IOrderService;
import com.latewind.service.personal.IPersonalService;
import com.latewind.service.product.IProductService;
import com.latewind.service.user.IUserInfoService;

@Controller
public class PersonalController {
	@Resource
	private IPersonalService personalService;

	@Resource
	private IOrderService orderService;

	@Resource
	private IUserInfoService userInfoService;
	Logger logger = Logger.getLogger(PersonalController.class);

	@Resource
	private IProductService productService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@RequestMapping("/front/personal/orders")
	public String personalAllOrders(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		pageNow = pageNow == null ? "1" : pageNow.trim();
		// 获取用户ID

		LoginInfo loginInfo = ValidateLogin.getLoginInfo(request);// ValidateLogin.getLoginInfo(request).getUserId();
		Integer useId = loginInfo.getUserId();
		// 获取订单总数
		Integer totalCount = personalService.getOrderCountByUserId(useId, CommonConstants.ALL_ORDERS);//
		// 分页
		Page page = new Page(totalCount, Integer.valueOf(pageNow));
		List<OrderInfo> orderList = null;
		if (totalCount > 0) {
			orderList = personalService.getOrderByUserId(useId, page.getStartPos(), page.getPageSize(),
					CommonConstants.ALL_ORDERS);

			appendPassKey(orderList, loginInfo);
		}

		// personalService.getOrderByUserId(userId, startPos, step);
		logger.info("personal info" + pageNow);
		model.addAttribute("orderList", orderList);
		model.addAttribute("page", page);
		model.addAttribute("actionName", "orders");
		return "front/personal/orders";
	}

	@RequestMapping("/front/personal/unpaidOrders")
	public String unpaidOrders(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		pageNow = pageNow == null ? "1" : pageNow.trim();
		// 获取用户ID
		LoginInfo loginInfo = ValidateLogin.getLoginInfo(request);// ValidateLogin.getLoginInfo(request).getUserId();
		Integer useId = loginInfo.getUserId();
		// 获取订单总数
		Integer totalCount = personalService.getOrderCountByUserId(useId, CommonConstants.UN_PAID);//
		// 分页
		Page page = new Page(totalCount, Integer.valueOf(pageNow));
		List<OrderInfo> orderList = null;
		if (totalCount > 0) {
			orderList = personalService.getOrderByUserId(useId, page.getStartPos(), page.getPageSize(),
					CommonConstants.UN_PAID);
			appendPassKey(orderList, loginInfo);
		}
		// personalService.getOrderByUserId(userId, startPos, step);
		logger.info("personal info" + pageNow);
		model.addAttribute("orderList", orderList);
		model.addAttribute("page", page);
		model.addAttribute("actionName", "unpaidOrders");
		return "front/personal/orders";
	}

	@RequestMapping("/front/personal/paidOrders")
	public String paidOrders(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		pageNow = pageNow == null ? "1" : pageNow.trim();
		// 获取用户ID
		Integer useId = ValidateLogin.getLoginInfo(request).getUserId();// ValidateLogin.getLoginInfo(request).getUserId();
		// 获取订单总数
		Integer totalCount = personalService.getOrderCountByUserId(useId, CommonConstants.COMPLETE_PAID);//
		// 分页
		Page page = new Page(totalCount, Integer.valueOf(pageNow));
		List<OrderInfo> orderList = null;
		if (totalCount > 0) {
			orderList = personalService.getOrderByUserId(useId, page.getStartPos(), page.getPageSize(),
					CommonConstants.COMPLETE_PAID);
		} // personalService.getOrderByUserId(userId, startPos, step);
		model.addAttribute("orderList", orderList);
		model.addAttribute("page", page);
		model.addAttribute("actionName", "paidOrders");
		return "front/personal/orders";
	}
	@RequestMapping("/front/personal/deliveryOrders")
	public String deliveryOrders(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		pageNow = pageNow == null ? "1" : pageNow.trim();
		// 获取用户ID
		Integer useId = ValidateLogin.getLoginInfo(request).getUserId();// ValidateLogin.getLoginInfo(request).getUserId();
		// 获取订单总数
		Integer totalCount = personalService.getOrderCountByUserId(useId, CommonConstants.HAVE_DELIVERY);//
		// 分页
		Page page = new Page(totalCount, Integer.valueOf(pageNow));
		List<OrderInfo> orderList = null;
		if (totalCount > 0) {
			orderList = personalService.getOrderByUserId(useId, page.getStartPos(), page.getPageSize(),
					CommonConstants.HAVE_DELIVERY);
		} // personalService.getOrderByUserId(userId, startPos, step);
		model.addAttribute("orderList", orderList);
		model.addAttribute("page", page);
		model.addAttribute("actionName", "deliveryOrders");
		return "front/personal/orders";
	}
	
	/**
	 * 已完成的订单
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/front/personal/completedOrders")
	public String completedOrders(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		pageNow = pageNow == null ? "1" : pageNow.trim();
		// 获取用户ID
		LoginInfo loginInfo = ValidateLogin.getLoginInfo(request);
		Integer userId = loginInfo.getUserId();
		// 获取订单总数
		Integer totalCount = personalService.getOrderCountByUserId(userId, CommonConstants.COMPLETE_ORDERS);//
		// 分页
		Page page = new Page(totalCount, Integer.valueOf(pageNow));
		List<OrderInfo> orderList = null;
		if (totalCount > 0) {
			orderList = personalService.getOrderByUserId(userId, page.getStartPos(), page.getPageSize(),
					CommonConstants.COMPLETE_ORDERS);

			for (OrderInfo orderInfo : orderList) {

				for (ProductPack pack : orderInfo.getProductPacks())

					pack.setPassKey(PassKeyEncoder.encodePassKey(
							CombineArgsContext.getResult(userId, pack.getCartProductId(), loginInfo.getSalt()), "MD5"));

			}
		} // personalService.getOrderByUserId(userId, startPos, step);
		model.addAttribute("orderList", orderList);
		model.addAttribute("page", page);
		model.addAttribute("actionName", "completedOrders");
		return "front/personal/orders";
	}

	private void appendPassKey(List<OrderInfo> orderInfos, LoginInfo loginInfo) {
		for (OrderInfo orderInfo : orderInfos) {

			switch (orderInfo.getOrderStatus()) {

			case CommonConstants.COMPLETE_ORDERS:
				for (ProductPack pack : orderInfo.getProductPacks()) {

					pack.setPassKey(PassKeyEncoder.encodePassKey(CombineArgsContext.getResult(loginInfo.getUserId(),
							pack.getCartProductId(), loginInfo.getSalt()), "MD5"));
				}
				break;
			case CommonConstants.UN_PAID:
				orderInfo.setPassKey(PassKeyEncoder.encodePassKey(CombineArgsContext.getResult(loginInfo.getUserId(),
						orderInfo.getOrderId(), loginInfo.getSalt()), "MD5"));
				break;
			default:
				break;
			}

			for (ProductPack pack : orderInfo.getProductPacks())

				pack.setPassKey(PassKeyEncoder.encodePassKey(CombineArgsContext.getResult(loginInfo.getUserId(),
						pack.getCartProductId(), loginInfo.getSalt()), "MD5"));

		}

	}

	private Boolean ValidPassKey(HttpServletRequest request, Integer packId, String passKey) {

		LoginInfo loginInfo = ValidateLogin.getLoginInfo(request);
		Integer userId = loginInfo.getUserId();
		String passKeyCacul = PassKeyEncoder
				.encodePassKey(CombineArgsContext.getResult(userId, packId, loginInfo.getSalt()), "MD5");
		return passKeyCacul.equals(passKey);
	}

	@RequestMapping("/front/personal/commentProduct.html")
	public String commmentProduct(HttpServletRequest request, Model model, Integer packId, String passKey) {
		// TODO 验证商品包
		if (ValidPassKey(request, packId, passKey)) {
			System.out.println("passKey 正确");
			ProductPack pack = orderService.getProductPackById(packId);

			ProductInfo productInfo = productService.getProductInfoById(pack.getPrtId());
			pack.setPassKey(passKey);
			pack.setProductInfo(productInfo);
			model.addAttribute("productPack", pack);
			if (pack.getCommentId() != null) {
				model.addAttribute("comment", personalService.getCommentById(pack.getCommentId()));
			}

			logger.info("commment : packId:" + packId);
		}
		return "front/personal/commentProduct";

	}

	/**
	 * 提交商品评论
	 * 
	 * @param request
	 * @param model
	 * @param packId
	 * @param evalRank
	 * @param prtComment
	 * @return
	 */
	@RequestMapping("/front/personal/commentProductAction")
	public String commmentPrtAction(HttpServletRequest request, Model model, Integer packId, Integer evalRank,
			String prtComment, String passKey) {
		if (ValidPassKey(request, packId, passKey)) {
			// TODU 验证是否是用户自己的产品包
			System.out.println("通过passKey 可以提交Comment");
			ProductPack pack = orderService.getProductPackById(packId);
			if (pack.getCommentId() == null) {
				PrtComment comment = new PrtComment();
				comment.setContent(prtComment);
				comment.setEvalRank(evalRank);
				comment.setUserId(1);
				// comment.setCreateTime(new Date());
				comment.setPrtId(pack.getPrtId());
				personalService.addPrtComment(comment, pack);

				System.out.println("add prtComment");
				// comment.set

			} else {
				PrtComment comment = personalService.getCommentById(pack.getCommentId());
				comment.setContent(prtComment);
				comment.setEvalRank(evalRank);
				comment.setUserId(1);
				comment.setCreateTime(new Date());
				comment.setPrtId(pack.getPrtId());
				personalService.updatePrtComment(comment);

			}

			logger.info("commment : packId:" + packId + evalRank + prtComment);
		}

		return "redirect:/front/personal/completedOrders";
	}

	/**
	 * 查看个人信息
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/front/personal/viewInfo")
	public String viewPersonalInfo(HttpServletRequest request, Model model) {
		Integer userId = ValidateLogin.getLoginInfo(request).getUserId();
		UserInfo userInfo = userInfoService.getUserInfo(userId);
		model.addAttribute("user", userInfo);
		return "front/personal/personalInfo";
	}

	/**
	 * 输出 头像
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/front/personal/getHead")
	public void getHead(HttpServletRequest request, HttpServletResponse response, Integer userId) {

		System.out.println(userId + "in getHead");
		if (userId == null) {
			userId = 1;

		}
		UserInfo userInfo = userInfoService.getUserInfo(userId);
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			out.write(userInfo.getHead());
			out.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 修改个人信息
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/front/personal/modifyInfo")
	public String modifyInfo(HttpServletRequest request, NewUserInfo newUserInfo) {

		Integer userId = ValidateLogin.getLoginInfo(request).getUserId();
		// TODO 修改信息 失败 成功返回成功页面
		System.out.println(newUserInfo.getNewBirthDate());
		UserInfo u = userInfoService.getUserInfo(userId);

		u.setNewValue(newUserInfo);

		personalService.updatePersonalInfo(u);

		String string = newUserInfo.toString();
		System.out.println(string);
		return "redirect:/front/personal/viewInfo";
	}

	/**
	 * 修改密码页面
	 * 
	 * @return
	 */
	@RequestMapping("/front/personal/modifyPassword")
	public String modifyPassword(Model model, HttpServletRequest request) {

		Integer userId = ValidateLogin.getLoginInfo(request).getUserId();
		UserInfo u = userInfoService.getUserInfo(userId);
		model.addAttribute("userName", u.getUserName());
		return "front/personal/modifyPw";
	}

	/**
	 * 提交修改密码
	 * 
	 * @return
	 */
	@RequestMapping("/front/personal/modifyPwAction")
	public String modifyPwAction(NewPassword newPassword, HttpServletRequest request) {

		// TODO 修改密码提交 添加验证
		System.out.println(newPassword);
		Integer userId = ValidateLogin.getLoginInfo(request).getUserId();
		UserInfo u = userInfoService.getUserInfo(userId);

		u.setNewPassword(newPassword);

		personalService.updatePersonalInfo(u);
		return "redirect:/front/personal/viewInfo";
	}

}
