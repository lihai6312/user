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
		 //����hibernate���ö���
		Configuration cfg = new Configuration();
		//����hibernate�ĺ����ļ���λ��
		cfg.configure("hibernate.cfg.xml");
		//ע������������Ϣ
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build();
		//����SessionFactory
		SessionFactory factory = cfg.buildSessionFactory(sr);
		//����Session
		Session session = factory.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		//��������
		User user = (User) session.get(User.class, 1);
		session.delete(user);
		//�ύ����
		tx.commit();
		session.close();
		factory.close();	
		
	}
	
	@Test
	public void tsetUpdate() {
		//����hibernate���ö���
		Configuration cfg = new Configuration();
		//����hibernate�ĺ����ļ���λ��
		cfg.configure("hibernate.cfg.xml");
		//ע������������Ϣ
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build();
		//����SessionFactory
		SessionFactory factory = cfg.buildSessionFactory(sr);
		//����Session
		Session session = factory.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		//1��ѯ���صĶ���
		User user = (User) session.get(User.class, 2);
		//1.1���ѯ���صĶ�������Ҫ�޸ĵ�ֵ
		user.setUname("������");
		//1.2����session�����update���޸�()
		session.update(user);
		System.out.println(user.toString());
		//�ύ����
		tx.commit();
		session.close();
		factory.close();
	}
    @Test
	public void testInsert() {
		    //����hibernate���ö���
			Configuration cfg = new Configuration();
			//����hibernate�ĺ����ļ���λ��
			cfg.configure("hibernate.cfg.xml");
			//ע������������Ϣ
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties()).build();
			//����SessionFactory
			SessionFactory factory = cfg.buildSessionFactory(sr);
			//����Session
			Session session = factory.openSession();
			//��������
			Transaction tx = session.beginTransaction();
			//��������
			User user = (User) session.get(User.class, 1);
			System.out.println(user.toString());
			//�ύ����
			tx.commit();
			session.close();
			factory.close();
	}
}
