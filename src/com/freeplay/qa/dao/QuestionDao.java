package com.freeplay.qa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.freeplay.qa.pojo.Question;
import com.freeplay.qa.util.HibernateSessionFactory;
import com.freeplay.qa.util.Tools;

public class QuestionDao {

	/**
	 * Insert a new record of question
	 * 
	 * @param uid
	 *            The id of User
	 * @param qtitle
	 *            The title of question
	 * @param qcontent
	 *            The content of question
	 * @return
	 */
	public static boolean insert(int uid, String qtitle, String qcontent) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();

			Question q = new Question();
			q.setUid(uid);
			q.setQtitle(qtitle);
			q.setQcontent(qcontent);
			q.setStarttime(Tools.getSystemDate());

			session.save(q);
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
	 * Delete the question by the title
	 * 
	 * @param qtitle
	 * @return
	 */
	public static boolean delete(String qtitle) {
		Question q = getQuestionByTitle(qtitle);
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(q);
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return true;
	}

	/**
	 * Delete the question by its id;
	 * 
	 * @param qid
	 * @return
	 */
	public static boolean delete(int qid) {
		Question q = getQuestion(qid);
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			session.delete(q);
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return true;
	}

	/**
	 * Get the certain question by id
	 * 
	 * @param qid
	 * @return
	 */
	public static Question getQuestion(int qid) {
		Question q = null;
		Session session = null;
		List<Question> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Question.class);
			c.add(Restrictions.eq("qid", qid));
			list = c.list();
			q = list.get(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return q;
	}

	/**
	 * Get the certain question by Title
	 * 
	 * @param qid
	 * @return
	 */
	public static Question getQuestionByTitle(String qtitle) {
		Question q = null;
		Session session = null;
		List<Question> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Question.class);
			c.add(Restrictions.eq("qtitle", qtitle));
			list = c.list();
			q = list.get(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return q;
	}

	/**
	 * Get the certain question by Title
	 * 
	 * @param qid
	 * @return
	 */

	public static List<Question> getQuestionByUid(int uid) {
		Session session = null;
		List<Question> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Question.class);
			c.add(Restrictions.eq("uid", uid));
			list = c.list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return list;
	}

	public static void main(String[] args) {
		QuestionDao.insert(123, "hello", "hello world");
		System.out.println(QuestionDao.getQuestion(1));
		// QuestionDao.delete(1);
	}
	
	/**
	 * Get All Question
	 * 
	 * @param qid
	 * @return
	 */
	public static List<Question> getAllQuestion() {
		Session session = null;
		List<Question> list = null;
		try {
			session = HibernateSessionFactory.getSession();
			Criteria c = session.createCriteria(Question.class);
			c.add(Restrictions.eqOrIsNull("endtime", null));
			list = c.list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return list;
	}
}
