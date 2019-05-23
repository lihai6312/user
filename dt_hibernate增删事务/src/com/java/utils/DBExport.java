package com.java.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DBExport {

	public static void main(String[] args) {
		//����hibernate���ö���
		Configuration cfg = new Configuration();
		//ָ��hibernate.cfg.xml��λ��
		cfg.configure("hibernate.cfg.xml");
		//������Ķ���
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
