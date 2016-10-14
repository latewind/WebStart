package com.latewind.service.order;

import java.util.List;

import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.OrderPageInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.order.ShoppingCart;

public interface IOrderService {
	
	public ShoppingCart getCartByUserId(Integer userId);
	
	public OrderInfo getOrderInfoByOrderId(Integer orderId);
	
	public Boolean appendProductPack(Integer userId,Integer prtId,Integer count);
	
	public Boolean deleteProductPack(Integer prtPackId);
	
//	public List<ProductPack> test(Integer orderId);
	public ProductPack getProductPackById(Integer id);
	
	
	public List<OrderInfo> getOrdersByUserIdBase(Integer userId);
	

	Integer addOrder(OrderPageInfo json,Integer userId);
	

	Integer updateOrderStatus(Integer orderId, String osderStatus);
	
	//更新产品包
	Integer updateProductPack(ProductPack pack);
	
	Boolean updateProductWhenPayfor(Integer orderId);
	
	
}
