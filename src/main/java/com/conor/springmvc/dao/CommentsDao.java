package com.conor.springmvc.dao;

import java.util.List;

import com.conor.springmvc.model.Comments;

public interface CommentsDao {
	
	List<Comments> findAllComments();

	void saveComments(Comments comments);
}
