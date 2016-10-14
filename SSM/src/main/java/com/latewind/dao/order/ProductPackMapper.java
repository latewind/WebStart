package com.latewind.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.order.ProductPack;

public interface ProductPackMapper {
	int deleteByPrimaryKey(Integer cartProductId);

	int insert(ProductPack record);

	int insertSelective(ProductPack record);

	ProductPack selectByPrimaryKey(Integer cartProductId);

	ProductPack selectByCartIdAndPrtId(@Param("cartId") Integer cartId, @Param("prtId") Integer prtId);

	int updateByPrimaryKeySelective(ProductPack record);

	int updateByPrimaryKey(ProductPack record);
	
	int updateToOrder(@Param("orderId") Integer orderId,@Param("packIdList") List<Integer> packIdList);
	
	
	ProductPack selectTest(Integer cartId);
	
	List<ProductPack> selectByOrderId(Integer orderId);
	
	
}