package com.service;

import com.entity.Comment;

public interface ICommentService {

	void insertComment(Long mid, int uid, String content);
}
