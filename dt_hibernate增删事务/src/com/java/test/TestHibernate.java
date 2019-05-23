package com.java.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.java.model.User;

public class TestHibernate {
	@Test
	public void tsetDelete() {
		 //创建hibernate配置对象
		Configuration cfg = new Configuration();
		//配置hibernate的核心文件的位置
		cfg.configure("hibernate.cfg.xml");
		//注册配置属性信息
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build();
		//创建SessionFactory
		SessionFactory factory = cfg.buildSessionFactory(sr);
		//创建Session
		Session session = factory.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//创建对象
		User user = (User) session.get(User.class, 1);
		session.delete(user);
		//提交事务
		tx.commit();
		session.close();
		factory.close();	
		
	}
	
	@Test
	public void tsetUpdate() {
		//创建hibernate配置对象
		Configuration cfg = new Configuration();
		//配置hibernate的核心文件的位置
		cfg.configure("hibernate.cfg.xml");
		//注册配置属性信息
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build();
		//创建SessionFactory
		SessionFactory factory = cfg.buildSessionFactory(sr);
		//创建Session
		Session session = factory.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//1查询返回的对象
		User user = (User) session.get(User.class, 2);
		//1.1向查询返回的对象设置要修改的值
		user.setUname("张三丰");
		//1.2调用session里面的update做修改()
		session.update(user);
		System.out.println(user.toString());
		//提交事务
		tx.commit();
		session.close();
		factory.close();
	}
    @Test
	public void testInsert() {
		    //创建hibernate配置对象
			Configuration cfg = new Configuration();
			//配置hibernate的核心文件的位置
			cfg.configure("hibernate.cfg.xml");
			//注册配置属性信息
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties()).build();
			//创建SessionFactory
			SessionFactory factory = cfg.buildSessionFactory(sr);
			//创建Session
			Session session = factory.openSession();
			//开启事务
			Transaction tx = session.beginTransaction();
			//创建对象
			User user = (User) session.get(User.class, 1);
			System.out.println(user.toString());
			//提交事务
			tx.commit();
			session.close();
			factory.close();
	}
}
