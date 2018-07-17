package com.conor.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.conor.springmvc.model.Comments;

@Repository("commentsDao")
public class CommentsDaoImpl extends AbstractDao<Integer, Comments> implements CommentsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> findAllComments() {
		Criteria criteria = createEntityCriteria().add(Restrictions.ne("moderated", "n"));
		return (List<Comments>) criteria.list();
	}
	
	public void saveComments(Comments comments) {
		persist(comments);
	}

}
