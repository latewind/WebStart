package com.latewind.controller.index;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latewind.pojo.Category;
import com.latewind.pojo.Product;
import com.latewind.pojo.notice.Announcement;
import com.latewind.pojo.notice.Headline;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.ICategoryService;
import com.latewind.service.category.ITopCategoryService;
import com.latewind.service.notice.INoticeService;
import com.latewind.service.product.IProductService;

@Controller
public class IndexController {
	@Resource
	private ICategoryService categoryService=null;
	@Resource 
	private ITopCategoryService topCategoryService=null;
	@Resource
	private IProductService productService=null;
	
	@Resource
	private INoticeService noticeService=null;
	
	@RequestMapping("/")
	public String IndexPage(){
		
		return "redirect:/index";
		
	}
	
	
	@RequestMapping("/index")
	public String getIndexPage(HttpServletRequest request,Model model){
		//获取当前的头条 
		Headline headline =noticeService.getHeadLine();
		model.addAttribute("headline", headline);
		
		//左侧导航栏添加 分类信息
		List<Category> categoryList=categoryService.getAllCategory();
		model.addAttribute("categoryList", categoryList);
		
		LinkedHashMap<Integer, List> topMap=topCategoryService.getAllTopMap();
		model.addAttribute("topMap", topMap);
		
		List<Announcement> anno=noticeService.getAnnouncement();
		model.addAttribute("anList", anno);
		//下方添加商品信息
		
		//随机商品 
		List<ProductInfo> randomProducts=productService.randomListProduct(null);	
		LinkedHashMap<String,List<ProductInfo>> map=new LinkedHashMap<String,List<ProductInfo>>();
		map.put("随便看看",randomProducts);
		// 销量Top 10
		List<ProductInfo> sellTopList=productService.getTopTenBySell();
		// 点击Top 10
		List<ProductInfo> clickTopList=productService.getTopTenByClick();
		model.addAttribute("map", map);
		ProductInfo pi=productService.getProductInfoById(1);
		model.addAttribute("productInfo", pi);
		
		//第一部分 今日精品
		LinkedHashMap<String, List> part=new LinkedHashMap<>();
			LinkedHashMap<String, List> leftPart=new LinkedHashMap<>();
			leftPart.put("推荐", productService.randomListProduct(null));
			LinkedHashMap<String, List> rightPart=new LinkedHashMap<>();
			rightPart.put("热销", sellTopList);
		List<Map<String, List>> list=new ArrayList<Map<String, List>>();	
			list.add(leftPart);
			list.add(rightPart);	
		part.put("今日精品", list);
	
		//第二部分 精彩推荐		
			LinkedHashMap<String, List> leftPart2=new LinkedHashMap<>();
			leftPart2.put("推荐", productService.randomListProduct(null));
			LinkedHashMap<String, List> rightPart2=new LinkedHashMap<>();
			rightPart2.put("人气", clickTopList);
			List<Map<String, List>> list2=new ArrayList<Map<String, List>>();	
			list2.add(leftPart2);
			list2.add(rightPart2);	
			part.put("精彩推荐", list2);
			
		
		model.addAttribute("part",part);
		
		//webapp/static/productImgs/1/1.jpg	
		return "front/index/Index";
	}
}
