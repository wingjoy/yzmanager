package com.yz.manager.dao;

import java.io.File;
import java.sql.Timestamp;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.archives.bean.archives;
import com.yz.manager.bean.user;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.hibernate.HibernateSessionFactory;

public class archivesDao {

	 public archivesDao(){
		 
	 }
	 
	 public static void addArchives(archives ar){
		 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();	
				
				session.save(ar);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	
	 @SuppressWarnings("unchecked")
		public static List<archives> selectArchives(String department){
	 		 
			    Session session=null;	
			    List<archives> ar=new ArrayList<archives>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(archives.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("averify", 1));
					criteria.addOrder(Order.desc("saveArDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
				    ar=(List<archives>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ar;
		 }
		 @SuppressWarnings("unchecked")
			public static List<archives> selectArchivesByUserName(String userName){
		 		 
				    Session session=null;	
				    List<archives> ar=new ArrayList<archives>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(archives.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("averify", 1));
						criteria.addOrder(Order.desc("saveArDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
					    ar=(List<archives>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }

		@SuppressWarnings("unchecked")
		public static List<archives> selectArchives(){
	 		 
			    Session session=null;	
			    List<archives> ar=new ArrayList<archives>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(archives.class);	
					criteria.add(Restrictions.eq("averify", 1));
					criteria.addOrder(Order.desc("saveArDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
				    ar=(List<archives>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ar;
		 }
		 @SuppressWarnings("unchecked")
			public static List<archives> selectArchives(String department,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<archives> ar=new ArrayList<archives>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(archives.class);
						criteria.add(Restrictions.eq("saveArDepartment", department));
						criteria.add(Restrictions.eq("averify", 1));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("saveArDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ar=(List<archives>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			 @SuppressWarnings("unchecked")
				public static List<archives> selectArchives(String userName,String department,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<archives> ar=new ArrayList<archives>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(archives.class);
							criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("department", department));
							criteria.add(Restrictions.eq("averify", 1));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.desc("saveArDate"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							
						    ar=(List<archives>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
			 @SuppressWarnings("unchecked")
				public static List<archives> selectArByOption(String giveDepartment,String giveArName,String firstCName,String secondCName,
						String saveDepartment,String saveArName,String saveArDateBegin,String saveArDateEnd,String fileName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<archives> ar=new ArrayList<archives>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(archives.class);
							if(!"0".equals(giveDepartment))criteria.add(Restrictions.eq("department", giveDepartment));
							if(!"0".equals(giveArName))criteria.add(Restrictions.eq("userName", giveArName));
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
							if(!"0".equals(saveDepartment))criteria.add(Restrictions.eq("saveArDepartment", saveDepartment));
							if(!"0".equals(saveArName))criteria.add(Restrictions.eq("saveArName", saveArName));
							if(!"".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){
								Date d1=CurrentDate.parseDate3(saveArDateBegin);
								Date d2=CurrentDate.parseDate3(saveArDateEnd);						
								criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(saveArDateBegin)&"".equals(saveArDateEnd)){
							Date d1=CurrentDate.parseDate3(saveArDateBegin);
								criteria.add(Restrictions.ge("saveArDate",new Timestamp(d1.getTime())));
							}else if("".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){								
								Date d2=CurrentDate.parseDate3(saveArDateEnd);
								criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
							}
							if(null!=fileName&!"".equals(fileName))criteria.add(Restrictions.like("fileName", "%"+fileName+"%"));
							criteria.add(Restrictions.eq("averify", 1));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.desc("saveArDate"));
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("userName"));
							criteria.addOrder(Order.asc("saveArDepartment"));
							criteria.addOrder(Order.asc("saveArName"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							
						    ar=(List<archives>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
				 @SuppressWarnings("unchecked")
					public static List<archives> selectArByOption(String giveDepartment,String giveArName,String firstCName,String secondCName,
							String saveDepartment,String saveArName,String saveArDateBegin,String saveArDateEnd,String fileName){
				 		 
						    Session session=null;	
						    List<archives> ar=new ArrayList<archives>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(archives.class);
								if(!"0".equals(giveDepartment))criteria.add(Restrictions.eq("department", giveDepartment));
								if(!"0".equals(giveArName))criteria.add(Restrictions.eq("userName", giveArName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"0".equals(saveDepartment))criteria.add(Restrictions.eq("saveArDepartment", saveDepartment));
								if(!"0".equals(saveArName))criteria.add(Restrictions.eq("saveArName", saveArName));
								if(!"".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									Date d2=CurrentDate.parseDate3(saveArDateEnd);						
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(saveArDateBegin)&"".equals(saveArDateEnd)){
								Date d1=CurrentDate.parseDate3(saveArDateBegin);
									criteria.add(Restrictions.ge("saveArDate",new Timestamp(d1.getTime())));
								}else if("".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){								
									Date d2=CurrentDate.parseDate3(saveArDateEnd);
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
								}
								if(null!=fileName&!"".equals(fileName))criteria.add(Restrictions.like("fileName", "%"+fileName+"%"));
								criteria.add(Restrictions.eq("averify", 1));		
								criteria.addOrder(Order.desc("saveArDate"));
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("userName"));
								criteria.addOrder(Order.asc("saveArDepartment"));
								criteria.addOrder(Order.asc("saveArName"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ar=(List<archives>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ar;
					 }
				 @SuppressWarnings("unchecked")
					public static List<archives> selectApplyArByOption(String firstCName,String secondCName,
							String saveDepartment,String saveArName,String saveArDateBegin,String saveArDateEnd,String fileName,int averify ,String userName,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<archives> ar=new ArrayList<archives>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(archives.class);
								criteria.add(Restrictions.eq("averify", averify));
								criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"0".equals(saveDepartment))criteria.add(Restrictions.eq("saveArDepartment", saveDepartment));
								if(!"0".equals(saveArName))criteria.add(Restrictions.eq("saveArName", saveArName));
								if(!"".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									Date d2=CurrentDate.parseDate3(saveArDateEnd);						
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(saveArDateBegin)&"".equals(saveArDateEnd)){
								Date d1=CurrentDate.parseDate3(saveArDateBegin);
									criteria.add(Restrictions.ge("saveArDate",new Timestamp(d1.getTime())));
								}else if("".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){								
									Date d2=CurrentDate.parseDate3(saveArDateEnd);
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
								}
								if(null!=fileName&!"".equals(fileName))criteria.add(Restrictions.like("fileName", "%"+fileName+"%"));				
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("saveArDate"));
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("userName"));
								criteria.addOrder(Order.asc("saveArDepartment"));
								criteria.addOrder(Order.asc("saveArName"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ar=(List<archives>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ar;
					 }
			
				 @SuppressWarnings("unchecked")
					public static int  selectArByOptionInt(String giveDepartment,String giveArName,String firstCName,String secondCName,
							String saveDepartment,String saveArName,String saveArDateBegin,String saveArDateEnd,String fileName){
				 		 
						    Session session=null;
						    int totalCount=0;  
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(archives.class);
								if(!"0".equals(giveDepartment))criteria.add(Restrictions.eq("department", giveDepartment));
								if(!"0".equals(giveArName))criteria.add(Restrictions.eq("userName", giveArName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"0".equals(saveDepartment))criteria.add(Restrictions.eq("saveArDepartment", saveDepartment));
								if(!"0".equals(saveArName))criteria.add(Restrictions.eq("saveArName", saveArName));
								if(!"".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									Date d2=CurrentDate.parseDate3(saveArDateEnd);						
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(saveArDateBegin)&"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
								}else if("".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){								
									Date d2=CurrentDate.parseDate3(saveArDateEnd);
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
								}
								if(null!=fileName&!"".equals(fileName))criteria.add(Restrictions.like("fileName", "%"+fileName+"%"));
								criteria.add(Restrictions.eq("averify", 1));						
								totalCount=criteria.list().size();	
							   
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return totalCount;
					 }
				 @SuppressWarnings("unchecked")
					public static int  selectApplyArByOptionInt(String firstCName,String secondCName,
							String saveDepartment,String saveArName,String saveArDateBegin,String saveArDateEnd,String fileName,int  averify,String userName){
				 		 
						    Session session=null;
						    int totalCount=0;  
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(archives.class);	
								criteria.add(Restrictions.eq("userName", userName));
								criteria.add(Restrictions.eq("averify", averify));		
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"0".equals(saveDepartment))criteria.add(Restrictions.eq("saveArDepartment", saveDepartment));
								if(!"0".equals(saveArName))criteria.add(Restrictions.eq("saveArName", saveArName));
								if(!"".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									Date d2=CurrentDate.parseDate3(saveArDateEnd);						
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(saveArDateBegin)&"".equals(saveArDateEnd)){
									Date d1=CurrentDate.parseDate3(saveArDateBegin);
									criteria.add(Restrictions.ge("saveArDate", new Timestamp(d1.getTime())));
								}else if("".equals(saveArDateBegin)&!"".equals(saveArDateEnd)){								
									Date d2=CurrentDate.parseDate3(saveArDateEnd);
									criteria.add(Restrictions.lt("saveArDate", new Timestamp(d2.getTime()+86400000)));
								}
								if(null!=fileName&!"".equals(fileName))criteria.add(Restrictions.like("fileName", "%"+fileName+"%"));						
								totalCount=criteria.list().size();	
							   
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return totalCount;
					 }
					
				
		@SuppressWarnings("unchecked")
		public static int selectArchivesSize(String department){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(archives.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("averify", 1));
					criteria.addOrder(Order.desc("saveArDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
		@SuppressWarnings("unchecked")
		public static int selectMyArchivesSize(String userName,String department){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(archives.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("userName", userName));
					criteria.add(Restrictions.eq("averify", 1));
					criteria.addOrder(Order.desc("saveArDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
		@SuppressWarnings("unchecked")
		public static List<archives> selectArchives2(String name){
	 		 
			    Session session=null;	
			    List<archives> ar=new ArrayList<archives>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
		        	Criteria criteria=session.createCriteria(user.class);
		        	//criteria.add(Restrictions.eq("userName", userName));
		        	//user us=(user)criteria.uniqueResult();
		        	
					criteria=session.createCriteria(archives.class);				
					criteria.add(Restrictions.eq("saveArName", name));
					criteria.add(Restrictions.eq("averify", 0));
					criteria.addOrder(Order.desc("saveArDate"));
				    ar=(List<archives>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ar;
		 }
		
		@SuppressWarnings("unchecked")
		public static List<archives> selectArchives2(String name,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<archives> ar=new ArrayList<archives>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();       
		        	Criteria criteria=session.createCriteria(archives.class);				
					criteria.add(Restrictions.eq("saveArName", name));
					criteria.add(Restrictions.eq("averify", 0));
					criteria.addOrder(Order.desc("arDate"));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    ar=(List<archives>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ar;
		 }
		
		@SuppressWarnings("unchecked")
		public static int selectArchives2Size(String name){
	 		 
			    Session session=null;	
			    int i=0;	    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
		        	Criteria criteria=session.createCriteria(user.class);
		        	
					criteria=session.createCriteria(archives.class);				
					criteria.add(Restrictions.eq("saveArName", name));
					criteria.add(Restrictions.eq("averify", 0));
					criteria.addOrder(Order.desc("saveArDate"));
				    i=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return i;
		 }
		 @SuppressWarnings("unchecked")
			public static List<archives> selectArchivesByVerify(String userName,int verify){
		 		 
				    Session session=null;	
				    List<archives> ar=new ArrayList<archives>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(archives.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("averify", verify));
						criteria.addOrder(Order.desc("arDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
					    ar=(List<archives>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			
			@SuppressWarnings("unchecked")
			public static List<archives> selectArchivesByVerify(String userName,int verify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<archives> ar=new ArrayList<archives>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(archives.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("averify", verify));
						criteria.addOrder(Order.desc("arDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
					    ar=(List<archives>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			
			 @SuppressWarnings("unchecked")
				public static int selectArchivesByVerifySize(String userName,int verify){
			 		 
					    Session session=null;	
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(archives.class);
							criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("averify", verify));
							criteria.addOrder(Order.desc("arDate"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
						    i=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return i;
				 }
		 @SuppressWarnings("unchecked")
			public static archives selectArchives1(String aId){
		 		 
				    Session session=null;	
				    archives ar=new archives();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						ar=(archives)session.get(archives.class, Integer.valueOf(aId).intValue());	    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
		 
		 @SuppressWarnings("unchecked")
			public static void deleteArchives(int aId){
		 		 
				    Session session=null;	
				    Transaction tx=null;	 
				    archives ar=new archives();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	tx=session.beginTransaction();	
						ar=(archives)session.get(archives.class, aId);	
						if(ar!=null)session.delete(ar);
						if(ar.getFileDir()!=null){
							File file=new File(ServletActionContext.getServletContext()
									.getRealPath(ar.getFileDir()));
							File file2=file.getParentFile();
							file.delete();
							if(file2.list().length==0)file2.delete();
						}
						tx.commit();
						}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
			 }
		 
		 @SuppressWarnings("unchecked")
			public static void modifyArchives(archives ar){
		 		 
				    Session session=null;	
				    Transaction tx=null;	 				  	    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	tx=session.beginTransaction();	
						if(ar!=null)session.update(ar);
						tx.commit();
						}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
			 }
}
