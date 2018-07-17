package com.conor.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conor.springmvc.dao.CommentsDao;
import com.conor.springmvc.dao.TeamsDao;
import com.conor.springmvc.model.Comments;
import com.conor.springmvc.model.Teams;

@Service("CommentsService")
@Transactional
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsDao dao;

	@Override
	public List<Comments> findAllComments() {
		return dao.findAllComments();
	}

	@Override
	public void saveComments(Comments comments) {
		dao.saveComments(comments);
	}	
}
