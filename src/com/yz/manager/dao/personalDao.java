package com.yz.manager.dao;


import java.sql.Timestamp;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.hibernate.HibernateSessionFactory;
import com.yz.manager.personal.bean.personal;

public class personalDao {

	 public personalDao(){
		 
	 }
	 
	 public static void addPersonal(personal ps){
		 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();	
				
				session.save(ps);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 @SuppressWarnings("unchecked")
		public static int selectPersonalSize(String department){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(personal.class);
					criteria.add(Restrictions.eq("department", department));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static int selectPersonalSize(String department,String us){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(personal.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("userName", us));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 
	 
	 @SuppressWarnings("unchecked")
		public static List<personal> selectPersonal(String department,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<personal> ar=new ArrayList<personal>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(personal.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
					criteria.addOrder(Order.desc("registerDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
					
				    ar=(List<personal>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ar;
		 }
		 
		 @SuppressWarnings("unchecked")
			public static List<personal> selectPersonal(){
		 		 
				    Session session=null;	
				    List<personal> ar=new ArrayList<personal>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(personal.class);						
						criteria.addOrder(Order.desc("registerDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ar=(List<personal>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			 @SuppressWarnings("unchecked")
				public static List<personal> selectPersonalByDepartment(String department){
			 		 
					    Session session=null;	
					    List<personal> ar=new ArrayList<personal>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(personal.class);	
							criteria.add(Restrictions.eq("department", department));
							criteria.addOrder(Order.desc("registerDate"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							
						    ar=(List<personal>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
				 @SuppressWarnings("unchecked")
					public static List<personal> selectPersonalByUserName(String userName){
				 		 
						    Session session=null;	
						    List<personal> ar=new ArrayList<personal>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(personal.class);	
								criteria.add(Restrictions.eq("userName", userName));
								criteria.addOrder(Order.desc("registerDate"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ar=(List<personal>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ar;
					 }
		 @SuppressWarnings("unchecked")
			public static List<personal> selectPersonal(String department,String userName,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<personal> ar=new ArrayList<personal>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(personal.class);
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("userName", userName));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("registerDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ar=(List<personal>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
		
		 @SuppressWarnings("unchecked")
			public static int  selectPsByOptionInt(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search){
		 		 
				    Session session=null;
				    int totalCount=0;  
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(personal.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));		
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
						}
						if("1".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactName","%"+search+"%"));	
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("mobilePhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("workPhone","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyName","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyAddress","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						totalCount=criteria.list().size();	
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return totalCount;
			 }
		 @SuppressWarnings("unchecked")
			public static  List<personal> selectPsByOption(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search,int currentPage,int pageSize){
		 		 
				    Session session=null;
				    List<personal> ps=new ArrayList<personal>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(personal.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));		
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
						}
						if("1".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactName","%"+search+"%"));	
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("mobilePhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("workPhone","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyName","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyAddress","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("registerDate"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("userName"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ps=(List<personal>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
			@SuppressWarnings("unchecked")
			public static  List<personal> selectPsByOption(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search){
		 		 
				    Session session=null;
				    List<personal> ps=new ArrayList<personal>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(personal.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));		
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("registerDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("registerDate", new Timestamp(d2.getTime()+86400000)));
						}
						if("1".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactName","%"+search+"%"));	
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("mobilePhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("workPhone","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyName","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyAddress","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));											
						
						criteria.addOrder(Order.desc("registerDate"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("userName"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ps=(List<personal>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
			 @SuppressWarnings("unchecked")
				public static void deletePersonal(int aId){
			 		 
					    Session session=null;	
					    Transaction tx=null;	 
					    personal ps=new personal();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
				        	tx=session.beginTransaction();	
							ps=(personal)session.get(personal.class, aId);	
							if(ps!=null)session.delete(ps);
							tx.commit();
							}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
				 }
			 @SuppressWarnings("unchecked")
				public static personal selectPersonal(String aId){
			 		 
					    Session session=null;	
					    personal ps=new personal();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							ps=(personal)session.get(personal.class, Integer.valueOf(aId).intValue());	    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ps;
				 }
			 @SuppressWarnings("unchecked")
				public static void modifyPersonal(personal ps){
			 		 
					    Session session=null;	
					    Transaction tx=null;	 				  	    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
				        	tx=session.beginTransaction();	
							if(ps!=null)session.update(ps);
							tx.commit();
							}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
				 }
	
}
