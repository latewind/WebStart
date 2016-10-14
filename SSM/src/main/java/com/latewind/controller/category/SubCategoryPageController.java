package com.latewind.controller.category;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
public class SubCategoryPageController {

	@Resource 
	private IProductService productService=null;
	
	@Resource
	private IThirdCategoryService thirdCategoryService=null;
	
	@Resource
	private ISubCategoryService subCategoryService=null;
	
	@Resource
	private ICategoryManService categoryManService=null;
	Logger logger = Logger.getLogger(SubCategoryPageController.class);
	@RequestMapping("/front/subCategory/{subId}")
	public String viewThirdCategoryPage(HttpServletRequest request,@PathVariable Integer subId,Model model){
		logger.info("二级目录ID为"+subId);	
		
//		//获取商品
		List<ProductInfo> productInfo =productService.listProductBySubId(subId, null, 30);
//		//获取商品分类1-2-3级
//		Map categoryMap=categoryManService.getProduct123Category(prtId);
//		model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("productInfo", productInfo);
//		將三級ID放進去
		model.addAttribute("subId", subId);
//		
		return "front/category/subCategory";
	}
	/**
	 *三级分类 滚轮到底部 触发aJax事件 输出 商品信息
	 * 
	 * @param request
	 * @param model
	 * @param thirdId
	 * @return
	 */
	@RequestMapping("/front/ajax/subCategory/product")
	public String loadThirdProduct(HttpServletRequest request,Model model,Integer subId){
		
//		//获取商品
		List<ProductInfo> productInfo =productService.listProductBySubId(subId, null, 30);
//		//获取商品分类1-2-3级
//		Map categoryMap=categoryManService.getProduct123Category(prtId);
//		
//	
//		model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("productInfo", productInfo);
//		
		return "front/category/ajaxThirdProduct";
	}
	
	
}