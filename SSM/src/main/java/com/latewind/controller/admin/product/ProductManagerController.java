package com.latewind.controller.admin.product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.latewind.common.constants.CommonConstants;
import com.latewind.pojo.ThirdCategory;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.category.IThirdCategoryService;
import com.latewind.service.product.IProductService;

@Controller
public class ProductManagerController {

	@Resource
	private IProductService productService;

	@Resource
	private IThirdCategoryService thirdCategoryService;
	
	Logger logger = Logger.getLogger(ProductManagerController.class);

	/**
	 * 前往addProduct页面
	 * 
	 * @param model
	 * @return
	 */

	@RequestMapping("/admin/product/addProduct")
	public String addProductPage(Model model) {
		// 设置页面Page 数据
		// 添加三级分类 用于页面下拉 显示分类名
		List<ThirdCategory> thirds = thirdCategoryService.getAllThird();
		model.addAttribute("thirds", thirds);
		logger.info("addProcutPage");
		return "admin/product/addProduct";
	}

	/**
	 * 提交增加商品表单Action 增加商品
	 * 
	 * @param request
	 * @param picFiles
	 * @param prtName
	 * @param price
	 * @param thirdName
	 * @param num
	 * @param describ
	 * @param intro
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/admin/product/addProductAction")
	public String addProduct(HttpServletRequest request, @RequestParam("picFiles") CommonsMultipartFile[] picFiles,
			String prtName, BigDecimal price, String thirdName, Integer num, String describ, String intro)
					throws IOException {
		// 获取路径
		String basePath = request.getServletContext().getRealPath("/") + CommonConstants.PRODUCT_IMG_PATH;
		productService.addProduct(prtName, price, thirdName, num, describ, intro, basePath, picFiles);
		logger.info(prtName + price + num + thirdName + describ + intro);
		logger.info("addProcut");
		return "redirect:/admin/product/addProduct";
	}

	/**
	 * 更新商品页面
	 * 
	 * @param model
	 * @param prtId
	 * @return
	 */
	@RequestMapping("/admin/product/updateProduct.html")
	public String updateProduct(Model model, Integer prtId) {
		
		try {
			if (prtId == null) {
				
				return "admin/product/updateProduct";
			}
			// 商品信息输出到页面
			ProductInfo pInfo = productService.getProductAllInfoById(prtId);
			// 分类设置
			
			List<ThirdCategory> thirds = thirdCategoryService.getAllThird();
			
			String thirdName = thirdCategoryService.geThirdCategoryById(pInfo.getThirdId()).getName();
			
			//
			model.addAttribute("thirds", thirds);
			model.addAttribute("productInfo", pInfo);
			model.addAttribute("thirdName", thirdName);
			
		} catch (Exception e) {
			return "admin/product/updateProduct";
			// TODO: handle exception
		}
		return "admin/product/updateProduct";
	}

	@RequestMapping("/admin/product/updateProductAction")
	public String updateProductAction(HttpServletRequest request,
			@RequestParam("picFiles") CommonsMultipartFile[] picFiles, Integer prtId,String thirdName,String prtName, BigDecimal price,
			 Integer num, String describ, String intro) {
		String basePath = request.getServletContext().getRealPath("/") + CommonConstants.PRODUCT_IMG_PATH;
		logger.info("update Product" + prtId);
		try {
			productService.updateProduct(prtId, prtName, price,thirdName, num, describ, intro, basePath, picFiles);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return "redirect:/admin/product/updateProduct.html";
	}

	@RequestMapping("/admin/product/listProduct.html")
	public String listProduct(Model model) {
		List<ProductInfo> prts = productService.listAllProductMini();
		logger.info(prts.size() + "table size");

		model.addAttribute("listPrt", prts);
		return "admin/product/listProduct";
	}

}
