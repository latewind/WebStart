package com.latewind.service.impl.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.latewind.common.constants.CommonConstants;
import com.latewind.dao.order.OrderInfoMapper;
import com.latewind.dao.order.ProductPackMapper;
import com.latewind.dao.order.ShoppingCartMapper;
import com.latewind.dao.product.ProductInfoMapper;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.OrderPageInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.order.ShoppingCart;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.service.order.IOrderService;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	Logger logger = Logger.getLogger(OrderServiceImpl.class);
	@Resource
	private ShoppingCartMapper shoppingCartDAO;

	@Resource
	private ProductPackMapper productPackDAO;

	@Resource
	private OrderInfoMapper orderInfoDAO;
	
	@Resource
	private ProductInfoMapper productInfoDAO;

	@Override
	public ShoppingCart getCartByUserId(Integer userId) {
		ShoppingCart shoppingCart = shoppingCartDAO.selectByUserName(userId);

		// System.out.println(shoppingCart.getProductPacks());

		// productPackDAO.selectByPrimaryKey(1);
		// ProductPack pack=productPackDAO.selectTest(1);
		// String isdf=pack.getProductInfo().getPrimImage().getImageName();
		//
		// System.out.println(isdf);
		return shoppingCart;
	}

	@Override
	public Boolean appendProductPack(Integer userId, Integer prtId, Integer count) {
		// 获取 根据 用户名获取购物车ID
		ShoppingCart sc = shoppingCartDAO.selectByUserNameBase(userId);

		Integer cartId = sc.getCartId();

		logger.info(cartId);
		// 获取产品包
		ProductPack pp = productPackDAO.selectByCartIdAndPrtId(cartId, prtId);
		// 空 insert 操作
		if (pp == null) {
			logger.info("购物车新增一个包");
			pp = new ProductPack(cartId, prtId, 1);
			productPackDAO.insertSelective(pp);
		} else {
			// 不为空 更新操作
			logger.info("更新购物车商品包数量");
			Integer oldCount = pp.getQuantity();
			pp.setQuantity(oldCount + count);
			productPackDAO.updateByPrimaryKeySelective(pp);
		}

		return true;
	}

	@Override
	public Boolean deleteProductPack(Integer prtPackId) {
		productPackDAO.deleteByPrimaryKey(prtPackId);
		return true;
	}

	@Override
	public List<OrderInfo> getOrdersByUserIdBase(Integer userId) {
		return orderInfoDAO.selectByUserIdBase(userId);
	}

	@Override
	public Integer addOrder(OrderPageInfo json, Integer userId) {

		// OrderInfo orderInfo=new OrderInfo();
		List<Integer> packIdList = json.getPackId();
		OrderInfo orderInfo = new OrderInfo(userId, json.getName(), json.getContact(), json.getAddress(),
				CommonConstants.UN_PAY_FOR, json.getPayMethod(), json.getDelivery(), packIdList.size(), new Date());

		// 数据库建立订单
		orderInfoDAO.insertSelective(orderInfo);
		// 返回订单id
		Integer orderId = orderInfo.getOrderId();
		logger.info("orderId" + orderId);
		// 将 pack 移到订单中
		productPackDAO.updateToOrder(orderId, packIdList);
		return orderId;
	}

	@Override
	public Integer updateOrderStatus(Integer orderId, String osderStatus) {
		orderInfoDAO.updateOrderStatus(orderId, osderStatus);
		return orderId;
	}

	@Override
	public ProductPack getProductPackById(Integer id) {
		return productPackDAO.selectByPrimaryKey(id);
	}

	@Override
	public OrderInfo getOrderInfoByOrderId(Integer orderId) {
		// Auto-generated method stub
		List<Integer> orderIdList = new LinkedList<Integer>();
		orderIdList.add(orderId);
		OrderInfo orderInfo = orderInfoDAO.selectOrdersByOrderIdList(orderIdList).get(0);

		return orderInfo;
	}

	@Override
	public Integer updateProductPack(ProductPack pack) {
		//  Auto-generated method stub
		return productPackDAO.updateByPrimaryKeySelective(pack);
	}

	@Override
	public Boolean updateProductWhenPayfor(Integer orderId) {
		//  Auto-generated method stub
		

		this.updateOrderStatus(orderId, CommonConstants.PAY_FOR_SUCCESS);
		OrderInfo orderInfo=this.getOrderInfoByOrderId(orderId);
		BigDecimal total=new BigDecimal(0);
		for(ProductPack packs:orderInfo.getProductPacks()){
			ProductInfo productInfo=packs.getProductInfo();
			Integer prtId=productInfo.getPrtId();
			//更新库存量 如果更新失败，说明库存没有了，直接返回
			if(productInfoDAO.updateStockMinus(prtId, 1)<1){
				
				return false;
			}
			System.out.println(productInfo);
			//更新销售数量
			productInfoDAO.updateSellCountPlus(prtId, 1);
			//更新交易价格
			packs.setDealPrice(productInfo.getPrice());
			productPackDAO.updateByPrimaryKeySelective(packs);
			BigDecimal quantity=new BigDecimal(packs.getQuantity());
			BigDecimal totalPrice=quantity.multiply(packs.getDealPrice());
			
			total=total.add(totalPrice);
		}
		System.out.println(total);
		//更新总价
		orderInfo.setTotalPrice(total);
		orderInfoDAO.updateByPrimaryKeySelective(orderInfo);
		
		return true;
	}

}
