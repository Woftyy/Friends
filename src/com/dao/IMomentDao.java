package com.dao;

import java.util.List;

import com.entity.Moment;
import com.entity.User;

public interface IMomentDao {
	 public int insert(Moment moment);
     public int update(Moment moment);
     public int delete(Moment moment);
     List<Moment> queryAllMoment(); 
     List<Moment> queryByUid(int uid);
}
