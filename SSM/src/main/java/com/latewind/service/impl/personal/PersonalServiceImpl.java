package com.latewind.service.impl.personal;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.order.OrderInfoMapper;
import com.latewind.dao.order.ProductPackMapper;
import com.latewind.dao.product.PrtCommentMapper;
import com.latewind.dao.user.UserInfoMapper;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.order.ProductPack;
import com.latewind.pojo.product.PrtComment;
import com.latewind.pojo.user.UserInfo;
import com.latewind.service.personal.IPersonalService;

@Service("personalService")
public class PersonalServiceImpl implements IPersonalService{
	@Resource
	private OrderInfoMapper orderInfoDAO;
	
	@Resource
	private UserInfoMapper userInfoDAO;
	
	@Resource
	private ProductPackMapper productPackDAO;
	
	@Resource
	private PrtCommentMapper prtCommentDAO;
	
	@Override
	public List<OrderInfo> getOrderByUserId(Integer userId, Integer startPos, Integer step,String orderStatus) {
				List<Integer> orderIdList=orderInfoDAO.selectOrderIdByUserId(userId, startPos, step,orderStatus);
	
		return 	orderInfoDAO.selectOrdersByOrderIdList(orderIdList);
	}
	@Override
	public Integer getOrderCountByUserId(Integer userId,String orderStatus) {
				return orderInfoDAO.selectOrderCountByUserId(userId,orderStatus);
	}
	@Override
	public Integer updatePersonalInfo(UserInfo u) {
				return userInfoDAO.updateByPrimaryKeySelective(u);
	}
	@Override
	public PrtComment getCommentById(Integer commentId) {
				return prtCommentDAO.selectByPrimaryKey(commentId);
	}
	@Override
	public Integer addPrtComment(PrtComment prtComment,ProductPack pack) {
				prtCommentDAO.insertSelective(prtComment);
		System.out.println(prtComment.getCommentId()+"insert after ");
		pack.setCommentId(prtComment.getCommentId());
		productPackDAO.updateByPrimaryKeySelective(pack);
		return null;
		
		
		
	}
	@Override
	public Integer updatePrtComment(PrtComment prtComment) {
				return prtCommentDAO.updateByPrimaryKeySelective(prtComment);
	}
	
//	@Override
//	public ProductPack getProductPackById(Integer id) {
//		//		return productPackDAO.selectByPrimaryKey(id);
//	}

}
