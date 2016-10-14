package com.latewind.service.impl.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.common.tools.PassKeyEncoder;
import com.latewind.common.tools.SecurityOperator;
import com.latewind.dao.order.ShoppingCartMapper;
import com.latewind.dao.user.UserInfoMapper;
import com.latewind.pojo.order.ShoppingCart;
import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.LoginMessage;
import com.latewind.pojo.user.UserInfo;
import com.latewind.service.user.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	@Resource
	private UserInfoMapper userInfoDAO;
	
	@Resource
	private ShoppingCartMapper shoppingCartDAO;
	
	@Override
	public LoginInfo verifyUserName(String userName, String password) {
				// 加盐
		password = SecurityOperator.saltingPassword(password);
		// 从DB 获取数据
		UserInfo userInfo = userInfoDAO.selectByUserName(userName);
		LoginInfo loginInfo = new LoginInfo();
		
		// 用户不存在或者密码错误p
		if (userInfo == null || !PassKeyEncoder.encodePassword(userInfo.getSalt(), password, "MD5").equals(userInfo.getPassword())) {
			
			
			loginInfo.setAlertMsg("用户或密码错误");
			loginInfo.setSuccess(false);
			return loginInfo;
		}
		System.out.println(userInfo.getSalt());
		System.out.println(PassKeyEncoder.encodePassword(userInfo.getSalt(), password, "MD5"));
		System.out.println(userInfo.getPassword());
		loginInfo.setSalt(userInfo.getSalt());
		System.out.println(loginInfo.getSalt()+"salt");
		loginInfo.setUserId(userInfo.getUserId());
		loginInfo.setNickName(userInfo.getNickname());
		loginInfo.setAlertMsg("登录成功");
		loginInfo.setSuccess(true);
		return loginInfo;
	}

	@Override
	public UserInfo getUserInfo(Integer userId) {
				return userInfoDAO.selectByPrimaryKey(userId);
	}

	@Override
	public Integer addUser(String userName, String oncePassword) {
		
		//TODO 申请验证
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(userName);
		String salt=PassKeyEncoder.generateSalt();
		String password=PassKeyEncoder.encodePassword(salt, oncePassword, "MD5");
		userInfo.setPassword(password);
		userInfo.setSalt(salt);
		ShoppingCart cart=new ShoppingCart();
//新增用户		
		userInfoDAO.insertSelective(userInfo);
		//为用户新增购物车
		cart.setUserId(userInfo.getUserId());
		return shoppingCartDAO.insertSelective(cart);
	}

}
