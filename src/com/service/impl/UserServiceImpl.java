package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.IUserService;

public class UserServiceImpl implements IUserService{

	IUserDao iUserDao= new UserDaoImpl();
	List<User> users= new ArrayList<>();
	public Boolean IsUserExist(String name) {
		// TODO Auto-generated method stub
		if (iUserDao.queryByName(name) != null) {//user����
	System.out.println("user����");
			 return true;//user���ڷ���true
		}else {
			System.out.println("user������");
			 return false;//�����ڷ���false
		}
	}
	
	
	@Override
	public void insertUser(String name, String email, String password, String sex) {
		// TODO Auto-generated method stub
		
		User user = new User();
		 user.setEmail(email);
		 user.setPassword(password);
		 user.setUsername(name);
		 user.setSex(sex);
		 iUserDao.insert(user);
	}


	@Override
	public Boolean IsPassWordRight(String name, String password) {
		// TODO Auto-generated method stub
		User user =iUserDao.queryByName(name);
		if (user.getPassword().equals(password)) {
			return true;//������ȷ����true
		}
		return false;
	}

	

	
}
