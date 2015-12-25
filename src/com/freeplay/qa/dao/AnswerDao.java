package com.freeplay.qa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.freeplay.qa.pojo.Answer;
import com.freeplay.qa.util.HibernateSessionFactory;
import com.freeplay.qa.util.Tools;

public class AnswerDao {

	/**
	 * Insert a new answer record into the table Answer;
	 * 
	 * @param uid
	 * @param qid
	 * @param acontent
	 * @return
	 */
	public static boolean insert(int uid, int qid, String acontent) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			Answer a = new Answer();
			a.setQid(qid);
			a.setUid(uid);
			a.setAcontent(acontent);
			a.setAtime(Tools.getSystemDate());

			session.save(a);
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			HibernateSessionFactory.closeSession();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return true;
	}

	/**
	 * Delete the record by the id of answer
	 * 
	 * @param aid
	 * @return
	 */
	public static boolean delete(int aid) {
		Session session = null;
		Answer a = getAnswer(aid);
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(a);
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return true;
	}

	/**
	 * Get the information of answer by id.
	 * 
	 * @param aid
	 * @return The class of Answer
	 */
	public static Answer getAnswer(int aid) {
		Answer a = null;
		Session session = null;
		List<Answer> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Answer.class);
			c.add(Restrictions.eq("aid", aid));
			list = c.list();
			a = list.get(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return a;
	}

	/**
	 * get Answer by qid
	 * 
	 * @author Fengdalu
	 * @param qid
	 * @return
	 */
	public static List<Answer> getAnswerByQid(int qid) {
		Session session = null;
		List<Answer> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Answer.class);
			c.add(Restrictions.eq("qid", qid));
			list = c.list();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return list;
	}

	/**
	 * get answer by Aid
	 * 
	 * @param uid
	 * @return
	 */
	public static List<Answer> getAnswerByUid(int uid) {
		Session session = null;
		List<Answer> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Answer.class);
			c.add(Restrictions.eq("uid", uid));
			list = c.list();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
	
	/**
	 * ´ð°¸¹Ø¼ü×ÖÄ£ºý²éÑ¯
	 * Fuzzy Query in Mysql by hibernate
	 * @param key the key word~
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Answer> fuzzyQuery(String acontent)
	{
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		// ÕâÀïÒªÓÃjavabeanÖÐµÄÃû×Ö£¡£¡
		String strSql = "from Answer as a where a.acontent like :content";
		Query query = session.createQuery(strSql);
		query.setString("content", "%" + acontent + "%");
		return (ArrayList<Answer>) query.list();
	}
	
	/**
	 * Click 'like' or not;
	 * @param aid answer id
	 * @param like =1, yes; like=-1,cancel;
	 * @return
	 */
	public static boolean clickLike(int aid,int like)
	{
		Session session = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Answer.class);
			criteria.add(Restrictions.eq("aid", aid));
			Answer answer = (Answer)criteria.list().get(0);
			if(like == 1)	answer.setAlike(answer.getAlike()+1);
			else			answer.setAlike(answer.getAlike()-1);
			session.save(answer);
			session.getTransaction().commit();
		}
		catch(Exception e)
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

	public static void main(String[] args) {
		AnswerDao.insert(1, 123, "hello");
		System.out.println(AnswerDao.getAnswer(1));
		AnswerDao.delete(1);
	}
}
