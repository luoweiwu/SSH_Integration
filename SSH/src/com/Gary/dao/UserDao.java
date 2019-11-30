package com.Gary.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.Gary.domain.User;

public class UserDao extends HibernateDaoSupport {

	public User findUser(User user) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		String sql = "select * from user where username = ? and password = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1,user.getUsername());
		query.setParameter(2, user.getPassword());
		query.addEntity(User.class);
		
		User result = (User) query.uniqueResult();
		
		return result;
	}

}
