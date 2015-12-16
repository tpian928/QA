package com.freeplay.qa.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.freeplay.qa.pojo.User;
import com.freeplay.qa.util.HibernateSessionFactory;
import com.freeplay.qa.util.Tools;

/**
 * Operations of User
 * @author chris
 *
 */
public class UserDao {
	
	/**
	 * Insert a new record into the User table
	 * and we need a system time.
	 * @param username User's name
	 * @param password User's password
	 * @return true: success; false: fail
	 */
	public static boolean insert(String username,String password)
	{
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setCreateDate(Tools.getSystemDate());
			u.setLastDate(Tools.getSystemDate());
			
			session.save(u);
			transaction.commit();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			HibernateSessionFactory.closeSession();
			return false;
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return true;
	}
	
	/**
	 * Check whether the user exists.
	 * @param username
	 * @param password
	 * @return true: exist; false: not exist
	 */
	public static boolean check(String username,String password)
	{
		Session session = null;
		List<User> list = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("username", username));
			c.add(Restrictions.eq("password",password));
			list = c.list();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return (list.size() == 0)?false:true;
	}
	
	/**
	 * Get the certain user's information
	 * @param username
	 * @return
	 */
	public static User getUser(String username)
	{
		User user = null;
		Session session = null;
		List<User> list = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(User.class);
			c.add(Restrictions.eq("username", username));
			list = c.list();
			user = list.get(0);
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return user;
	}
	
	public static void main(String[] args)
	{
		System.out.println(UserDao.check("chris", "ldh"));
	}
}
