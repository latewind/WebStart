package com.latewind.service.user;

import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.LoginMessage;
import com.latewind.pojo.user.UserInfo;

public interface IUserInfoService {
	
	public LoginInfo verifyUserName(String userName,String password);
	
	public Integer addUser(String userName,String oncePassword);
		
	public UserInfo getUserInfo(Integer userId);


}
