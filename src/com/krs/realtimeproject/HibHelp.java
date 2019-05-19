package com.krs.realtimeproject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibHelp {
	static SessionFactory sf;
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {
	Configuration cfg=new Configuration();
	cfg.configure("Drug.cfg.xml");
	sf=cfg.buildSessionFactory();
	return sf;
}}
