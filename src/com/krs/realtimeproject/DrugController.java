package com.krs.realtimeproject;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("Realtimeprg2-servlet")
public class DrugController {
	
	public static final Logger log = Logger.getLogger(DrugController.class);
	
	@RequestMapping(value="/req",method=RequestMethod.POST)
public String addDrug(HttpServletRequest req) {
	SessionFactory sf=HibHelp.getSessionFactory();
	Session ss=sf.openSession();
	Transaction transaction=ss.beginTransaction();
	String brand=req.getParameter("dname");
	int price=Integer.valueOf(req.getParameter("dprice"));
	String d1=req.getParameter("dmfg");
	String d2=req.getParameter("dexp");
	log.debug("Test message");
	//ApplicationContext ctx=new AnnotationConfigApplicationContext(springConfig.class);
	//d=(Drug)ctx.getBean("Drug");
	Drug d=new Drug();
	d.setDname(brand);
	d.setPrice(price);
	d.setDmfg(d1);
	d.setDexp(d2);
	ss.save(d);
	if(ss.save(d)!=null) {
	transaction.commit();
	sf.close();
	}
	else {
	transaction.rollback();
	sf.close();
	}
	return "orders";
}
	
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
public String showDrug(ModelMap map) {
		List drg=new ArrayList();
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Query qr=ss.createQuery("from Drug");
		List<Drug> li=qr.list();
		ListIterator<Drug> lit=li.listIterator();
		while(lit.hasNext()) {
			Drug d1=(Drug)lit.next();
			drg.add(d1); 
			System.out.println("test");
		}
		map.addAttribute("values",drg);
		ss.close();
		sf.close();
		
		return "orders";
}

	@RequestMapping(value="/del",method=RequestMethod.POST)
public String deleteDrug(HttpServletRequest req,ModelMap map) {
		int id=Integer.parseInt((req.getParameter("id")));
		System.out.println(id);
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Transaction transaction = ss.beginTransaction();
		Query qry=ss.createQuery("delete from Drug d where d.id=:java4s");
		qry.setParameter("java4s",id);
		int res=qry.executeUpdate();
		System.out.println(res);
		transaction.commit();
		ss.close();
		sf.close();
		showDrug(map);
		return "orders";
}	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
public String updateDrug(ModelMap map,HttpServletRequest req) {
		int id=Integer.parseInt(req.getParameter("idno_"));
		String brand=req.getParameter("dname_");
		int price=Integer.valueOf(req.getParameter("dprice_"));
		String d1=req.getParameter("dmfg_");
		String d2=req.getParameter("dexp_");
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		Drug dr=new Drug();
		dr.setId(id);
		dr.setDname(brand);
		dr.setPrice(price);
		dr.setDmfg(d1);
		dr.setDexp(d2);
		ss.update(dr);
/*		Query qr=ss.createQuery("update Drug d set d.Drug_name=?,d.Drug_price=?,d.Date_of_manufacture=?,d.Date_of_Expiry=? where d.id=?");
		qr.setString(0, brand);
		qr.setInteger(1, price);
		qr.setString(2, d1);
		qr.setString(3, d2);
		qr.setInteger(4, id);*/
//		int st=qr.executeUpdate();
		tr.commit();
		if(dr!=null) {
			map.addAttribute("success","Updated successfully");
			
		}
		ss.close();
		sf.close();
		showDrug(map);
		return "orders";
}
	
	@RequestMapping(value="/populate",method=RequestMethod.GET)
public String populateDrug(ModelMap map,HttpServletRequest req) {
	int t=	Integer.parseInt(req.getParameter("drugId"));
		System.out.println(t);
		List drg=new ArrayList();
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Query qr=ss.createQuery("from Drug d where d.id=?");
		qr.setInteger(0, t);
		Drug drug=(Drug)qr.uniqueResult();
		map.addAttribute("Drugvalue", drug);
		ss.close();
		sf.close();
		showDrug(map);
		return "orders";
}	
	
}
