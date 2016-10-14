package com.latewind.service.impl.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.latewind.common.constants.CommonConstants;
import com.latewind.common.tools.FileUtil;
import com.latewind.common.tools.MathOperation;
import com.latewind.controller.product.ViewProductController;
import com.latewind.dao.category.SubCategoryMapper;
import com.latewind.dao.category.ThirdCategoryMapper;
import com.latewind.dao.product.KeyWordMapper;
import com.latewind.dao.product.ProductImagesMapper;
import com.latewind.dao.product.ProductInfoMapper;
import com.latewind.dao.product.PrtCommentMapper;
import com.latewind.pojo.SubCategory;
import com.latewind.pojo.ThirdCategory;
import com.latewind.pojo.product.ProductImages;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.pojo.product.PrtComment;
import com.latewind.service.product.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Resource
	private ProductInfoMapper productDAO;
	//
	@Resource
	private ProductImagesMapper productImageDAO;

	@Resource
	private ThirdCategoryMapper thirdCategoryDAO;
	
	@Resource
	private KeyWordMapper keyWordDAO;
	
	Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Resource
	private SubCategoryMapper subCategoryDAO;

	@Resource
	private PrtCommentMapper prtCommentDAO;

	@Override
	public ProductInfo getProductInfoById(Integer id) {
				
				return productDAO.selectByPrimaryKey(id);
	}

	@Override
	public void addProductImges(ProductImages productImage) {
				productImageDAO.insertSelective(productImage);

	}

	@Override
	public void addProduct(ProductInfo productInfo) {
		Integer i = productDAO.insertSelective(productInfo);
				logger.info("新增商品" + i + " " + productInfo.getPrtId());
	}

	@Override
	public List<ProductInfo> randomListProduct(Integer thirdId, Integer listNum) {
				List<Integer> prtIdList = productDAO.selectPrtIdByThirdId(thirdId);

		Set<Integer> randomSet = MathOperation.getRandomSequence(prtIdList, listNum);

		return productDAO.selectRandomByList(randomSet, listNum);
	}

	@Override
	public List<ProductInfo> randomListProduct(Integer listNum) {
				if (listNum == null) {
			listNum = CommonConstants.DEFAULT_LIST_NUM;

		}
		List<Integer> prtIdList = productDAO.selectAllPrtId();
		// 获得随机序列
		Set<Integer> randomSet = MathOperation.getRandomSequence(prtIdList, listNum);

		return productDAO.selectRandomByList(randomSet, listNum);
	}
	
	@Override
	public List<ProductInfo> randomListProduct(Set<Integer> randomList,Integer listNum) {
		
		if (listNum == null) {
			listNum = CommonConstants.DEFAULT_LIST_NUM;
		}

		
		//  Auto-generated method stub
		return productDAO.selectRandomByList(randomList, listNum);
	}

	@Override
	public ProductInfo getProductAllInfoById(Integer id) {
		
		System.out.println(productImageDAO.selectByPrimaryKey(1).getImageName()+"get All Info By Product ID ="+id);
		
		logger.info(productImageDAO.selectByPrimaryKey(1).getImageName()+"get All Info By Product ID ="+id);
		
				return productDAO.selectByPrimaryKey2(id);
	}

	@Override
	public List<ProductInfo> listProductBySubId(Integer subId, Integer startPos, Integer listNum) {
		if (listNum == null) {
			listNum = CommonConstants.DEFAULT_LIST_NUM;

		}
		if (startPos == null) {
			startPos = 0;
		}

		SubCategory subCategory = subCategoryDAO.selectByPrimaryKey(subId);

		List<ProductInfo> list = new LinkedList();
		for (ThirdCategory t : subCategory.getThirdCategories()) {

			list.addAll(listProductByThirdId(t.getId(), startPos, listNum));
		}
				return list;
	}

	@Override
	public List<ProductInfo> listProductByThirdId(Integer thirdId, Integer startPos, Integer listNum) {
				if (listNum == null) {
			listNum = CommonConstants.DEFAULT_LIST_NUM;

		}
		if (startPos == null) {
			startPos = 0;
		}
		List<Integer> thirdList = new LinkedList<>();
		thirdList.add(thirdId);

		return productDAO.selectProductByThirdId(thirdList, startPos, listNum, null);
	}

	@Override
	public List<ProductInfo> listProductByThirdId(Integer thirdId, Integer startPos, Integer listNum,
			String orderDesc) {
				if (listNum == null) {
			listNum = CommonConstants.DEFAULT_LIST_NUM;

		}
		if (startPos == null) {
			startPos = 0;
		}
		List<Integer> thirdList = new LinkedList<>();
		thirdList.add(thirdId);

		return productDAO.selectProductByThirdId(thirdList, startPos, listNum, orderDesc);
	}

	@Override
	public void addProduct(String prtName, BigDecimal price, String thirdName, Integer num, String describ, String intro,
			String basePath, CommonsMultipartFile[] picFiles) throws IOException {
		// 获取三级分类ID
		Integer thirdId = thirdCategoryDAO.selectByThirdName(thirdName).getId();
		Integer primImgId = null;
		// 创建商品类 primaryImge 先暂时为NULL
		ProductInfo productInfo = new ProductInfo(prtName, describ, thirdId, price, num, 0, 0, new Date(), 0, primImgId,
				intro);
		// 保存到数据库，并得到自动增长后的商品ID
		productDAO.insertSelective(productInfo);
		Integer prtId = productInfo.getPrtId();
		// 图片保存路径
		String dirsPath = basePath + prtId;
		// 生成子文件夹
		File dirs = new File(dirsPath);
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
		byte[] buf = new byte[1024];
		for (int i = 1; i <= picFiles.length; i++) {
//			System.out.println("fileName---------->" + picFiles[i - 1].getOriginalFilename());
			InputStream io = picFiles[i - 1].getInputStream();
//			获取文件后缀
			System.out.println(picFiles[i-1].getName());
			String suffix=FileUtil.getFileSuffix(picFiles[i-1].getName());
			String name=UUID.randomUUID().toString();
			FileOutputStream os = new FileOutputStream(dirsPath + "/" + name + suffix);
			while (io.read(buf) != -1) {
				os.write(buf);
			}
			// 图片储存名称: 产品ID/X.jpg
			String imageName = prtId + "/" + name + ".jpg";
			ProductImages productImage = new ProductImages(imageName, prtId);
			// 保存到数据库
			productImageDAO.insertSelective(productImage);
			if (i == 1) {
				// 第一张图片的id作为主要id
				primImgId = productImage.getImageId();
			}
			os.flush();
			os.close();
			io.close();
		}
		// 设置主要图片id 更新
		productInfo.setPrimImgId(primImgId);
		productDAO.updateByPrimaryKeySelective(productInfo);
		logger.info(basePath);
	}
