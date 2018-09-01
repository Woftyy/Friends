package com.service;

import com.entity.User;

public interface IUserService {
     Boolean IsUserExist(String name);
	 void insertUser(String name,String email,String password,String sex);
	 Boolean IsPassWordRight(String name,String password);
}
