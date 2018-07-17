package com.conor.springmvc.service;

import java.util.List;

import com.conor.springmvc.model.Comments;

public interface CommentsService {

	List<Comments> findAllComments();

	void saveComments(Comments comments);
	
}