/**
 * 更新商品及图片
 * @param prtId
 * @param prtName
 * @param price
 * @param thirdName
 * @param num
 * @param describ
 * @param intro
 * @param basePath
 * @param picFiles
 * @throws IOException
 */
	public void updateProduct(Integer prtId, String prtName, BigDecimal price,String thirdName, Integer num, String describ,
			String intro, String basePath, CommonsMultipartFile[] picFiles) throws IOException {
		Integer thirdId = thirdCategoryDAO.selectByThirdName(thirdName).getId();
		// 更新数据
		ProductInfo pInfo = this.getProductAllInfoById(prtId);
		pInfo.setPrtName(prtName);
		pInfo.setPrice(price);
		pInfo.setNum(num);
		pInfo.setDescrib(describ);
		pInfo.setIntro(intro);
		pInfo.setThirdId(thirdId);
		productDAO.updateByPrimaryKeySelective(pInfo);
		// 获取图片
		List<ProductImages> images = pInfo.getImages();
		Iterator<ProductImages> i = images.iterator();
		if(picFiles[0].isEmpty()){ 
			logger.info("is empty");	
			return;
		}
		byte[] buf = new byte[1024];
		for (CommonsMultipartFile f : picFiles) {
			System.out.println("fieldName:"+f.getFileItem().getFieldName());
			System.out.println("contentType:"+f.getFileItem().getContentType());
			System.out.println("name:"+f.getFileItem().getName());
			
			if(!i.hasNext()){
				break;
			}
			String path = basePath + "/" + i.next().getImageName();
			InputStream is = f.getInputStream();
//			System.out.println(is.);
			FileOutputStream fos = new FileOutputStream(path);
			while (is.read(buf) != -1) {
				fos.write(buf);
			}
			logger.info("execute this");
			fos.flush();
			fos.close();
			is.close();
		}
	}

	@Override
	public Boolean updateClickCount(Integer prtId) {
		Integer num = productDAO.updateClickCount(prtId);
				if (num < 1) {
			return false;
		} else {
			return true;
		}
	}

	public void test() {

		List<Integer> list = productDAO.selectAllPrtId();
		for (int i : list) {

			System.out.println(i);
		}

	}

	@Override
	public List<ProductInfo> getTopTenBySell() {
				return productDAO.selectBySellTopTen();
	}

	@Override
	public List<ProductInfo> getTopTenByClick() {
				return productDAO.selectByClickTopTen();
	}

	@Override
	public List<PrtComment> listPrtCommentByPrtId(Integer prtId, Integer startPos, Integer step) {
				if (step == null) {
			step = CommonConstants.DEFAULT_LIST_NUM;
		}
		if (startPos == null) {
			startPos = 0;
		}

		return prtCommentDAO.selectByPrtId(prtId, startPos, step);
	}

	@Override
	public List<ProductInfo> listAllProductMini() {
				return productDAO.selectAllPrtMini();
	}

	@Override
	public Set<Integer> listPrtByKeyWord(Set<String> keywordSet) {
		//  Auto-generated method stub
		return keyWordDAO.selectByKeyWord(keywordSet);
	}

	

	

}
