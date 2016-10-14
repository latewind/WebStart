package com.latewind.controller.product;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.product.IProductService;

@Controller
public class SearchProductController {
	@Resource
	private IProductService productService = null;

	Logger logger = Logger.getLogger(SearchProductController.class);

	 @RequestMapping(value = "/front/product/searchPrtAction")
	public String searchPrtAction(Model model, String keyword) throws UnsupportedEncodingException {

		logger.info(keyword + "search");
		
		String[] querys = keyword.split("\\s+");
		
		Set<String> keywordSet = new HashSet<>();

		for (String s : querys) {
			
		
			keywordSet.add(s);
			System.out.println(s);
		}
		Set<Integer> prtIdSet = productService.listPrtByKeyWord(keywordSet);
		System.out.println(prtIdSet);
		// TODO 优化搜索 分页 标签
		// 获取商品
		
		try{
		List<ProductInfo> productInfo = productService.randomListProduct(prtIdSet, 20);
		// //获取商品分类1-2-3级
		// Map categoryMap=categoryManService.getProduct123Category(prtId);
		//
		// model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("labels", querys);
		model.addAttribute("productInfo", productInfo);
		// 將三級ID放進去
		}
		catch(Exception e){
			model.addAttribute("errorMsg", "没有查询到相关产品");
			return "front/product/searchProduct";
			
		}
		
	
		return "front/product/searchProduct";
	
	}

}
