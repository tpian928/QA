package com.freeplay.qa.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	// 创建线程
	private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	// 载入配置文件
	private static Configuration configuration = new Configuration();
	
	private static SessionFactory sessionFactory;
	
	private static String configFile = CONFIG_FILE_LOCATION;
	static 
	{
		try 
		{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private HibernateSessionFactory(){}
	
	public static Session getSession() throws HibernateException
	{
		Session session = (Session) threadlocal.get();
		if(session == null || !session.isOpen())
		{
			if(sessionFactory == null)
			{
				// rebuild()
				rebuildSessionFactory();
			}
			
			session = (sessionFactory!=null)?sessionFactory.openSession():null;
			threadlocal.set(session);
		}
		return session;
	}
	
	public static void rebuildSessionFactory()
	{
		try
		{
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void closeSession() throws HibernateException
	{
		Session session = (Session) threadlocal.get();
		threadlocal.set(null);
		if(session != null) session.close();
	}
	
	// SessionFactory
	public static SessionFactory getSessionFactory()
	{ return sessionFactory; }
	
	// Configuration
	public static void setConfiguration(String configFile)
	{
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}
	
	// Configuraion
	public static Configuration getConfiguration()
	{
		return configuration;
	}
}
