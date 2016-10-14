package com.latewind.service;

import java.util.List;

import com.latewind.pojo.User;

public interface IUserService {
  public User getUserById(int userId);
  public List<User> getAllUser();
}
