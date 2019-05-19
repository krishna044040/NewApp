package com.krs.realtimeproject;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("Realtimeprg2-servlet")
public class RegisterController {

	public static final Logger log = Logger.getLogger(RegisterController.class);
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String addUser(HttpServletRequest req,ModelMap map) {
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Transaction transaction=ss.beginTransaction();
		String fname=req.getParameter("fname");
		if(fname.indexOf(" ")==-1) {
			map.addAttribute("nameerror", "Error in name: Give space between firstname and lastname eg. <font color=\"green\">Krishna Sharma</font>");
			return "Register";
		}
			
		String dob=req.getParameter("dob");
		String username=req.getParameter("username");
		String phone=req.getParameter("phone");
		String reason=req.getParameter("reason");
		
		Register register= new Register();
		register.setFname(fname);
		register.setDob(dob);
		register.setUsername(username);
		register.setPhone(phone);
		register.setReason(reason);
		
		double dub= Math.random();
		int r=(int)(dub*1000);
		System.out.println(r);
		String[] fstring=fname.split(" ");
		String pass=fstring[0]+r;
		register.setPass(pass);
		ss.save(register);
		if(ss.save(register)!=null) {
			transaction.commit();
			map.addAttribute("msg", "user added sucessfully");
			SmsSender sms=new SmsSender();
			String status=sms.sendSms(username, phone, pass);
			log.debug("sms-status"+status);
			sf.close();
			return "Register";
			}
			else {
			transaction.rollback();
			sf.close();
			return "Register";
			}
		
		
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUser(HttpServletRequest req,ModelMap map) {
		String uname=req.getParameter("uname");
		String hql="from Register where Username=:uname";
		String pass=req.getParameter("pass");
		SessionFactory sf=HibHelp.getSessionFactory();
		Session ss=sf.openSession();
		Query qr=ss.createQuery(hql);
		qr.setParameter("uname", uname);
		List list=qr.list();
		Iterator ite=list.iterator();
		while(ite.hasNext()) {
			Register reg=(Register)ite.next();
			if(pass.equals(reg.getPass())) {
				map.addAttribute("sucessmsg", "Login Sucessful");
				sf.close();
				return "Login";
			}
			}
		map.addAttribute("errormsg", "Login Failed:Username or password did not match");
		sf.close();
		return "Login";
			
	}
}
