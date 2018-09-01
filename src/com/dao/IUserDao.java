package com.dao;

import java.util.List;

import com.entity.User;


public interface IUserDao {
      public int insert(User user);
      public int update(User user);
      public int delete(User user);
      public User queryById(int id); 
      public User queryByName(String name);
      List<User> queryExceptName(String name);
      List<User> queryAllUser(); 
}
