package com.yz.manager.bean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.hibernate.HibernateSessionFactory;

public class ceshi {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	    System.out.println("fffffffffffffff");
		 Session session=null;	
		    List<user> us=new ArrayList<user>();			    
	        try {	      
	        	session=HibernateSessionFactory.getSession();  System.out.println("ttttt");
				Criteria criteria=session.createCriteria(user.class);
				criteria.add(Restrictions.eq("userId", 14));
				user u=(user)criteria.uniqueResult();
				/*
			    us=(List<user>)criteria.list();	
			    for(user u :us){
			    	System.out.println("username="+u.getName());
			    	System.out.println("userpowername="+u.getPower().getUserName());
			   
			    }*/
	        	//Transaction tx=null;	
	        	//tx=session.beginTransaction();	
	        	session.delete(u);
	        	session.delete(u.getPower());
				//				 tx.commit();	
				} catch (HibernateException e) {			
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
			
	}

}
