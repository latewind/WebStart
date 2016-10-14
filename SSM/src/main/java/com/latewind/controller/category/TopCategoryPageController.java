package com.latewind.controller.category;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latewind.pojo.ThirdCategory;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.category.ICategoryManService;
import com.latewind.service.category.ISubCategoryService;
import com.latewind.service.category.IThirdCategoryService;
import com.latewind.service.product.IProductService;
@Controller
public class TopCategoryPageController {

	@Resource 
	private IProductService productService=null;
	
	@Resource
	private IThirdCategoryService thirdCategoryService=null;
	
	@Resource
	private ISubCategoryService subCategoryService=null;
	
	@Resource
	private ICategoryManService categoryManService=null;
	Logger logger = Logger.getLogger(TopCategoryPageController.class);
	@RequestMapping("/front/topCategory/{topId}")
	public String viewThirdCategoryPage(HttpServletRequest request,@PathVariable Integer topId,Model model){
		logger.info("三级目录ID为"+topId);	
		
		Map<String ,List> map=new LinkedHashMap<>();
		List<ThirdCategory> thirds=categoryManService.getThirdByTop(topId);
		for(ThirdCategory t:thirds){
			
		
			List<ProductInfo>	productInfos=	productService.listProductByThirdId(t.getId(), null, 8);
		
			map.put(t.getName(), productInfos);
		}
		
		model.addAttribute("thirdPrtMap", map);
//		//获取商品
//		List<ProductInfo> productInfo =productService.listProductByThirdId(thirdId, null, null);
//		//获取商品分类1-2-3级
//		Map categoryMap=categoryManService.getProduct123Category(prtId);
//		
			logger.info("topId："+topId);
//		model.addAttribute("categoryMap", categoryMap);
//		model.addAttribute("productInfo", productInfo);
//		將三級ID放進去
		model.addAttribute("topId", topId);
//		
		return "front/category/topCategory";
	}
	/**
	 *三级分类 滚轮到底部 触发aJax事件 输出 商品信息
	 * 
	 * @param request
	 * @param model
	 * @param thirdId
	 * @return
	 */
	@RequestMapping("/front/ajax/topCategory/product")
	public String loadThirdProduct(HttpServletRequest request,Model model,Integer thirdId){
		
//		//获取商品
		List<ProductInfo> productInfo =productService.listProductByThirdId(thirdId, null, null);
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