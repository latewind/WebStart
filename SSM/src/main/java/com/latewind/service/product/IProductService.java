package com.latewind.service.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.latewind.pojo.product.ProductImages;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.pojo.product.PrtComment;

public interface IProductService {
	public ProductInfo getProductInfoById(Integer id);

	/**
	 * 获取商品的全部信息
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value = "myCache",key="#id",condition = "#id<10")
	public ProductInfo getProductAllInfoById(Integer id);

	public void addProductImges(ProductImages productImage);

	/**
	 * 添加商品
	 * 
	 * @param productInfo
	 */
	public void addProduct(ProductInfo productInfo);

	public void addProduct(String prtName, BigDecimal price, String thirdName, Integer num, String describ, String intro,
			String basePath, CommonsMultipartFile[] files) throws IOException;
	
	public void updateProduct(Integer prtId, String prtName,BigDecimal price, String thirdName, Integer num, String describ,
			String intro, String basePath, CommonsMultipartFile[] picFiles) throws IOException;

	/**
	 * 随机选择
	 * 
	 * @param listNum
	 * @return
	 */
	public List<ProductInfo> randomListProduct(Integer listNum);
	
	public List<ProductInfo> randomListProduct(Set<Integer> prtIdSet,Integer listNum);
	
	public List<ProductInfo> randomListProduct(Integer thirdId,Integer listNum);

	public List<ProductInfo> listProductByThirdId(Integer thirdId, Integer startPos, Integer listNum);
	
	public List<ProductInfo> listProductByThirdId(Integer thirdId, Integer startPos, Integer listNum,String orderDesc);

	public List<ProductInfo> listProductBySubId(Integer subId, Integer startPos, Integer listNum);
	
	public List<ProductInfo> listAllProductMini();
	
	

	public Boolean updateClickCount(Integer prtId);

	public List<ProductInfo> getTopTenBySell();

	public List<ProductInfo> getTopTenByClick();

	public void test();

	public List<PrtComment> listPrtCommentByPrtId(Integer prtId,Integer startPos,Integer step);
	
	
	public Set<Integer> listPrtByKeyWord(Set<String> keywordSet);


}

