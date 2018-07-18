package com.conor.springmvc.dao;

import java.util.List;

import com.conor.springmvc.model.Comments;

public interface CommentsDao {
	
	List<Comments> findAllComments();
	
	List<Comments> findAllModComments();

	void saveComments(Comments comments);
	
	Comments findById(int id);
	
	void deleteById(int id);
	
}
