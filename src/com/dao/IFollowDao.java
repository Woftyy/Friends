package com.dao;

import com.entity.Follow;

public interface IFollowDao {

	public int insert(Follow follow);
	public int update(Follow follow);
	public int CancelFollow(Follow follow);
}
