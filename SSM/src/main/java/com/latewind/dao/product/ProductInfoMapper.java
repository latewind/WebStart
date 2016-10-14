package com.latewind.dao.product;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.product.ProductInfo;

public interface ProductInfoMapper {
	int deleteByPrimaryKey(Integer prtId);

	int insert(ProductInfo record);

	int insertSelective(ProductInfo record);

	/**
	 * 返回的产品只包含主要图片
	 * 
	 * @param prtId
	 * @return
	 */
	ProductInfo selectByPrimaryKey(Integer prtId);

	/**
	 * 返回的产品包含所有图片
	 * 
	 * @param prtId
	 * @return
	 */
	ProductInfo selectByPrimaryKey2(Integer prtId);

	List<ProductInfo> selectRandomByList(@Param("randomSet") Set<Integer> randomList,
			@Param("listNum") Integer listNum);

	/**
	 * 根据三级分类，查找所属产品
	 * 
	 * @param third
	 *            startId listNum
	 * @return
	 */
//	List<ProductInfo> selectProductByThirdId(@Param("thirdList") List thirdList, @Param("startPos") Integer startId,
//			@Param("listNum") Integer listNum);

	/**
	 * 根据三级分类，查找所属产品 排列顺序 按照'click' ''
	 * 
	 * @param third
	 *            startId listNum
	 * @return
	 */
	List<ProductInfo> selectProductByThirdId(@Param("thirdList") List thirdList, @Param("startPos") Integer startId,

			@Param("listNum") Integer listNum, @Param("orderDesc") String orderDesc);

	/**
	 * 根据三级分类查找所属产品所有ID
	 * 
	 * @param thirdId
	 * @return
	 */
	List<Integer> selectPrtIdByThirdId(Integer thirdId);

	/**
	 * 获取所有产品Id
	 * 
	 * @return
	 */
	List<Integer> selectAllPrtId();
	/**
	 * 获取所有产品 Mini 包含基础数据 ，不含图片，用于显示表格
	 * @return
	 */
	List<ProductInfo> selectAllPrtMini();

	List<ProductInfo> selectBySellTopTen();

	List<ProductInfo> selectByClickTopTen();

	int updateByPrimaryKeySelective(ProductInfo record);

	int updateByPrimaryKeyWithBLOBs(ProductInfo record);

	int updateByPrimaryKey(ProductInfo record);

	// 更新点击量
	int updateClickCount(Integer prtId);

	// 更新销售数量
	int updateSellCountPlus(@Param("prtId") Integer prtId, @Param("count") Integer count);

	/**
	 * 更新库存 ++
	 * 
	 * @param prtId
	 * @param count
	 * @return
	 */
	int updateStockPlus(@Param("prtId") Integer prtId, @Param("count") Integer count);

	/**
	 * //更新库存--
	 * 
	 * @param prtId
	 * @param count
	 * @return
	 */
	int updateStockMinus(@Param("prtId") Integer prtId, @Param("count") Integer count);

}