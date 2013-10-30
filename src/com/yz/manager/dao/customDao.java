package com.yz.manager.dao;


import java.sql.Timestamp;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.custom.bean.custom;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.hibernate.HibernateSessionFactory;

public class customDao {

	 public customDao(){
		 
	 }
	 
	 public static void addCustom(custom cs){
		 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();	
				
				session.save(cs);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 @SuppressWarnings("unchecked")
		public static int selectCustomSize(String department,String userName){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("userName", userName));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static int selectCustomSize(boolean rectify){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);	
					criteria.add(Restrictions.eq("rectify", rectify));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static int selectCustomSize(String department,boolean rectify){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);	
					criteria.add(Restrictions.eq("rectify", rectify));
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
		public static int selectCustomSize(String department,String userName,boolean rectify){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);	
					criteria.add(Restrictions.eq("rectify", rectify));
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("userName", userName));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static int selectCustomSizeByRectify(boolean rectify){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);	
					criteria.add(Restrictions.eq("rectify", rectify));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static List<custom> selectCustom(String department,String userName,boolean rectify,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<custom> cs=new ArrayList<custom>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(custom.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("rectify", rectify));
					criteria.add(Restrictions.eq("userName", userName));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
					criteria.addOrder(Order.desc("addDate"));
					criteria.addOrder(Order.asc("areaName"));
					criteria.addOrder(Order.asc("customType"));
					criteria.addOrder(Order.asc("customState"));
					
				    cs=(List<custom>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 }
		 @SuppressWarnings("unchecked")
			public static List<custom> selectCustom(boolean rectify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<custom> cs=new ArrayList<custom>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						criteria.add(Restrictions.eq("rectify", rectify));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("areaName"));
						criteria.addOrder(Order.asc("customType"));
						criteria.addOrder(Order.asc("customState"));
						
					    cs=(List<custom>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return cs;
			 }
			 @SuppressWarnings("unchecked")
				public static List<custom> selectCustom(){
			 		 
					    Session session=null;	
					    List<custom> cs=new ArrayList<custom>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(custom.class);
							criteria.add(Restrictions.eq("rectify", false));					
							
							criteria.addOrder(Order.asc("areaName"));
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("userName"));
							criteria.addOrder(Order.asc("customType"));
							criteria.addOrder(Order.asc("companyName"));
		
						    cs=(List<custom>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return cs;
				 }
				 @SuppressWarnings("unchecked")
					public static List<custom> selectCustomByDepartment(String department){
				 		 
						    Session session=null;	
						    List<custom> cs=new ArrayList<custom>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(custom.class);
								criteria.add(Restrictions.eq("rectify", false));					
								criteria.add(Restrictions.eq("department", department));
								criteria.addOrder(Order.asc("areaName"));
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("userName"));
								criteria.addOrder(Order.asc("customType"));
								criteria.addOrder(Order.asc("companyName"));
			
							    cs=(List<custom>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return cs;
					 }
					 @SuppressWarnings("unchecked")
						public static List<custom> selectCustomByUserName(String userName){
					 		 
							    Session session=null;	
							    List<custom> cs=new ArrayList<custom>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(custom.class);
									criteria.add(Restrictions.eq("rectify", false));					
									criteria.add(Restrictions.eq("userName", userName));
									criteria.addOrder(Order.asc("areaName"));
									criteria.addOrder(Order.asc("department"));
									criteria.addOrder(Order.asc("userName"));
									criteria.addOrder(Order.asc("customType"));
									criteria.addOrder(Order.asc("companyName"));
				
								    cs=(List<custom>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return cs;
						 }
			@SuppressWarnings("unchecked")
			public static List<custom> selectMyCustom(String department,String userName,boolean rectify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<custom> cs=new ArrayList<custom>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						criteria.add(Restrictions.eq("rectify", rectify));
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("userName", userName));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("areaName"));
						criteria.addOrder(Order.asc("customType"));
						criteria.addOrder(Order.asc("customState"));
						
					    cs=(List<custom>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return cs;
			 }
			@SuppressWarnings("unchecked")
			public static List<custom> selectCustom(String department,boolean rectify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<custom> cs=new ArrayList<custom>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						criteria.add(Restrictions.eq("rectify", rectify));
						criteria.add(Restrictions.eq("department", department));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("areaName"));
						criteria.addOrder(Order.asc("customType"));
						criteria.addOrder(Order.asc("customState"));
						
					    cs=(List<custom>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return cs;
			 }
		
		 @SuppressWarnings("unchecked")
			public static int  selectCustomByOptionInt(String department,String userName,String areaName,String customType,
					String dateBegin,String dateEnd,String select,String search){
		 		 
				    Session session=null;
				    int totalCount=0;  
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(areaName))criteria.add(Restrictions.eq("areaName", areaName));
						if(!"0".equals(customType))criteria.add(Restrictions.eq("customType", customType));		
						criteria.add(Restrictions.eq("rectify", false));
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
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
			public static  List<custom> selectCustomByOption(String department,String userName,String areaName,String customType,
					String dateBegin,String dateEnd,String select,String search,int currentPage,int pageSize){
		 		 
				    Session session=null;
				    List<custom> ps=new ArrayList<custom>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(areaName))criteria.add(Restrictions.eq("areaName", areaName));
						if(!"0".equals(customType))criteria.add(Restrictions.eq("customType", customType));		
						criteria.add(Restrictions.eq("rectify", false));
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
						}
						if("1".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactName","%"+search+"%"));	
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("mobilePhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("workPhone","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyName","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyAddress","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));		
						criteria.addOrder(Order.asc("areaName"));

					    ps=(List<custom>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
			@SuppressWarnings("unchecked")
			public static  List<custom> selectCustomByOption(String department,String userName,String areaName,String customType,
					String dateBegin,String dateEnd,String select,String search){
		 		 
				    Session session=null;
				    List<custom> ps=new ArrayList<custom>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(custom.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(areaName))criteria.add(Restrictions.eq("areaName", areaName));
						if(!"0".equals(customType))criteria.add(Restrictions.eq("customType", customType));		
						criteria.add(Restrictions.eq("rectify", false));
						if(!"".equals(dateBegin)&!"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							Date d2=CurrentDate.parseDate3(dateEnd);						
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
							//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
						}else if(!"".equals(dateBegin)&"".equals(dateEnd)){
							Date d1=CurrentDate.parseDate3(dateBegin);
							criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
						}else if("".equals(dateBegin)&!"".equals(dateEnd)){								
							Date d2=CurrentDate.parseDate3(dateEnd);
							criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
						}
						if("1".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactName","%"+search+"%"));	
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("mobilePhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("workPhone","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyName","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("companyAddress","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						criteria.addOrder(Order.asc("areaName"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("userName"));
						criteria.addOrder(Order.asc("customType"));
						criteria.addOrder(Order.asc("companyName"));

					    ps=(List<custom>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }

			 @SuppressWarnings("unchecked")
				public static void deleteCustom(int aId){
			 		 
					    Session session=null;	
					    Transaction tx=null;	 
					    custom cs=new custom();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
				        	tx=session.beginTransaction();	
							cs=(custom)session.get(custom.class, aId);	
							if(cs!=null)session.delete(cs);
							tx.commit();
							}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
				 }
			 @SuppressWarnings("unchecked")
				public static custom selectCustom(String aId){
			 		 
					    Session session=null;	
					    custom ps=new custom();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							ps=(custom)session.get(custom.class, Integer.valueOf(aId).intValue());	    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ps;
				 }
			 @SuppressWarnings("unchecked")
				public static void modifyCustom(custom ps){
			 		 
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
