package com.latewind.dao;

import java.util.List;

import com.latewind.bean.UserInfo;

public interface UserInfoDAO {
	public Boolean save(UserInfo userInfo);
	public UserInfo findUser(String userName);
	public UserInfo findUserByCHN(String chn);
	public UserInfo findUserById(int id);
	public List<UserInfo> listAll();
}
