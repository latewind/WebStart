package com.latewind.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latewind.pojo.order.OrderInfo;

public interface OrderInfoMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	OrderInfo selectByPrimaryKey(Integer orderId);

	/**
	 * 根据user_Id 查找订单 只包含Order基础数据
	 * 
	 * @param userId
	 * @return
	 */
	List<OrderInfo> selectByUserIdBase(Integer userId);

	Integer selectOrderCountByUserId(@Param("userId")Integer userId,@Param("orderStatus")String orderStatus);
	/**
	 * 分页查找 STEP 1
	 * @param userId
	 * @param startPos
	 * @param step
	 * @return
	 */
    List<Integer> selectOrderIdByUserId(@Param("userId")Integer userId,@Param("startPos")Integer startPos
    		,@Param("step")Integer step,@Param("orderStatus")String orderStatus);
    /**
     * 分页查找 STEP 2
     * @param orderIdList
     * @return
     */
    List<OrderInfo> selectOrdersByOrderIdList(@Param("orderIdList") List<Integer>orderIdList);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);

	Integer updateOrderStatus(@Param("orderId") Integer orderId, @Param("orderStatus") String orderStatus);
}