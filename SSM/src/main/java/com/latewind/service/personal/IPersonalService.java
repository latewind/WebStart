package com.latewind.service.personal;

import java.util.List;

import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.product.PrtComment;
import com.latewind.pojo.user.UserInfo;

public interface IPersonalService {
	/**
	 * 根据用户id  订单状态（1,2,3） 每页显示数目获取总订单数目
	 * @param userId
	 * @param startPos
	 * @param step
	 * @param orderStatus
	 * @return
	 */
	List<OrderInfo> getOrderByUserId(Integer userId,Integer startPos,Integer step,String orderStatus);
	/**
	 * 根据用户id  订单状态（1,2,3）获取总订单数目
	 * @param userId ordeStatus
	 * @return
	 */
	Integer getOrderCountByUserId(Integer userId,String orderStatus);
	
	
	Integer updatePersonalInfo(UserInfo u);
	
	
	/*================================评论相关========================*/
	PrtComment getCommentById(Integer commentId);
	
	Integer addPrtComment(PrtComment prtComment,ProductPack pack);
	
	Integer updatePrtComment(PrtComment prtComment);
	
	
	
//	public ProductPack getProductPackById(Integer id);
}
