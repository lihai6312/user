package com.java.test;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.java.model.User;

public class TestHibernate2 {
	/**
	 * 事务的处理
	 */
	@Test
	public void tsetDelete() {
		SessionFactory factory=null;
		Session session = null;
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties()).build();
		    factory = cfg.buildSessionFactory(sr);
		    session = factory.openSession();
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, 1);
			session.delete(user);
			int i=10/0;
			//提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}finally {
			session.close();
			factory.close();
		}	
	}
	/**
	 * 查询所有
	 * 返回List集合
	 */
	@Test
	public void tsetSelectList() {
		SessionFactory factory=null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties()).build();
		    factory = cfg.buildSessionFactory(sr);
		    session = factory.openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("from User");
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
			}
			//提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}finally {
			session.close();
			factory.close();
		}	
	}
	
}
