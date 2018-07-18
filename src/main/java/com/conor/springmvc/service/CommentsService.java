package com.conor.springmvc.service;

import java.util.List;

import com.conor.springmvc.model.Comments;

public interface CommentsService {

	List<Comments> findAllComments();
	
	List<Comments> findAllModComments();

	void saveComments(Comments comments);
	
	Comments findById(int id);
	
	void updateComments(Comments comments);	
	
	void deleteCommentById(int id);
}
