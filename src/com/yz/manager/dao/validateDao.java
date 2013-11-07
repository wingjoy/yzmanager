package com.yz.manager.dao;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.bean.user;
import com.yz.manager.hibernate.HibernateSessionFactory;

public class validateDao {

	public static int  validateUser(String userName,String userPassword){
		
        int b1=2;
        Session session=null;
        String md5=encryptionByMD5.getMD5(userPassword.trim().getBytes());
        System.out.println("mima55555555:"+md5);
        
        user us=new user();
        try {	
        	HttpSession s=ServletActionContext.getRequest().getSession();
        	session=HibernateSessionFactory.getSession();
        	//session.
        	System.out.println("aaaaaaa----:"+userName);
			Criteria criteria=session.createCriteria(user.class);
			criteria.add(Restrictions.eq("userName", userName.trim()));
			
			us=(user)criteria.uniqueResult();
			criteria.add(Restrictions.eq("userPassword", md5));
		    us=(user)criteria.uniqueResult();
		    if(us==null)
		    	b1=1;
			    else if(us!=null&us.isStatus()){	
			       s.setAttribute("us", us);
			    	b1=2;
			    }else if(us!=null&!us.isStatus()){
			    	b1=3;
			    }
			
			} catch (HibernateException e) {
				e.printStackTrace();
			throw e;			
		}
			finally{
			if(session.isOpen()) session.close();
		}
		return b1;
	}
		
}
