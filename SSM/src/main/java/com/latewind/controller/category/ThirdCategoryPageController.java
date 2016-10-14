package com.latewind.controller.category;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.category.ICategoryManService;
import com.latewind.service.category.ISubCategoryService;
import com.latewind.service.category.IThirdCategoryService;
import com.latewind.service.product.IProductService;
@Controller
public class ThirdCategoryPageController {

	@Resource 
	private IProductService productService=null;
	
	@Resource
	private IThirdCategoryService thirdCategoryService=null;
	
	@Resource
	private ISubCategoryService subCategoryService=null;
	
	@Resource
	private ICategoryManService categoryManService=null;
	Logger logger = Logger.getLogger(ThirdCategoryPageController.class);
	@RequestMapping("/front/thirdCategory/{thirdId}")
	public String viewThirdCategoryPage(HttpServletRequest request,@PathVariable Integer thirdId,Model model,HttpSession session){
		logger.info("三级目录ID为"+thirdId);	
		
		
		session.setAttribute("thirdPage", 1);
		List<ProductInfo> productInfo =productService.listProductByThirdId(thirdId, 0, 20);
//		//获取商品分类1-2-3级
//		Map categoryMap=categoryManService.getProduct123Category(prtId);
//		model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("productInfo", productInfo);
//		將三級ID放進去
		model.addAttribute("thirdId", thirdId);
//		
		return "front/category/thirdCategory";
	}
	/**
	 *三级分类 滚轮到底部 触发aJax事件 输出 商品信息
	 * 
	 * @param request
	 * @param model
	 * @param thirdId
	 * @return
	 */
	@RequestMapping("/front/ajax/thirdCategory/product")
	public String loadThirdProduct(HttpServletRequest request,Model model,Integer thirdId,HttpSession session){
		
	Integer nextPage=(Integer)session.getAttribute("thirdPage");
//		//获取商品
		List<ProductInfo> productInfo =productService.listProductByThirdId(thirdId, nextPage*20, 20);
		
		if(productInfo==null){
			
			return null;
		}
//		//获取商品分类1-2-3级
//		Map categoryMap=categoryManService.getProduct123Category(prtId);
//		
		session.setAttribute("thirdPage", nextPage+1);
		System.out.println(productInfo.size()+" Third Append size"+nextPage);
		
//		model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("productInfo", productInfo);
//		
		return "front/category/ajaxThirdProduct";
	}
	
	
}