package com.latewind.service;

import com.latewind.bean.UserInfo;

public interface UserInfoService {
public String isRight(String userName,String password);
public Boolean addUser(UserInfo u);
public UserInfo findUser(String chn);
public UserInfo findUserById(int id);
public UserInfo findByAccount(String account);
}
