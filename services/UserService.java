package com.services;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.user.User;
import com.userdao.UserDao;
import com.util.HibernateUtil;

public class UserService implements UserDao{

	@Override
	public boolean login(User user) {
		Session session = HibernateUtil.getSession();
		boolean userFound = false;
		
		String sql = "from User as o where o.email=? and o.password=?";
		Query query = session.createQuery(sql);
		query.setParameter(0, user.getEmail());
		query.setParameter(1, user.getPassword());
		List list = query.list();
		System.out.println(list.size());
		if((list!=null)&&(list.size()>0)) {
			userFound=true;
		}
		
		session.close();
		return userFound;
	}


	@Override
	public void Registration(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		System.out.println("user is added");
		
	}

}
