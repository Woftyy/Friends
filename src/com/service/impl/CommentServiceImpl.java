package com.service.impl;

import com.dao.ICommentDao;
import com.dao.impl.CommentDaoImpl;
import com.entity.Comment;
import com.service.ICommentService;

public class CommentServiceImpl implements ICommentService{

	ICommentDao iCommentDao = new CommentDaoImpl();
	Comment comment =new Comment();
	@Override
	public void insertComment(Long mid, int uid, String content) {
		// TODO Auto-generated method stub
		comment.setMid(mid);
		comment.setUser_id(uid);
		comment.setContent(content);
		iCommentDao.insert(comment);
		System.out.println("插入评论成功！");
	}

}
