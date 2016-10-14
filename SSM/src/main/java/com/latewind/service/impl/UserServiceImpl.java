package com.latewind.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.latewind.dao.UserMapper;
import com.latewind.pojo.User;
import com.latewind.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
  @Resource
  private UserMapper userDao;
  @Override
  public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
  }
@Override
public List<User> getAllUser() {
		return userDao.getAll();
}

}