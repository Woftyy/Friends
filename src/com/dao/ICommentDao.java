package com.dao;

import java.util.List;

import com.entity.Comment;
import com.entity.Moment;

public interface ICommentDao {
	 public int insert(Comment comment);
     public int update(Comment comment);
     public int delete(Comment comment);
     List<Comment> queryByMid(Long mid);
}
