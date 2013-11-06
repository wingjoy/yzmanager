package com.yz.manager.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.yz.manager.bean.secondClass;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.hibernate.HibernateSessionFactory;
import com.yz.manager.storehouse.bean.outStoreHouse;
import com.yz.manager.storehouse.bean.shouse;
import com.yz.manager.storehouse.bean.storeHouse;


public class storeHouseDao {

	 public storeHouseDao(){
		 
	 }
	 
	 public static int addStoreHouse(storeHouse ep){
 		 
		    Session session=null;
	        Transaction tx=null;	
	        int result=0;
	        try {
				session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(secondClass.class);
				criteria.add(Restrictions.eq("id", Integer.valueOf(ep.getSecondCName()).intValue()));
				secondClass sc=(secondClass)criteria.uniqueResult();
				if(sc!=null){
					sc.setInCount(sc.getInCount()+ep.getInCount());
                    tx=session.beginTransaction();	
				    session.update(sc);
					session.save(ep);
					result=1;
				}
				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
			return result;
	 }
	 public static void addStoreHouse1(storeHouse ep){
 		 
		    Session session=null;
	        Transaction tx=null;	
	     
	        try {
				session=HibernateSessionFactory.getSession();
                 tx=session.beginTransaction();	
					session.save(ep);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addOutStore(outStoreHouse ep){
 		 
		    Session session=null;
	        Transaction tx=null;	
	     
	        try {
				session=HibernateSessionFactory.getSession();
              tx=session.beginTransaction();	
					session.save(ep);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addEndOutStore(outStoreHouse ep){
 		 
		    Session session=null;
	        Transaction tx=null;	
	        secondClass sc=new secondClass();
			sc=daoUtil.selectSecondClass3(Integer.valueOf(ep.getSecondCName()));
	     
	        try {
				session=HibernateSessionFactory.getSession();
                tx=session.beginTransaction();
                if(sc!=null){
					sc.setCurrentCount(sc.getCurrentCount()-ep.getApplyCount());
				    sc.setOutCount(sc.getOutCount()+ep.getApplyCount());
				    session.save(ep);
					session.update(sc);
					tx.commit();			
				}	
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 @SuppressWarnings("unchecked")
		public static int selectVerifyStoreSize(String name){
	 		 
			    Session session=null;	
			    int i=0;	    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
		        	
		        	Criteria criteria=session.createCriteria(storeHouse.class);				
					criteria.add(Restrictions.eq("inVerifyName", name));
					criteria.add(Restrictions.eq("inVerify", 0));
					criteria.addOrder(Order.desc("inDate"));
				    i=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return i;
		 }	
	 @SuppressWarnings("unchecked")
		public static int selectVerifyOutStoreSize(String userName){
	 		 
			    Session session=null;	
			    int i=0;	    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
		        	
		        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
					criteria.add(Restrictions.lt("outVerify", 4));
					criteria.add(Restrictions.eq("nextVerifyName", userName));
					criteria.addOrder(Order.desc("applyDate"));
				    i=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return i;
		 }	
	 @SuppressWarnings("unchecked")
		public static List<storeHouse> selectVerifyStore(String name,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<storeHouse> ep=new ArrayList<storeHouse>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();		       
		        	Criteria criteria=session.createCriteria(storeHouse.class);				
					criteria.add(Restrictions.eq("inVerifyName", name));
					criteria.add(Restrictions.eq("inVerify", 0));
					criteria.addOrder(Order.desc("inDate"));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    ep=(List<storeHouse>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ep;
		 }
		 @SuppressWarnings("unchecked")
			public static List<Map> selectVerifyStoreAsMap(String name,int currentPage,int pageSize){
		 		 
				    Session session=null;	
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	return session.createSQLQuery("select userName from  storehouse where inVerify=0 and inVerifyName=? group by userName limit "+(currentPage-1)*pageSize+","+pageSize)
			        	       .setString(0, name).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
			 }
		 @SuppressWarnings("unchecked")
			public static List<outStoreHouse> selectVerifyOutStore(String userName,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<outStoreHouse> ep=new ArrayList<outStoreHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();		       
			        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
						criteria.add(Restrictions.lt("outVerify", 4));
						criteria.addOrder(Order.desc("applyDate"));
						criteria.add(Restrictions.eq("nextVerifyName", userName));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
					    ep=(List<outStoreHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ep;
			 }
			public static storeHouse selectHouse(String aId){
		 		 
				    Session session=null;	
				    storeHouse ps=new storeHouse();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						ps=(storeHouse)session.get(storeHouse.class, Integer.valueOf(aId).intValue());	    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
		 
			@SuppressWarnings("unchecked")
			public static List<storeHouse> selectHouseForUser(String verifyName,String applyName){
				 Session session=null;	
				    List<storeHouse> ep=new ArrayList<storeHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();		       
			        	Criteria criteria=session.createCriteria(storeHouse.class);				
						criteria.add(Restrictions.eq("inVerifyName", verifyName));
						criteria.add(Restrictions.eq("userName", applyName));
						criteria.add(Restrictions.eq("inVerify", 0));
						criteria.addOrder(Order.desc("inDate"));
					    ep=(List<storeHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ep;
			 }
		 
		 @SuppressWarnings("unchecked")
			public static outStoreHouse selectOutHouse(String aId){
		 		 
				    Session session=null;	
				    outStoreHouse ps=new outStoreHouse();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						ps=(outStoreHouse)session.get(outStoreHouse.class, Integer.valueOf(aId).intValue());	    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
		 
		 @SuppressWarnings("unchecked")
			public static void modifyHouse(storeHouse ex){
		 		 
				    Session session=null;	
				    Transaction tx=null;	 				  	    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	tx=session.beginTransaction();	
						if(ex!=null)session.update(ex);
						tx.commit();
						}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
			 }
		 @SuppressWarnings("unchecked")
			public static void modifyOutStoreHouse(outStoreHouse ex){
		 		 
				    Session session=null;	
				    Transaction tx=null;	 				  	    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	tx=session.beginTransaction();	
						if(ex!=null)session.update(ex);
						tx.commit();
						}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
			 }
		 @SuppressWarnings("unchecked")
			public static boolean modifyEndOutStoreHouse(outStoreHouse ex){
		 		 
				    Session session=null;	
				    Transaction tx=null;
				    boolean result=false;
				    secondClass sc=new secondClass();
					sc=daoUtil.selectSecondClass3(Integer.valueOf(ex.getSecondCName()));
					session=HibernateSessionFactory.getSession();
		        	tx=session.beginTransaction();	
					try {	      
						if(sc!=null){
							sc.setCurrentCount(sc.getCurrentCount()-ex.getApplyCount());
						    sc.setOutCount(sc.getOutCount()+ex.getApplyCount());
						    session.update(ex);
							session.update(sc);
							tx.commit();
							result=true;
						}
						}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return result;
			 }
		 @SuppressWarnings("unchecked")
			public static int modifyHouseCount(storeHouse ex){
		 		 
				    Session session=null;	
				    Transaction tx=null;
				    int result=0;
			        try {	
			    	    session=HibernateSessionFactory.getSession();
			        	Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("id", Integer.valueOf(ex.getSecondCName()).intValue()));
						secondClass sc=(secondClass)criteria.uniqueResult();
						if(sc!=null){
							sc.setInCount(sc.getInCount()+ex.getInCount());
							sc.setCurrentCount(sc.getCurrentCount()+ex.getInCount());
				        	tx=session.beginTransaction();	
				        	session.update(sc);
							session.update(ex);
							result=1;
							tx.commit();
						}
				
						}catch (HibernateException e) {
								if(tx!=null)tx.rollback();
								throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return result;
			 }

		 
		 @SuppressWarnings("unchecked")
         public static int inVerify( Map<String,storeHouse> storeHouses ,Integer inverify,String verifyRemarks){
              
                 Session session=null;   
                 Transaction tx=null;
                 int result=0;
                 try {   
                     session=HibernateSessionFactory.getSession();
                     tx=session.beginTransaction();  
                     for(storeHouse ex:storeHouses.values()){
                         Criteria criteria=session.createCriteria(secondClass.class);
                         criteria.add(Restrictions.eq("id", Integer.valueOf(ex.getSecondCName()).intValue()));
                         secondClass sc=(secondClass)criteria.uniqueResult();
                         if(sc!=null){
                             sc.setInCount(sc.getInCount()+ex.getInCount());
                             sc.setCurrentCount(sc.getCurrentCount()+ex.getInCount());
                             session.update(sc);
                             session.createSQLQuery(" update storehouse set VerifyRemarks=?, inverify=? where id="+ex.getId())
                                    .setString(0, verifyRemarks).setInteger(1, inverify).executeUpdate();
                             result=1;
                            
                         }
                     }
                     tx.commit();
                     }catch (HibernateException e) {
                         result = -1;
                             if(tx!=null)tx.rollback();
                             throw e;            
                 }finally{
                     if(session.isOpen()) session.close();
                 }
                 return result;
          }
		 
		 @SuppressWarnings("unchecked")
			public static int selectStoreByVerifySize(String userName,int inVerify){
		 		 
				    Session session=null;	
				   int i=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(storeHouse.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("inVerify", inVerify));
						criteria.addOrder(Order.desc("inDate"));
						criteria.addOrder(Order.asc("houseId"));
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
			public static int selectOutStoreSize(String userName){
		 		 
				    Session session=null;	
				   int i=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);
						criteria.add(Restrictions.eq("userName", userName));		
						criteria.addOrder(Order.desc("applyDate"));
						criteria.addOrder(Order.asc("houseId"));
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
			public static int selectOutStoreByVerifySize(String userName,int outVerify){
		 		 
				    Session session=null;	
				   int i=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("outVerify", outVerify));
					    i=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return i;
			 }
		 @SuppressWarnings("unchecked")
			public static List<storeHouse> selectHouseByVerify(String userName,int inVerify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<storeHouse> ar=new ArrayList<storeHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(storeHouse.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("inVerify", inVerify));
						criteria.addOrder(Order.desc("inDate"));
						criteria.addOrder(Order.asc("houseId"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
					    ar=(List<storeHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			 @SuppressWarnings("unchecked")
				public static List<storeHouse> selectHouseByVerify(){
			 		 
					    Session session=null;	
					    List<storeHouse> ar=new ArrayList<storeHouse>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(storeHouse.class);
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.addOrder(Order.desc("department"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));				
						    ar=(List<storeHouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
				 @SuppressWarnings("unchecked")
					public static List<storeHouse> selectHouseByDepartment(String department){
				 		 
						    Session session=null;	
						    List<storeHouse> ar=new ArrayList<storeHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(storeHouse.class);
								criteria.add(Restrictions.eq("inVerify", 1));
								criteria.add(Restrictions.eq("department", department));
								criteria.addOrder(Order.desc("department"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));				
							    ar=(List<storeHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ar;
					 }
					 @SuppressWarnings("unchecked")
						public static List<storeHouse> selectHouseByUserName(String userName){
					 		 
							    Session session=null;	
							    List<storeHouse> ar=new ArrayList<storeHouse>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(storeHouse.class);
									criteria.add(Restrictions.eq("inVerify", 1));
									criteria.add(Restrictions.eq("userName", userName));
									criteria.addOrder(Order.desc("department"));
									criteria.addOrder(Order.asc("houseId"));
									criteria.addOrder(Order.asc("firstCName"));
									criteria.addOrder(Order.asc("secondCName"));				
								    ar=(List<storeHouse>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return ar;
						 }
			 @SuppressWarnings("unchecked")
				public static List<outStoreHouse> selectOutStore(String userName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<outStoreHouse> ar=new ArrayList<outStoreHouse>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(outStoreHouse.class);
							criteria.add(Restrictions.eq("userName", userName));
							criteria.addOrder(Order.desc("applyDate"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
						    ar=(List<outStoreHouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
			@SuppressWarnings("unchecked")
			public static List<outStoreHouse> selectOutHouseByUserName(String userName,int outVerify,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<outStoreHouse> ar=new ArrayList<outStoreHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("outVerify", outVerify));
						criteria.addOrder(Order.desc("outDate"));
						criteria.addOrder(Order.asc("houseId"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
					    ar=(List<outStoreHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			@SuppressWarnings("unchecked")
			public static List<outStoreHouse> selectOutHouseByVerify(){
		 		 
				    Session session=null;	
				    List<outStoreHouse> ar=new ArrayList<outStoreHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);			
						criteria.add(Restrictions.eq("outVerify", 3));
						criteria.addOrder(Order.asc("applyDepartment"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("houseId"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));					
					    ar=(List<outStoreHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			@SuppressWarnings("unchecked")
			public static List<outStoreHouse> selectOutHouseByDepartment(String department){
		 		 
				    Session session=null;	
				    List<outStoreHouse> ar=new ArrayList<outStoreHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);			
						criteria.add(Restrictions.eq("outVerify", 3));
						criteria.add(Restrictions.eq("department", department));
						criteria.addOrder(Order.asc("applyDepartment"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("houseId"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));					
					    ar=(List<outStoreHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			@SuppressWarnings("unchecked")
			public static List<outStoreHouse> selectOutHouseByUserName(String userName){
		 		 
				    Session session=null;	
				    List<outStoreHouse> ar=new ArrayList<outStoreHouse>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(outStoreHouse.class);			
						criteria.add(Restrictions.eq("outVerify", 3));
						criteria.add(Restrictions.eq("userName", userName));
						criteria.addOrder(Order.asc("applyDepartment"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("houseId"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));					
					    ar=(List<outStoreHouse>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ar;
			 }
			 @SuppressWarnings("unchecked")
				public static void deleteStore(int aId){
			 		 
					    Session session=null;	
					    Transaction tx=null;	 
					    storeHouse ps=new storeHouse();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
				        	tx=session.beginTransaction();	
							ps=(storeHouse)session.get(storeHouse.class, aId);	
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
				public static void deleteOutStore(int aId){
			 		 
					    Session session=null;	
					    Transaction tx=null;	 
					    outStoreHouse ps=new outStoreHouse();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
				        	tx=session.beginTransaction();	
							ps=(outStoreHouse)session.get(outStoreHouse.class, aId);	
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
				public static int  selectMyStoreByOptionInt(String inDepartment,String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,int  inVerify,String userName,String inVerifyName){
			 		 
					    Session session=null;
					    int totalCount=0;  
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(storeHouse.class);	
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("inVerify", inVerify));
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(inDepartment))criteria.add(Restrictions.eq("inDepartment", inDepartment));
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
							if(!"".equals(inVerifyName)&!"0".equals(inVerifyName))criteria.add(Restrictions.eq("inVerifyName", inVerifyName));	
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
							}
						
							totalCount=criteria.list().size();	
						   
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return totalCount;
				 }
			 @SuppressWarnings("unchecked")
				public static int  selectMyStoreByOptionInt(List<String> collect,String inDepartment,String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,int  inVerify,String userName,String inVerifyName){
			 		 
					    Session session=null;
					    int totalCount=0;  
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(storeHouse.class);	
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("inVerify", inVerify));
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(inDepartment))criteria.add(Restrictions.eq("inDepartment", inDepartment));
							if(!"0".equals(houseId)){
								criteria.add(Restrictions.eq("houseId", houseId));	
							}else{
								criteria.add(Restrictions.in("houseId", collect));	
							}
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
							if(!"".equals(inVerifyName)&!"0".equals(inVerifyName))criteria.add(Restrictions.eq("inVerifyName", inVerifyName));	
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
							}
						
							totalCount=criteria.list().size();	
						   
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return totalCount;
				 }
			 
			 @SuppressWarnings("unchecked")
				public static int  selectMyOutStoreByOptionInt(String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,String userName){
			 		 
					    Session session=null;
					    int totalCount=0;  
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(outStoreHouse.class);	
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("applyDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("applyDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("applyDate", new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("applyDate", new Timestamp(d2.getTime()+86400000)));
							}
						
							totalCount=criteria.list().size();	
						   
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return totalCount;
				 }
			 @SuppressWarnings("unchecked")
				public static int  selectOutStoreByOptionInt(String applyDepartment,String userName,String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,int  outVerify){
			 		 
					    Session session=null;
					    int totalCount=0;  
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(outStoreHouse.class);	
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("outVerify", outVerify));
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
							}
						
							totalCount=criteria.list().size();	
						   
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return totalCount;
				 }
			 @SuppressWarnings("unchecked")
				public static int  selectOutStoreByOptionInt(List<String> collect,String applyDepartment,String userName,String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,int  outVerify){
			 		 
					    Session session=null;
					    int totalCount=0;  
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(outStoreHouse.class);	
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("outVerify", outVerify));
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(houseId)){
								criteria.add(Restrictions.eq("houseId", houseId));
							}else{
								criteria.add(Restrictions.in("houseId", collect));
							}
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
							}
						
							totalCount=criteria.list().size();	
						   
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return totalCount;
				 }
		
			 
			 @SuppressWarnings("unchecked")
				public static List<storeHouse> selectMyStoreByOption(String inDepartment,String department,String houseId,String firstCName,String secondCName,
						String addDateBegin,String addDateEnd,int inVerify ,String userName,String inVerifyName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<storeHouse> ep=new ArrayList<storeHouse>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(storeHouse.class);
							if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
							if(!"0".equals(inDepartment))criteria.add(Restrictions.eq("inDepartment", inDepartment));
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.add(Restrictions.eq("inVerify", inVerify));
							if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
							if(!"".equals(inVerifyName)&!"0".equals(inVerifyName))criteria.add(Restrictions.eq("inVerifyName", inVerifyName));		
							if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
								Date d2=CurrentDate.parseDate3(addDateEnd);						
								criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
								//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
							}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
							Date d1=CurrentDate.parseDate3(addDateBegin);
								criteria.add(Restrictions.ge("inDate",new Timestamp(d1.getTime())));
							}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
								Date d2=CurrentDate.parseDate3(addDateEnd);
								criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
							}
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.desc("inDate"));
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							
						    ep=(List<storeHouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ep;
				 }
				 @SuppressWarnings("unchecked")
					public static List<storeHouse> selectMyStoreByOption(String inDepartment,String department,String houseId,String firstCName,String secondCName,
							String addDateBegin,String addDateEnd,int inVerify ,String userName,String inVerifyName){
				 		 
						    Session session=null;	
						    List<storeHouse> ep=new ArrayList<storeHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(storeHouse.class);
								if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"0".equals(inDepartment))criteria.add(Restrictions.eq("inDepartment", inDepartment));
								if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
								criteria.add(Restrictions.eq("inVerify", inVerify));
								if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(inVerifyName)&!"0".equals(inVerifyName))criteria.add(Restrictions.eq("inVerifyName", inVerifyName));		
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("inDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<storeHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
				 @SuppressWarnings("unchecked")
					public static List<storeHouse> selectMyStoreByOption(List<String> collect,String inDepartment,String department,String houseId,String firstCName,String secondCName,
							String addDateBegin,String addDateEnd,int inVerify ,String userName,String inVerifyName,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<storeHouse> ep=new ArrayList<storeHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(storeHouse.class);
								if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"0".equals(inDepartment))criteria.add(Restrictions.eq("inDepartment", inDepartment));
								if(!"0".equals(houseId)){
									criteria.add(Restrictions.eq("houseId", houseId));	
								}else{
									criteria.add(Restrictions.in("houseId", collect));	
								}
								criteria.add(Restrictions.eq("inVerify", inVerify));
								if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(inVerifyName)&!"0".equals(inVerifyName))criteria.add(Restrictions.eq("inVerifyName", inVerifyName));		
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("inDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("inDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("inDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("inDate"));
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<storeHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
				
				 @SuppressWarnings("unchecked")
					public static List<outStoreHouse> selectMyOutStoreByOption(String department,String houseId,String firstCName,String secondCName,
							String addDateBegin,String addDateEnd,String userName,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<outStoreHouse> ep=new ArrayList<outStoreHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(outStoreHouse.class);
								if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
								if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("applyDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("applyDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("applyDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("applyDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("applyDate"));
								criteria.addOrder(Order.asc("department"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<outStoreHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
				 @SuppressWarnings("unchecked")
					public static List<outStoreHouse> selectOutStoreByOption(String applyDepartment,String userName,String department,String houseId,String firstCName,String secondCName,
						                                              	String addDateBegin,String addDateEnd,int  outVerify,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<outStoreHouse> ep=new ArrayList<outStoreHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(outStoreHouse.class);
								if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
								if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
								criteria.add(Restrictions.eq("outVerify", outVerify));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("outDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("outDate"));
								criteria.addOrder(Order.asc("applyDepartment"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<outStoreHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
					 @SuppressWarnings("unchecked")
						public static List<outStoreHouse> selectOutStoreByOption(String applyDepartment,String userName,String department,String houseId,String firstCName,String secondCName,
							                                              	String addDateBegin,String addDateEnd){
					 		 
							    Session session=null;	
							    List<outStoreHouse> ep=new ArrayList<outStoreHouse>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(outStoreHouse.class);
									if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
									if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
									if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
									if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
									criteria.add(Restrictions.eq("outVerify", 3));
									if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
									if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
									if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
										Date d1=CurrentDate.parseDate3(addDateBegin);
										Date d2=CurrentDate.parseDate3(addDateEnd);						
										criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
										criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
										//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
									}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
										criteria.add(Restrictions.ge("outDate",new Timestamp(d1.getTime())));
									}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
										Date d2=CurrentDate.parseDate3(addDateEnd);
										criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
									}
							
									criteria.addOrder(Order.asc("applyDepartment"));
									criteria.addOrder(Order.asc("department"));
									criteria.addOrder(Order.asc("houseId"));
									criteria.addOrder(Order.asc("firstCName"));
									criteria.addOrder(Order.asc("secondCName"));
									
								    ep=(List<outStoreHouse>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return ep;
						 }
					
					@SuppressWarnings("unchecked")
					public static List<outStoreHouse> selectOutStoreByOption(List<String> collect,String applyDepartment,String userName,String department,String houseId,String firstCName,String secondCName,
						                                              	String addDateBegin,String addDateEnd,int  outVerify,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<outStoreHouse> ep=new ArrayList<outStoreHouse>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(outStoreHouse.class);
								if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
								if(!"0".equals(userName)&&!"".equals(userName))criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"0".equals(houseId)){
									criteria.add(Restrictions.eq("houseId", houseId));						
								}else{
									criteria.add(Restrictions.in("houseId", collect));		
								}
								criteria.add(Restrictions.eq("outVerify", outVerify));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("outDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("outDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("outDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("outDate"));
								criteria.addOrder(Order.asc("applyDepartment"));
								criteria.addOrder(Order.asc("houseId"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<outStoreHouse>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
				
				@SuppressWarnings("unchecked")
				public static int selectStoreSize(String department,String systemName){
			 		 
					    Session session=null;	
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							criteria.add(Restrictions.eq("department",department));
							criteria.add(Restrictions.eq("systemName", systemName));	
						    i=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return i;
				 }
				@SuppressWarnings("unchecked")
				public static int selectStoreSizeByHouse(List<shouse> sh,String systemName){
			 		 
					    Session session=null;	
					    List<String> collect=new ArrayList<String>();	
					    if(sh!=null){
							for(shouse s :sh){
							   collect.add(String.valueOf(s.getId()));
							}
					    }
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
									criteria.add(Restrictions.eq("systemName", systemName));	
									criteria.add(Restrictions.in("houseId",collect));
									i=criteria.list().size();
									    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return i;
				 }
				@SuppressWarnings("unchecked")
				public static int selectStoreSize(String department,String houseId,String firstCName,String secondCName,String systemName){
			 		 
					    Session session=null;	
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							if(!"0".equals(department))criteria.add(Restrictions.eq("department",department));
							criteria.add(Restrictions.eq("systemName", systemName));	
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("id", Integer.valueOf(secondCName).intValue()));	
							i=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return i;
				 }
				@SuppressWarnings("unchecked")
				public static int selectStoreSize(List<String> collect,String department,String houseId,String firstCName,String secondCName,String systemName){
			 		 
					    Session session=null;	
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							if(!"0".equals(department))criteria.add(Restrictions.eq("department",department));
							criteria.add(Restrictions.eq("systemName", systemName));	
							if(!"0".equals(houseId)){
								criteria.add(Restrictions.eq("houseId", houseId));	
							}else{
								criteria.add(Restrictions.in("houseId", collect));	
							}
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("id", Integer.valueOf(secondCName).intValue()));	
							i=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return i;
				 }
				@SuppressWarnings("unchecked")
				public static List<secondClass> selectStore(String department,String systemName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<secondClass> sc=new ArrayList<secondClass>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							criteria.add(Restrictions.eq("department", department));
							criteria.add(Restrictions.eq("systemName", systemName));
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
						    sc=(List<secondClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return sc;
				 }	
				@SuppressWarnings("unchecked")
				public static List<secondClass> selectStoreByHouse(List<shouse> sh,String systemName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<secondClass> sc=new ArrayList<secondClass>();	
					    List<String> collect=new ArrayList<String>();	
					    if(sh!=null){
							for(shouse s :sh){
							   collect.add(String.valueOf(s.getId()));
							}
					    }
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							criteria.add(Restrictions.eq("systemName", systemName));
							criteria.add(Restrictions.in("houseId", collect));						
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
						    sc=(List<secondClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return sc;
				 }	
				@SuppressWarnings("unchecked")
				public static List<secondClass> selectStoreByOption(String department,String houseId,String firstCName,String secondCName,String systemName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<secondClass> sc=new ArrayList<secondClass>();			   	    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							if(!"0".equals(department))criteria.add(Restrictions.eq("department",department));
							criteria.add(Restrictions.eq("systemName", systemName));	
							if(!"0".equals(houseId))criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("id", Integer.valueOf(secondCName).intValue()));	
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sc=(List<secondClass>)criteria.list();								    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return sc;
				 }
				
				@SuppressWarnings("unchecked")
				public static List<secondClass> selectStoreByOption(List<String> collect,String department,String houseId,String firstCName,String secondCName,String systemName,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<secondClass> sc=new ArrayList<secondClass>();			   	    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							if(!"0".equals(department))criteria.add(Restrictions.eq("department",department));
							criteria.add(Restrictions.eq("systemName", systemName));	
							if(!"0".equals(houseId)){
								criteria.add(Restrictions.eq("houseId", houseId));	
							}else{
								criteria.add(Restrictions.in("houseId", collect));	
							}
							if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
							if(!"0".equals(secondCName))criteria.add(Restrictions.eq("id", Integer.valueOf(secondCName).intValue()));	
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sc=(List<secondClass>)criteria.list();								    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return sc;
				 }
				
				@SuppressWarnings("unchecked")
				public static int[][] selectInStoreCount1(String indp,String dp,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getInCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectInStoreCount1(List<String> collect,String indp,String dp,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(collect,dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(collect,dp, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getInCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectOutStoreCount(String dp,String applyDepartment,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
							criteria.add(Restrictions.eq("outVerify", 3));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(outStoreHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getApplyCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }				
				@SuppressWarnings("unchecked")
				public static int[][] selectOutStoreCount(List<String> collect,String dp,String applyDepartment,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(collect,dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(collect,dp, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
							criteria.add(Restrictions.eq("outVerify", 3));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(outStoreHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getApplyCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectInStoreCount1(String indp,String dp,String userName,String houseId,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.add(Restrictions.eq("department", dp));
							criteria.add(Restrictions.eq("houseId", houseId));	
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getInCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectOutStoreCount(String dp,String applyDepartment,String userName,String houseId,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId, system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(outStoreHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getApplyCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectInStoreCount(String indp,String dp,String userName,String houseId,String fcm,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,fcm,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,fcm,system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.add(Restrictions.eq("firstCName", fcm));	
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getInCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static int[][] selectOutStoreCount(String dp,String applyDepartment,String userName,String houseId,String fcm,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,fcm,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,fcm,system);
					   
					    int inStoreCount [][]=new int[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.add(Restrictions.eq("firstCName", fcm));	
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(outStoreHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getApplyCount();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				
				@SuppressWarnings("unchecked")
				public static int[]selectInStoreCount2(String indp,String userName,String scm,String system,String year){
			 		 
					    Session session=null;	
					   
					    int inStoreCount []=new int[12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("secondCName", scm));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						    sh=(List<storeHouse>)criteria.list();	

						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if((scm).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[j]=inStoreCount[j]+e1.getInCount();
								    	}
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				
				@SuppressWarnings("unchecked")
				public static int[]selectOutStoreCount1(String applyDepartment,String userName,String scm,String system,String year){
			 		 
					    Session session=null;	
					   
					    int inStoreCount []=new int[12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
							criteria.add(Restrictions.eq("secondCName", scm));
							criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
						    sh=(List<outStoreHouse>)criteria.list();	

						    	 for(int j=0;j<12;j++){
						    		 for(outStoreHouse e1 : sh){
						    			    if((scm).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
								    		inStoreCount[j]=inStoreCount[j]+e1.getApplyCount();
								    	}
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[][] selectInStoreExpenseCount1(String indp,String dp,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp, system);
					   
					    double inStoreCount [][]=new double[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getTotalPrice();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }
				@SuppressWarnings("unchecked")
				public static double[][] selectInStoreExpenseCount1(List<String> collect,String indp,String dp,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(collect,dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(collect,dp, system);
					   
					    double inStoreCount [][]=new double[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getTotalPrice();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[][] selectOutStoreExpenseCount(String dp,String applyDepartment,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp, system);
					   
					    double outStoreCount [][]=new double[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 int count1=0;
						    		 for(outStoreHouse e1 : sh){
						    			  
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
						    			    {
								    		  count1=count1+e1.getApplyCount();	
						    			    }
							         }
						    		 outStoreCount [i][j]=count1*sc.get(i).getUnitPrice();
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return outStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[][] selectOutStoreExpenseCount(List<String> collect,String dp,String applyDepartment,String userName,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(collect,dp,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(collect,dp, system);
					   
					    double outStoreCount [][]=new double[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 int count1=0;
						    		 for(outStoreHouse e1 : sh){
						    			  
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
						    			    {
								    		  count1=count1+e1.getApplyCount();	
						    			    }
							         }
						    		 outStoreCount [i][j]=count1*sc.get(i).getUnitPrice();
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return outStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[][] selectInStoreExpenseCount1(String indp,String dp,String userName,String houseId,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,system);
					   
					    double inStoreCount [][]=new double[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							criteria.add(Restrictions.eq("department", dp));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getTotalPrice();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
			
				@SuppressWarnings("unchecked")
				public static double[][] selectOutStoreExpenseCount(String dp,String applyDepartment,String userName,String houseId,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,system);
					   
					    double outStoreCount [][]=new double[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.addOrder(Order.asc("firstCName"));
						    sh=(List<outStoreHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 int count1=0;
						    		 for(outStoreHouse e1 : sh){
						    			  
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
						    			    {
								    		  count1=count1+e1.getApplyCount();	
						    			    }
							         }
						    		 outStoreCount [i][j]=count1*sc.get(i).getUnitPrice();
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return outStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[][] selectInStoreExpenseCount(String indp,String dp,String userName,String houseId,String fcm,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,fcm,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,fcm,system);
					   
					    double inStoreCount [][]=new double[count][12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.add(Restrictions.eq("firstCName", fcm));	
						    sh=(List<storeHouse>)criteria.list();	
						
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[i][j]=inStoreCount[i][j]+e1.getTotalPrice();
								    	}
						    	 }  	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				
				@SuppressWarnings("unchecked")
				public static double[][] selectOutStoreExpenseCount(String dp,String applyDepartment,String userName,String houseId,String fcm,String system,String year){
			 		 
					    Session session=null;	
					    int count=daoUtil.selectSecondClassSize(dp,houseId,fcm,system);
					    List<secondClass> sc=daoUtil.selectSecondClass6(dp,houseId,fcm,system);
					   
					    double outStoreCount [][]=new double[count][12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("department", dp));	
							criteria.add(Restrictions.eq("houseId", houseId));	
							criteria.addOrder(Order.asc("houseId"));
							criteria.add(Restrictions.eq("firstCName", fcm));	
						    sh=(List<outStoreHouse>)criteria.list();	
						    for(int i=0;i<sc.size();i++){
						    	 for(int j=0;j<12;j++){
						    		 int count1=0;
						    		 for(outStoreHouse e1 : sh){
						    			  
						    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
						    			    {
								    		  count1=count1+e1.getApplyCount();	
						    			    }
							         }
						    		 outStoreCount [i][j]=count1*sc.get(i).getUnitPrice();
						    	 }  	
						    }
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return outStoreCount;
				 }	
				@SuppressWarnings("unchecked")
				public static double[]selectInStoreExpenseCount2(String indp,String userName,String scm,String system,String year){
			 		 
					    Session session=null;	
					  
					    double inStoreCount []=new double[12];
					    List<storeHouse> sh=new ArrayList<storeHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(storeHouse.class);				
							criteria.add(Restrictions.eq("inVerify", 1));
							if(!"0".equals(indp))criteria.add(Restrictions.eq("inDepartment", indp));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("secondCName", scm));	
						    sh=(List<storeHouse>)criteria.list();	
						    	 for(int j=0;j<12;j++){
						    		 for(storeHouse e1 : sh){
						    			    if((scm).equals(e1.getSecondCName())&e1.getInDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getInDate().getMonth()==j)
								    		inStoreCount[j]=inStoreCount[j]+e1.getTotalPrice();
								    	}	
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return inStoreCount;
				 }	
				
				@SuppressWarnings("unchecked")
				public static double[]selectOutStoreExpenseCount1(String applyDepartment,String userName,String scm,String system,String year){
			 		 
					    Session session=null;	
					   secondClass sc=daoUtil.selectSecondClass3(Integer.valueOf(scm).intValue());
					    double outStoreCount []=new double[12];
					    List<outStoreHouse> sh=new ArrayList<outStoreHouse>();			
				        try {	      		        
				        	session=HibernateSessionFactory.getSession();
				        	Criteria criteria=session.createCriteria(outStoreHouse.class);				
				        	criteria.add(Restrictions.eq("outVerify", 3));
							if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
							if(!"0".equals(applyDepartment))criteria.add(Restrictions.eq("applyDepartment", applyDepartment));
							criteria.add(Restrictions.eq("secondCName", scm));	
						    sh=(List<outStoreHouse>)criteria.list();	
						    	 for(int j=0;j<12;j++){
						    		 int count1=0;
						    		 for(outStoreHouse e1 : sh){
						    			    if((scm).equals(e1.getSecondCName())&e1.getOutDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getOutDate().getMonth()==j)
						    			    	count1=count1+e1.getApplyCount();	
								    	}	
						    		 outStoreCount[j]=count1*sc.getUnitPrice();
						    }
							
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return outStoreCount;
				 }	
}
