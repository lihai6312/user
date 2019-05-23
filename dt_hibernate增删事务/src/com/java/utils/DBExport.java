package com.java.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DBExport {

	public static void main(String[] args) {
		//创建hibernate配置对象
		Configuration cfg = new Configuration();
		//指定hibernate.cfg.xml的位置
		cfg.configure("hibernate.cfg.xml");
		//创建表的对象
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
