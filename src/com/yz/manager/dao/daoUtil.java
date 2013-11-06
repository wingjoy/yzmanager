package com.yz.manager.dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.bean.department;
import com.yz.manager.bean.manager;
import com.yz.manager.bean.firstClass;
import com.yz.manager.bean.power;
import com.yz.manager.bean.secondClass;
import com.yz.manager.bean.system;
import com.yz.manager.bean.user;
import com.yz.manager.custom.bean.customArea;
import com.yz.manager.custom.bean.customState;
import com.yz.manager.custom.bean.customType;
import com.yz.manager.custom.bean.userArea;
import com.yz.manager.expense.bean.gCompany;
import com.yz.manager.expense.bean.payMode;
import com.yz.manager.hibernate.HibernateSessionFactory;
import com.yz.manager.storehouse.bean.houseManager;
import com.yz.manager.storehouse.bean.shouse;

public class daoUtil {

	 public daoUtil(){
		 
	 }
	 
	 public static void addDepartment(department dp){
		 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();			
				session.save(dp);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static void addpower(power pw){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();			
				session.save(pw);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static void updatepower(power pw){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();			
				session.update(pw);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static void updateFirstClass(firstClass fc){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();			
				session.update(fc);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static void updateSecondClass(secondClass sc){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();			
				session.update(sc);
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static void addManager(manager m){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	        	power pw=new power();
				pw=daoUtil.selectPower(m.getUserName());
				String name=daoUtil.selectUser(m.getUserName());
				session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(manager.class);
				criteria.add(Restrictions.eq("userName", m.getUserName().trim()));	
				manager m2=(manager)criteria.uniqueResult();		
				tx=session.beginTransaction();	
				if(m2!=null){
					m2.setDepartment(m.getDepartment());
					m2.setSystemManager(m.isSystemManager());
					m2.setDepartmentManager(m.isDepartmentManager());					
					if(m.isDepartmentManager()||m.isSystemManager()){						
						if(pw==null){
							pw=new power();
							pw.setUserName(m.getUserName());
							pw.setName(name);
							pw.setDepartment(m.getDepartment());
							pw.setAms(true);
							pw.setAmsadd(true);
							pw.setAmsdelete(true);
							pw.setAmsmodify(true);
							pw.setAmsselect(true);
							pw.setAmsSelectOther(true);
							pw.setAverify(true);
							
							pw.setPms(true);
							pw.setPmsadd(true);
							pw.setPmsdelete(true);
							pw.setPmsmodify(true);
							pw.setPmsselect(true);
							pw.setPmsSelectOther(true);
							
							pw.setEms(true);
							pw.setEmsadd(true);
							pw.setEmsdelete(true);
							pw.setEmsmodify(true);
							pw.setEmsselect(true);
							pw.setEmsSelectOther(true);
							
							pw.setIms(true);
							pw.setImsInRegister(true);
							pw.setImsOutRegister(true);
							session.update(m2);
							session.save(pw);
						}else{							
							pw.setAms(true);
							pw.setAmsadd(true);
							pw.setAmsdelete(true);
							pw.setAmsmodify(true);
							pw.setAmsselect(true);
							pw.setAmsSelectOther(true);
							pw.setAverify(true);
							
							pw.setPms(true);
							pw.setPmsadd(true);
							pw.setPmsdelete(true);
							pw.setPmsmodify(true);
							pw.setPmsselect(true);
							pw.setPmsSelectOther(true);
							
							pw.setEms(true);
							pw.setEmsadd(true);
							pw.setEmsdelete(true);
							pw.setEmsmodify(true);
							pw.setEmsselect(true);
							pw.setEmsSelectOther(true);
							
							pw.setIms(true);
							pw.setImsInRegister(true);
							pw.setImsOutRegister(true);
							session.update(m2);
							session.update(pw);
						}
						
					}
				}
				else{ 										
					if(m.isDepartmentManager()||m.isSystemManager()){										
						if(pw==null){
							pw=new power();
							pw.setUserName(m.getUserName());
							pw.setName(name);
							pw.setDepartment(m.getDepartment());
							pw.setAms(true);
							pw.setAmsadd(true);
							pw.setAmsdelete(true);
							pw.setAmsmodify(true);
							pw.setAmsselect(true);
							pw.setAmsSelectOther(true);
							pw.setAverify(true);
							
							pw.setPms(true);
							pw.setPmsadd(true);
							pw.setPmsdelete(true);
							pw.setPmsmodify(true);
							pw.setPmsselect(true);
							pw.setPmsSelectOther(true);
							
							pw.setEms(true);
							pw.setEmsadd(true);
							pw.setEmsdelete(true);
							pw.setEmsmodify(true);
							pw.setEmsselect(true);
							pw.setEmsSelectOther(true);
							
							pw.setIms(true);
							pw.setImsInRegister(true);
							pw.setImsOutRegister(true);
							session.save(m);
							session.save(pw);							
						}else{							
							pw.setAms(true);
							pw.setAmsadd(true);
							pw.setAmsdelete(true);
							pw.setAmsmodify(true);
							pw.setAmsselect(true);
							pw.setAmsSelectOther(true);
							pw.setAverify(true);
							
							pw.setPms(true);
							pw.setPmsadd(true);
							pw.setPmsdelete(true);
							pw.setPmsmodify(true);
							pw.setPmsselect(true);
							pw.setPmsSelectOther(true);
							
							pw.setEms(true);
							pw.setEmsadd(true);
							pw.setEmsdelete(true);
							pw.setEmsmodify(true);
							pw.setEmsselect(true);
							pw.setEmsSelectOther(true);
							
							pw.setIms(true);
							pw.setImsInRegister(true);
							pw.setImsOutRegister(true);
							session.save(m);
							session.update(pw);
							
						}						
					}
				}
				tx.commit();	
				
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 
	 public static power selectPower(String userName){
 		 
		    Session session=null;	     
	        power power =new power();
	        power=null;
	        try {
	      
				session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(power.class);
				criteria.add(Restrictions.eq("userName", userName.trim()));	
				power=(power)criteria.uniqueResult();		
			} catch (HibernateException e) {				
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
			return power;
	 }
	 
	 public static boolean adduser(user us){
 		    
		    boolean bl=false;
		    Session session=null;
	        Transaction tx=null;
	        user us1=new user();
	        try {	      
	        	session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(user.class);
				criteria.add(Restrictions.eq("userName", us.getUserName().trim()));
				
			    us1=(user)criteria.uniqueResult();				    
				} catch (HibernateException e) {			
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	        
			if(us1==null){
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();	
				power p=new power();
				p.setUserName(us.getUserName());
				p.setName(us.getName());
				p.setDepartment(us.getDepartment());
				p.setUser(us);
				session.save(us);
				session.save(p);
				tx.commit();
				bl=true;
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
			}
			
			return bl;
	 }
	 
	 public static void modifyUserPassword(user us){
   
		    Session session=null;
	        Transaction tx=null;	     
	        try {	      
	        	session=HibernateSessionFactory.getSession();
	        	tx=session.beginTransaction();
				session.save(us);
				tx.commit();
				} catch (HibernateException e) {			
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}	        		
	 }
	 public static void addsystem(system sys){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(sys);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }

	 public static Integer addfirstClass(firstClass fc){
 		 
		 Integer f = null;
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				f = (Integer) session.save(fc);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	        return f;
	 }
	 public static void addGCompany(gCompany g){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(g);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addCustomType(customType c){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(c);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addCustomState(customState c){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(c);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }

	 public static void addCustomArea(customArea c){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(c);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addUserArea(userArea c){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(c);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addShouse(shouse s){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();		
				tx=session.beginTransaction();	
				Criteria criteria=session.createCriteria(department.class);	
				criteria.add(Restrictions.eq("id", Integer.valueOf(s.getDepartment()).intValue()));
				department dp=(department)criteria.uniqueResult();
				if(dp.isHaveHouse()){
					session.save(s);	
				}else{
					dp.setHaveHouse(true);
					session.update(dp);
					session.save(s);	
				}			
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addHouseManager(houseManager s){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(s);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static void addPayMode(payMode g){
 		 
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				session.save(g);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	 }
	 public static Integer addsecondClass(secondClass sc){
		 Integer s = null;
		    Session session=null;
	        Transaction tx=null;	    
	        try {
	      
				session=HibernateSessionFactory.getSession();
			
				tx=session.beginTransaction();				
				s = (Integer) session.save(sc);				
				tx.commit();			
			} catch (HibernateException e) {
				if(tx!=null)tx.rollback();
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
	        return s;
	 }
	 
	 
	 @SuppressWarnings("unchecked")
	public static HashMap<String,String> selectDepartment(){
 		 
		    Session session=null;	
		    List<department> dp=new ArrayList<department>();
		    HashMap<String,String> map=new LinkedHashMap<String,String>();
	        try {	      
	        	session=HibernateSessionFactory.getSession();
				Criteria criteria=session.createCriteria(department.class);			
			    dp=(List<department>)criteria.list();	
			    if(dp!=null){			   
			    	for(department d : dp){
			   		
			    		map.put(String.valueOf(d.getDepartmentId()), d.getDepartment());
			    	}
			    }
				} catch (HibernateException e) {			
				throw e;			
			}finally{
				if(session.isOpen()) session.close();
			}
			return map;
	 }
	 @SuppressWarnings("unchecked")
		public static List<department> selectDepartment2(){
	 		 
			    Session session=null;	
			    List<department> dp=new ArrayList<department>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);			
				    dp=(List<department>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return dp;
		 } 
		 @SuppressWarnings("unchecked")
			public static List<gCompany> selectGCompany(){
		 		 
				    Session session=null;	
				    List<gCompany> g=new ArrayList<gCompany>();			   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(gCompany.class);			
					    g=(List<gCompany>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return g;
			 } 
			@SuppressWarnings("unchecked")
			public static List<customType> selectCustomType(){
		 		 
				    Session session=null;	
				    List<customType> g=new ArrayList<customType>();			   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customType.class);			
					    g=(List<customType>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return g;
			 } 
			@SuppressWarnings("unchecked")
			public static String selectCustomTypeName(int customType){
		 		 
				    Session session=null;	
				    customType g=new customType();	
				    String name="";
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customType.class);	
						criteria.add(Restrictions.eq("id", customType));
					    g=(customType)criteria.uniqueResult();	
					    name=g.getTypeName();
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return name;
			 } 
			@SuppressWarnings("unchecked")
			public static String selectCustomStateName(int customState){
		 		 
				    Session session=null;	
				    customState g=new customState();	
				    String name="";
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customState.class);	
						criteria.add(Restrictions.eq("id", customState));
					    g=(customState)criteria.uniqueResult();	
					    name=g.getStateName();
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return name;
			 } 
			@SuppressWarnings("unchecked")
			public static String selectCustomAreaName(int customArea){
		 		 
				    Session session=null;	
				    customArea g=new customArea();	
				    String name="";
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customArea.class);	
						criteria.add(Restrictions.eq("id", customArea));
					    g=(customArea)criteria.uniqueResult();	
					    name=g.getAreaName();
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return name;
			 } 
			@SuppressWarnings("unchecked")
			public static List<customState> selectCustomState(){
		 		 
				    Session session=null;	
				    List<customState> g=new ArrayList<customState>();			   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customState.class);			
					    g=(List<customState>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return g;
			 } 

			 @SuppressWarnings("unchecked")
				public static List<shouse> selectShouse(){
			 		 
					    Session session=null;	
					    List<shouse> s=new ArrayList<shouse>();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(shouse.class);			
						    s=(List<shouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return s;
				 }
				
				@SuppressWarnings("unchecked")
				public static List<shouse> selectShouseByDepartmentId(String department){
			 		 
					    Session session=null;	
					    List<shouse> s=new ArrayList<shouse>();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(shouse.class);	
							criteria.add(Restrictions.eq("department", department));
						    s=(List<shouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return s;
				 }
				@SuppressWarnings("unchecked")
				public static List<shouse> selectShouse(String dp){
			 		 
					    Session session=null;	
					    List<shouse> s=new ArrayList<shouse>();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(shouse.class);			
							criteria.add(Restrictions.eq("department",dp));	
							s=(List<shouse>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return s;
				 }
				@SuppressWarnings("unchecked")
				public static List<shouse> selectShouseManager(String userName){
			 		 
					    Session session=null;	
					    List<shouse> s=new ArrayList<shouse>();	
					    List<houseManager> hm=new ArrayList<houseManager>();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(houseManager.class);			
							criteria.add(Restrictions.eq("managerName",userName));	
							hm=(List<houseManager>)criteria.list();	
							if(hm!=null){
								for(houseManager m : hm){
									criteria=session.createCriteria(shouse.class);
									criteria.add(Restrictions.eq("id",Integer.valueOf(m.getHouseId()).intValue()));
                                    shouse s1=(shouse)criteria.uniqueResult();
                                    if(s1!=null){
                                    	s.add(s1);
                                    }
								}
							}
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return s;
				 }
				 @SuppressWarnings("unchecked")
					public static List<houseManager> selectHouseManager(){
				 		 
						    Session session=null;	
						    List<houseManager> s=new ArrayList<houseManager>();			   
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(houseManager.class);			
							    s=(List<houseManager>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return s;
					 }
					 @SuppressWarnings("unchecked")
						public static List<houseManager> selectHouseManager(String dp){
					 		 
							    Session session=null;	
							    List<houseManager> s=new ArrayList<houseManager>();			   
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(houseManager.class);			
									criteria.add(Restrictions.eq("department",dp));	
									s=(List<houseManager>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return s;
						 }
						@SuppressWarnings("unchecked")
						public static boolean selectHouseManagerByuser(String userName){
					 		 
							    Session session=null;	
							    List<houseManager> s=new ArrayList<houseManager>();	
							    boolean result=false;
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(houseManager.class);			
									criteria.add(Restrictions.eq("managerName",userName));	
									s=(List<houseManager>)criteria.list();	
									if (s!=null&s.size()!=0){
										result=true;
									}
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return result;
						 }
			 @SuppressWarnings("unchecked")
				public static gCompany selectGCompany(int id){
			 		 
					    Session session=null;	
					   gCompany g=new gCompany();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(gCompany.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(gCompany)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 @SuppressWarnings("unchecked")
				public static customType selectCustomType(int id){
			 		 
					    Session session=null;	
					    customType g=new customType();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(customType.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(customType)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 @SuppressWarnings("unchecked")
				public static customState selectCustomState(int id){
			 		 
					    Session session=null;	
					    customState g=new customState();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(customState.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(customState)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 @SuppressWarnings("unchecked")
				public static customArea selectCustomArea(int id){
			 		 
					    Session session=null;	
					    customArea g=new customArea();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(customArea.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(customArea)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 @SuppressWarnings("unchecked")
				public static shouse selectShouse(int id){
			 		 
					    Session session=null;	
					    shouse g=new shouse();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(shouse.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(shouse)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 @SuppressWarnings("unchecked")
				public static houseManager selectHouseManager(int id){
			 		 
					    Session session=null;	
					    houseManager g=new houseManager();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(houseManager.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(houseManager)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 }
			 
			 @SuppressWarnings("unchecked")
				public static String selectShouseName(int id){
			 		 
					    Session session=null;	
					    shouse g=new shouse();	
					    String name="";
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(shouse.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(shouse)criteria.uniqueResult();	
							name=g.getHouseName();
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return name;
				 }
			 @SuppressWarnings("unchecked")
				public static String selectGCompanyName(int id){
			 		 
					    Session session=null;
					    String name=null;
					   gCompany g=new gCompany();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(gCompany.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(gCompany)criteria.uniqueResult();
							name=g.getCompanyName();
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return name;
				 }
			 @SuppressWarnings("unchecked")
				public static payMode selectPayMode(int id){
			 		 
					    Session session=null;	
					    payMode g=new payMode();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(payMode.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(payMode)criteria.uniqueResult();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 } 
			 @SuppressWarnings("unchecked")
				public static String selectPayModeName(int id){
			 		 
					    Session session=null;	
					    payMode g=new payMode();
					    String name=null;
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(payMode.class);			
							criteria.add(Restrictions.eq("id",id));	
							g=(payMode)criteria.uniqueResult();	
							name=g.getModeName();
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return name;
				 } 
			 @SuppressWarnings("unchecked")
				public static HashMap<String,String> selectGCompanyMap(){
			 		 
					    Session session=null;	
					    List<gCompany> g=new ArrayList<gCompany>();
					    HashMap<String,String> map=new LinkedHashMap<String,String>();
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(gCompany.class);			
						    g=(List<gCompany>)criteria.list();	
						    if(g!=null){			   
						    	for(gCompany s : g){
						   		
						    		map.put(String.valueOf(s.getId()) , s.getCompanyName());
						    	}
						    }
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return map;
				 }
			 @SuppressWarnings("unchecked")
				public static List<payMode> selectPayMode(){
			 		 
					    Session session=null;	
					    List<payMode> g=new ArrayList<payMode>();			   
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(payMode.class);			
						    g=(List<payMode>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return g;
				 } 
				 @SuppressWarnings("unchecked")
					public static HashMap<String,String> selectPayModeMap(){
				 		 
						    Session session=null;	
						    List<payMode> g=new ArrayList<payMode>();
						    HashMap<String,String> map=new LinkedHashMap<String,String>();
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(payMode.class);			
							    g=(List<payMode>)criteria.list();	
							    if(g!=null){			   
							    	for(payMode s : g){
							   		
							    		map.put(String.valueOf(s.getId()) , s.getModeName());
							    	}
							    }
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return map;
					 }
		@SuppressWarnings("unchecked")
		public static List<department> selectDepartment2(int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<department> dp=new ArrayList<department>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    dp=(List<department>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return dp;
		 } 
		@SuppressWarnings("unchecked")
		public static List<customArea> selectCustomArea(int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<customArea> cs=new ArrayList<customArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(customArea.class);	
					criteria.addOrder(Order.asc("department"));	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    cs=(List<customArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		@SuppressWarnings("unchecked")
		public static List<userArea> selectUserAreaByOption(int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<userArea> cs=new ArrayList<userArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					criteria.addOrder(Order.asc("department"));	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    cs=(List<userArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		@SuppressWarnings("unchecked")
		public static List<userArea> selectUserArea(int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<userArea> cs=new ArrayList<userArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					criteria.addOrder(Order.asc("department"));	
					criteria.addOrder(Order.asc("userName"));	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    cs=(List<userArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		@SuppressWarnings("unchecked")
		public static List<customArea> selectUserAreaByUser(String dp,String userName){
	 		 
			    Session session=null;	
			    List<userArea> cs=new ArrayList<userArea>();
			    List<customArea> ca=new ArrayList<customArea>();	
			    customArea c1=new customArea();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					criteria.add(Restrictions.eq("userName", userName));		
					criteria.add(Restrictions.eq("department", dp));
				    cs=(List<userArea>)criteria.list();	
				    if(cs!=null){
				    	for(userArea c : cs){
				    		criteria=session.createCriteria(customArea.class);	
							criteria.add(Restrictions.eq("id",Integer.valueOf(c.getAreaName()).intValue() ));	
							c1=(customArea)criteria.uniqueResult();
							if(c1!=null){
								ca.add(c1);
							}
					    	
				    	}	
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ca;
		 } 
		@SuppressWarnings("unchecked")
		public static List<customArea> selectUserAreaByUser(){
	 		 
			    Session session=null;	
			    List<userArea> cs=new ArrayList<userArea>();
			    List<customArea> ca=new ArrayList<customArea>();	
			    customArea c1=new customArea();
			 
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);						
				    cs=(List<userArea>)criteria.list();	
				    if(cs!=null){
				    	for(userArea c : cs){
				    		criteria=session.createCriteria(customArea.class);	
							criteria.add(Restrictions.eq("id",Integer.valueOf(c.getAreaName()).intValue() ));	
							c1=(customArea)criteria.uniqueResult();
							if(c1!=null){
							    customArea c2=new customArea();
								c2.setId(c1.getId());
								c2.setAreaName(c1.getAreaName());
								c2.setDepartment(c.getUserName());
								ca.add(c2);
							}
					    	
				    	}	
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ca;
		 } 
		@SuppressWarnings("unchecked")
		public static  userArea selectUserArea1(String userName,String areaName,String department){
	 		 
			    Session session=null;	
			    userArea cs=new userArea();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					criteria.add(Restrictions.eq("userName", userName));
					criteria.add(Restrictions.eq("areaName", areaName));
					criteria.add(Restrictions.eq("department", department));
				    cs=(userArea)criteria.uniqueResult();				    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		 @SuppressWarnings("unchecked")
			public static int selectDepartmentSize(){
		 		 
				    Session session=null;	
				    int size=0;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(department.class);			
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 } 
		 @SuppressWarnings("unchecked")
			public static int selectCustomAreaSize(){
		 		 
				    Session session=null;	
				    int size=0;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customArea.class);			
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectCustomAreaSizeByOption(String dp){
		 		 
				    Session session=null;	
				    int size=0;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(customArea.class);	
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectUserAreaSizeByOption(String dp,String userName){
		 		 
				    Session session=null;	
				    int size=0;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(userArea.class);	
						if(!"0".equals(dp))criteria.add(Restrictions.eq("department", dp));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selecUserAreaSize(){
		 		 
				    Session session=null;	
				    int size=0;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(userArea.class);			
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 } 
		
		
		@SuppressWarnings("unchecked")
		public static List<String> selectDepartment4(){
	 		 
			    Session session=null;	
			    List<String> sdp=new ArrayList<String>();	
			    List<department> dp=new ArrayList<department>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);			
				    dp=(List<department>)criteria.list();	
				    if(dp!=null){
				    	for(department d:dp){
				    		sdp.add(d.getDepartment());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return sdp;
		 } 
		
		@SuppressWarnings("unchecked")
		public static List<department> selectDepartmentId(){
	 		 
			    Session session=null;				  
			    List<department> dp=new ArrayList<department>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);			
				    dp=(List<department>)criteria.list();					   
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return dp;
		 } 
		@SuppressWarnings("unchecked")
		public static List<department> selectHaveHouseDepartmentId(){
	 		 
			    Session session=null;				  
			    List<department> dp=new ArrayList<department>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);	
					criteria.add(Restrictions.eq("haveHouse",true));	
				    dp=(List<department>)criteria.list();					   
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return dp;
		 } 
		
		@SuppressWarnings("unchecked")
		public static department selectHaveHouseDepartmentByName(String name){
	 		 
			    Session session=null;				  
			    List<department> dp=new ArrayList<department>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);	
					criteria.add(Restrictions.eq("haveHouse",true));
					criteria.add(Restrictions.eq("department",name));	
				    dp=(List<department>)criteria.list();					   
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
		        if(dp.size()>0)
		        	return dp.get(0);
		        else
		        	return null;
		 } 
		 @SuppressWarnings("unchecked")
			public static String selectDepartment3(int dpId){
		 		 
				    Session session=null;	
				    String departmentName=null;		   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	department dp =(department)session.get(department.class, dpId);					  
					    if(dp!=null){			    
					    	departmentName=dp.getDepartment();
					    }
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return departmentName;
			 } 
		 @SuppressWarnings("unchecked")
			public static department selectDepartmentOne(int dpId){
		 		 
				    Session session=null;	
				   department dp=new department();	   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	dp =(department)session.get(department.class, dpId);					  	    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return dp;
			 } 
		 @SuppressWarnings("unchecked")
			public static manager selectManager(int mId){
		 		 
				    Session session=null;					 
				    manager m=new manager();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	m =(manager)session.get(manager.class, mId);					  					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return m;
			 } 
		 
		 @SuppressWarnings("unchecked")
			public static String selectDepartment5(String department){
		 		 
				    Session session=null;	
				    String departmentId=null;		   
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	Criteria criteria=session.createCriteria(department.class);
						criteria.add(Restrictions.eq("department",department));	
						department d=(department)criteria.uniqueResult();
					    if(d!=null){			    
					    	departmentId=String.valueOf(d.getDepartmentId());
					    }
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return departmentId;
			 } 
		 
		@SuppressWarnings("unchecked")
		public static List<user> selectUser(int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
					criteria.addOrder(Order.asc("department"));
				    us=(List<user>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 } 
		@SuppressWarnings("unchecked")
		public static List<user> selectUser(String department,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);	
				    us=(List<user>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 } 
		
		@SuppressWarnings("unchecked")
		public static List<user> selectUser(){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);			
				    us=(List<user>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 } 
		
		@SuppressWarnings("unchecked")
		public static int selectUserSize(){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);			
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 } 
		@SuppressWarnings("unchecked")
		public static int selectUserSize(String dp){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);
					criteria.add(Restrictions.eq("department", dp));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 } 
		@SuppressWarnings("unchecked")
		public static List<manager> selectManager(){
	 		 
			    Session session=null;	
			    List<manager> m=new ArrayList<manager>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(manager.class);			
				    m=(List<manager>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return m;
		 } 
		
		@SuppressWarnings("unchecked")
		public static manager  selectManager(String userName){
	 		 
			    Session session=null;	
			    manager m=new manager();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(manager.class);
					criteria.add(Restrictions.eq("userName",userName));
				    m=(manager)criteria.uniqueResult();	
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return m;
		 } 
		
		@SuppressWarnings("unchecked")
		public static List<user> selectUser2(String dp,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    us=(List<user>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 } 
		@SuppressWarnings("unchecked")
		public static List<customArea> selectCustomArea(String dp,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<customArea> cs=new ArrayList<customArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(customArea.class);	
					if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
					criteria.addOrder(Order.asc("department"));	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    cs=(List<customArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
	
		@SuppressWarnings("unchecked")
		public static List<userArea> selectUserArea(String dp,String userName,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<userArea> cs=new ArrayList<userArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					if(!"0".equals(dp))criteria.add(Restrictions.eq("department", dp));
					if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
					criteria.addOrder(Order.asc("department"));	
					criteria.addOrder(Order.asc("userName"));	
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
				    cs=(List<userArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		@SuppressWarnings("unchecked")
		public static List<customArea> selectAllCustomArea(){
	 		 
			    Session session=null;	
			    List<customArea> cs=new ArrayList<customArea>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(customArea.class);	
					criteria.addOrder(Order.asc("department"));	
				    cs=(List<customArea>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return cs;
		 } 
		@SuppressWarnings("unchecked")
		public static List<user> selectUser2(String dp){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					criteria.add(Restrictions.eq("department", dp));
					criteria.addOrder(Order.desc("userId"));
				    us=(List<user>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 } 
		@SuppressWarnings("unchecked")
		public static List<String> selectUserName(String dp){
	 		 
			    Session session=null;	
			    List<user> us=new ArrayList<user>();
			    List<String> au=new ArrayList<String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					criteria.add(Restrictions.eq("department", dp));
					criteria.addOrder(Order.desc("userId"));
				    us=(List<user>)criteria.list();	  
				      for(user u: us){
				    	 au.add(u.getName());
				      }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return au;
		}
		
		@SuppressWarnings("unchecked")
		public static int selectUser2Size(String dp){
	 		 
			    Session session=null;	
			    int size=0;			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 } 
		@SuppressWarnings("unchecked")
		public static int selectCustomAreaSize(String dp){
	 		 
			    Session session=null;	
			    int size=0;			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(customArea.class);	
					if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 } 
		@SuppressWarnings("unchecked")
		public static int selectUserAreaSize(String dp,String userName){
	 		 
			    Session session=null;	
			    int size=0;			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(userArea.class);	
					if(!"0".equals(dp))criteria.add(Restrictions.eq("department", dp));
					if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 } 
		@SuppressWarnings("unchecked")
		public static String selectUser(String username){
	 		 
			    Session session=null;	
			    String name=null;
			    user us=new user();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(user.class);	
					criteria.add(Restrictions.eq("userName", username));
				    us=(user)criteria.uniqueResult();	
				    name=us.getName();
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return name;
		 } 
		@SuppressWarnings("unchecked")
		public static String selectArea(String areaName){
	 		 
			    Session session=null;	
			    String name=null;
			    customArea ua=new customArea();			   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(customArea.class);	
					criteria.add(Restrictions.eq("id", Integer.valueOf(areaName).intValue()));
				    ua=(customArea)criteria.uniqueResult();	
				    name=ua.getAreaName();
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return name;
		 } 
		 @SuppressWarnings("unchecked")
			public static void deleteDepartment(int dpId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						
					    department dp =(department)session.get(department.class, dpId);					  
					    if(dp!=null){
					    	tx=session.beginTransaction();
					    	session.delete(dp);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 }
		 
		 @SuppressWarnings("unchecked")
			public static void deleteManager(int mId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						
					    manager m =(manager)session.get(manager.class, mId);					  
					    if(m!=null){
					    	tx=session.beginTransaction();
					    	session.delete(m);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 }
		 @SuppressWarnings("unchecked")
			public static void deleteHouseManager(int mId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						
			        	houseManager m =(houseManager)session.get(houseManager.class, mId);					  
					    if(m!=null){
					    	tx=session.beginTransaction();
					    	session.delete(m);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 }
		 
		 @SuppressWarnings("unchecked")
			public static void deleteUser(int usId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						
					   user us =(user)session.get(user.class, usId);					  
					    if(us!=null){
					    	tx=session.beginTransaction();
					    	session.delete(us.getPower());
					    	session.delete(us);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deletePower(String username){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						power pw=new power();				
						Criteria criteria=session.createCriteria(power.class);
						criteria.add(Restrictions.eq("userName", username));
					   	pw=(power)criteria.uniqueResult();		  
					    if(pw!=null){
					    	tx=session.beginTransaction();
					    	session.delete(pw);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
	
		 @SuppressWarnings("unchecked")
			public static void deleteFirstClass(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
						firstClass fc=(firstClass)session.get(firstClass.class, Integer.valueOf(fId).intValue());	
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("firstCName", fId));					
						List<secondClass> sc=(List<secondClass>)criteria.list();
					    if(fc!=null){
					    	tx=session.beginTransaction();
					    	session.delete(fc);
					    	for(secondClass s:sc){
					    		session.delete(s);
					    	}
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteCompany(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	gCompany g=(gCompany)session.get(gCompany.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteCustomType(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	customType g=(customType)session.get(customType.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteCustomState(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	customState g=(customState)session.get(customState.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteCustomArea(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	customArea g=(customArea)session.get(customArea.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteUserArea(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	userArea g=(userArea)session.get(userArea.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void deleteShouse(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	shouse g=(shouse)session.get(shouse.class, Integer.valueOf(fId).intValue());	
			        	Criteria criteria=session.createCriteria(shouse.class);	
						criteria.add(Restrictions.eq("department", g.getDepartment()));
						List<shouse> g1=(List<shouse>)criteria.list();
						tx=session.beginTransaction();
						if(g1.size()==1){
							criteria=session.createCriteria(department.class);	
							criteria.add(Restrictions.eq("id", Integer.valueOf(g.getDepartment()).intValue()));
							department d=(department)criteria.uniqueResult();
							d.setHaveHouse(false);
							session.update(d);
							session.delete(g);		
						}else{
							session.delete(g);		
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
			public static void deletePaymode(String fId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
			        	payMode g=(payMode)session.get(payMode.class, Integer.valueOf(fId).intValue());	
					    	tx=session.beginTransaction();
					    	session.delete(g);					    	
					    	tx.commit();
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 }
		 @SuppressWarnings("unchecked")
			public static void deleteSecondClass(String sId){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();									
						secondClass sc=(secondClass)session.get(secondClass.class, Integer.valueOf(sId).intValue());	
						
					    if(sc!=null){
					    	tx=session.beginTransaction();
					    	session.delete(sc);				   
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static user selectUser(int usId){
		 		       
				    Session session=null;
				    user us=new user();
			        try {	      
			        	session=HibernateSessionFactory.getSession();						
					    us =(user)session.get(user.class, usId);					  				    					 
						}catch (HibernateException e) {							
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
					return us;	
			 } 
		
		 
		 @SuppressWarnings("unchecked")
			public static void modifyDepartment(int dpId,String dpName){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						
					    department dp =(department)session.get(department.class, dpId);					  
					    if(dp!=null){
					    	dp.setDepartment(dpName);
					    	tx=session.beginTransaction();
					    	session.update(dp);
					    	tx.commit();
					    }
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 
		 @SuppressWarnings("unchecked")
			public static void modifyUser(user us){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(us);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyCompany(gCompany g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyCustomType(customType g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyCustomState(customState g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyCustomArea(customArea g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyShouse(shouse g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyHouseManager(houseManager g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 @SuppressWarnings("unchecked")
			public static void modifyPayMode(payMode g){
		 		       
				    Session session=null;
				    Transaction tx=null;
			        try {	      
			        	session=HibernateSessionFactory.getSession();							   					 
					    	tx=session.beginTransaction();
					    	session.update(g);
					    	tx.commit();					   
						}catch (HibernateException e) {
							if(tx!=null)tx.rollback();
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
			 } 
		 
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectSystem(){
	 		 
			    Session session=null;	
			    List<system> sys=new ArrayList<system>();
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    sys=(List<system>)criteria.list();	
				    if(sys!=null){			   
				    	for(system s : sys){
				   		
				    		map.put(String.valueOf(s.getSystemID()) , s.getSystemName());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectEverifyName(String dp){
	 		 
			    Session session=null;	
			    List<power> pw=new ArrayList<power>();
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(power.class);	
					criteria.add(Restrictions.eq("department", dp));
					criteria.add(Restrictions.eq("everify", true));
				    pw=(List<power>)criteria.list();	
				    if(pw!=null){			   
				    	for(power p : pw){
				   		    user u=new user ();
				   		    criteria=session.createCriteria(user.class);	
							criteria.add(Restrictions.eq("userName", p.getUserName()));
							u=(user)criteria.uniqueResult();
				    		map.put( u.getUserName(), u.getName());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectIverifyName(String dp){
	 		 
			    Session session=null;	
			    List<power> pw=new ArrayList<power>();
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(power.class);	
					criteria.add(Restrictions.eq("department", dp));
					criteria.add(Restrictions.eq("iverify", true));
				    pw=(List<power>)criteria.list();	
				    if(pw!=null){			   
				    	for(power p : pw){
				   		    user u=new user ();
				   		    criteria=session.createCriteria(user.class);	
							criteria.add(Restrictions.eq("userName", p.getUserName()));
							u=(user)criteria.uniqueResult();
				    		map.put( u.getUserName(), u.getName());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectAllIverifyName(){
	 		 
			    Session session=null;	
			    List<power> pw=new ArrayList<power>();
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(power.class);	
					criteria.add(Restrictions.eq("iverify", true));
				    pw=(List<power>)criteria.list();	
				    if(pw!=null){			   
				    	for(power p : pw){
				   		    user u=new user ();
				   		    criteria=session.createCriteria(user.class);	
							criteria.add(Restrictions.eq("userName", p.getUserName()));
							u=(user)criteria.uniqueResult();
				    		map.put( u.getUserName(), u.getName());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 @SuppressWarnings("unchecked")
		public static List<user> selectAllIverifyName1(){
	 		 
			    Session session=null;	
			    List<power> pw=new ArrayList<power>();
			    List<user> user=new ArrayList<user>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(power.class);	
					criteria.add(Restrictions.eq("iverify", true));
				    pw=(List<power>)criteria.list();	
				    if(pw!=null){			   
				    	for(power p : pw){
				   		    user u=new user ();
				   		    criteria=session.createCriteria(user.class);	
							criteria.add(Restrictions.eq("userName", p.getUserName()));
							u=(user)criteria.uniqueResult();
				    		user.add(u);
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return user;
		 }
		 @SuppressWarnings("unchecked")
			public static List<user> selectDpAllIverifyName(String dp){
		 		 
				    Session session=null;	
				    List<houseManager> pw=new ArrayList<houseManager>();
				    List<user> user=new ArrayList<user>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(houseManager.class);	
						criteria.add(Restrictions.eq("department", dp));
					    pw=(List<houseManager>)criteria.list();	
					    if(pw!=null){			   
					    	for(houseManager p : pw){
					   		    user u=new user ();
					   		    criteria=session.createCriteria(user.class);	
								criteria.add(Restrictions.eq("userName", p.getManagerName()));
								u=(user)criteria.uniqueResult();
					    		user.add(u);
					    	}
					    }
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return user;
			 }
		
		 @SuppressWarnings("unchecked")
			public static List<user> selectHouseVerifyName(String dp){
		 		 
				    Session session=null;	
				    List<power> pw=new ArrayList<power>();
				    List<user> user=new ArrayList<user>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(power.class);	
						criteria.add(Restrictions.eq("iverify", true));
						criteria.add(Restrictions.eq("department", dp));
					    pw=(List<power>)criteria.list();	
					    if(pw!=null){			   
					    	for(power p : pw){
					   		    user u=new user ();
					   		    criteria=session.createCriteria(user.class);	
								criteria.add(Restrictions.eq("userName", p.getUserName()));
								u=(user)criteria.uniqueResult();
					    		user.add(u);
					    	}
					    }
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return user;
			 }
			 @SuppressWarnings("unchecked")
				public static List<user> selectHouseManagerVerifyName(String houseId){
			 		 
					    Session session=null;	
					    List<houseManager> pw=new ArrayList<houseManager>();
					    List<user> user=new ArrayList<user>();
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(houseManager.class);	
							criteria.add(Restrictions.eq("houseId", houseId));
						    pw=(List<houseManager>)criteria.list();	
						    if(pw!=null){			   
						    	for(houseManager p : pw){
						   		    user u=new user ();
						   		    criteria=session.createCriteria(user.class);	
									criteria.add(Restrictions.eq("userName", p.getManagerName()));
									u=(user)criteria.uniqueResult();
						    		user.add(u);
						    	}
						    }
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return user;
				 }
			
				@SuppressWarnings("unchecked")
				public static List<user> selectHouseManagerVerifyName(){
			 		 
					    Session session=null;	
					    List<houseManager> pw=new ArrayList<houseManager>();
					    List<user> user=new ArrayList<user>();
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(houseManager.class);	
						    pw=(List<houseManager>)criteria.list();	
						    if(pw!=null){			   
						    	for(houseManager p : pw){
						   		    user u=new user ();
						   		    criteria=session.createCriteria(user.class);	
									criteria.add(Restrictions.eq("userName", p.getManagerName()));
									u=(user)criteria.uniqueResult();
									user u1=new user();
									u1.setUserName(u.getUserName());			
									u1.setName(u.getName());
									u1.setDepartment(p.getHouseId());
						    		user.add(u1);
						    	}
						    }
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return user;
				 }
	 @SuppressWarnings("unchecked")
		public static List<system> selectSystem4(){
	 		 
			    Session session=null;	
			    List<system> sys=new ArrayList<system>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    sys=(List<system>)criteria.list();	
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return sys;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static List<String> selectSystem2(){
	 		 
			    Session session=null;	
			    List<system> sys=new ArrayList<system>();
			   List<String> map=new ArrayList<String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    sys=(List<system>)criteria.list();	
				    if(sys!=null){			   
				    	for(system s : sys){
				   		
				    		map.add(s.getSystemName().trim());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectFirstClass(){
	 		 
			    Session session=null;	
			    List<firstClass> fc=new ArrayList<firstClass>();
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(firstClass.class);			
				    fc=(List<firstClass>)criteria.list();	
				    if(fc!=null){			   
				    	for(firstClass f : fc){
				   		
				    		map.put(f.getFirstCName(),f.getFirstCName());
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static List<firstClass> selectFirstClass2(){
	 		 
			    Session session=null;	
			    List<firstClass> fc=new ArrayList<firstClass>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(firstClass.class);	
					criteria.addOrder(Order.desc("department"));
					criteria.addOrder(Order.asc("systemName"));
				    fc=(List<firstClass>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return fc;
		 }
		 @SuppressWarnings("unchecked")
			public static List<firstClass> selectFirstClass2(int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<firstClass> fc=new ArrayList<firstClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.ne("systemName", "0"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("systemName"));
					    fc=(List<firstClass>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fc;
			 }
			 @SuppressWarnings("unchecked")
				public static List<firstClass> selectHouseFirstClass2(int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<firstClass> fc=new ArrayList<firstClass>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(firstClass.class);	
							criteria.add(Restrictions.eq("systemName", "0"));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
							criteria.addOrder(Order.asc("department"));
							criteria.addOrder(Order.asc("houseId"));
						    fc=(List<firstClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return fc;
				 }
				 @SuppressWarnings("unchecked")
					public static List<firstClass> selectHouseFirstClass2(String department,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("systemName", "0"));
								criteria.add(Restrictions.eq("department", department));
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
					
								criteria.addOrder(Order.asc("houseId"));
							    fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }
				 @SuppressWarnings("unchecked")
					public static List<firstClass> selectAllHouseFirstClass2ForHouseId(String houseId){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("systemName", "0"));
								criteria.add(Restrictions.eq("houseId", houseId));
								criteria.addOrder(Order.asc("department"));
							    fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }
					
					 @SuppressWarnings("unchecked")
						public static List<firstClass> selectAllHouseFirstClass2(){
					 		 
							    Session session=null;	
							    List<firstClass> fc=new ArrayList<firstClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(firstClass.class);	
									criteria.add(Restrictions.eq("systemName", "0"));
									criteria.addOrder(Order.asc("department"));
									criteria.addOrder(Order.asc("houseId"));
								    fc=(List<firstClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return fc;
						 }
			 @SuppressWarnings("unchecked")
				public static List<firstClass> selectFirstClass2(String dp,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<firstClass> fc=new ArrayList<firstClass>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(firstClass.class);
							criteria.add(Restrictions.ne("systemName", "0"));
							criteria.add(Restrictions.eq("department", dp));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);				
							criteria.addOrder(Order.asc("systemName"));
						    fc=(List<firstClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return fc;
				 }
			
		 @SuppressWarnings("unchecked")
			public static int selectFirstClassSize(){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.ne("systemName", "0"));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectHouseFirstClassSize(){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("systemName", "0"));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("houseId"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectHouseFirstClassSize(String department){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("systemName", "0"));
						criteria.add(Restrictions.eq("department", department));
						criteria.addOrder(Order.asc("houseId"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectFirstClassSize(String dp,String sys){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.ne("systemName", "0"));
						if(!"-1".equals(sys))criteria.add(Restrictions.eq("systemName", sys));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectHouseFirstClassSize(String dp,String s){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("systemName","0"));
						if(!"-1".equals(s))criteria.add(Restrictions.eq("houseId", s));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("houseId"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectFirstClassSize(String sys){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("systemName", sys));					
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectFirstClassSize1(String dp){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("department", dp));
						criteria.add(Restrictions.ne("systemName", "0"));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		 @SuppressWarnings("unchecked")
			public static int selectHouseFirstClassSize1(String dp){
		 		 
				    Session session=null;	
				    int size=0;			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("department", dp));
						criteria.add(Restrictions.eq("systemName", "0"));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("houseId"));
					    size=criteria.list().size();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return size;
			 }
		
		 @SuppressWarnings("unchecked")
			public static List<secondClass> selectSecondClass(){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
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
			public static List<secondClass> selectSecondClass(int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.ne("systemName", "0"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("systemName"));
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
			public static List<secondClass> selectHouseSecondClass(int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName","0"));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("department"));
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
			public static List<secondClass> selectDpHouseSecondClass(String dp,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName","0"));
						criteria.add(Restrictions.eq("department",dp));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("department"));
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
			public static List<secondClass> selectAllHouseSecondClass(){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName","0"));
						criteria.addOrder(Order.desc("department"));
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
			public static List<secondClass> selectAllHouseSecondClassForFirstClass(String firstCName){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName","0"));
						criteria.add(Restrictions.eq("firstCName", firstCName));
						criteria.addOrder(Order.desc("department"));
						criteria.addOrder(Order.asc("houseId"));
					    sc=(List<secondClass>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return sc;
			 }
			@SuppressWarnings("unchecked")
			public static List<secondClass> selectHouseSecondClass2(String fid,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName","0"));
						criteria.add(Restrictions.eq("firstCName",fid));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("department"));
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
			public static List<secondClass> selectDpSecondClass(String dp,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.ne("systemName", "0"));
						criteria.add(Restrictions.eq("department",dp));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.asc("systemName"));
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
			public static List<secondClass> selectSecondClass(String fid,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("firstCName", fid));
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
				public static int selectSecondClassSize(){
			 		 
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);		
							criteria.add(Restrictions.ne("systemName", "0"));
							size=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
			 @SuppressWarnings("unchecked")
				public static int selectSecondClassSizeByHouseId(String houseId){
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);		
							criteria.add(Restrictions.eq("systemName", "0"));
							criteria.add(Restrictions.eq("houseId", houseId));
							size=criteria.list().size();	
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
			 @SuppressWarnings("unchecked")
				public static int selectHouseSecondClassSize(){
			 		 
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);		
							criteria.add(Restrictions.eq("systemName", "0"));
							size=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
			 @SuppressWarnings("unchecked")
				public static int selectDpHouseSecondClassSize(String dp){
			 		 
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);		
							criteria.add(Restrictions.eq("systemName", "0"));
							criteria.add(Restrictions.eq("department", dp));
							size=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
			 @SuppressWarnings("unchecked")
				public static int selectHouseSecondClassSize2(String fid){
			 		 
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);		
							criteria.add(Restrictions.eq("systemName", "0"));
							criteria.add(Restrictions.eq("firstCName", fid));
							size=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
			 @SuppressWarnings("unchecked")
				public static int selectDpSecondClassSize(String dp){
			 		 
					    Session session=null;	
					    int size=0;		    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);
							criteria.add(Restrictions.ne("systemName", "0"));
							criteria.add(Restrictions.eq("department", dp));
							size=criteria.list().size();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return size;
				 }
	 
		 @SuppressWarnings("unchecked")
			public static List<firstClass> selectFirstClass2(String system){
		 		 
				    Session session=null;	
				    List<firstClass> fc=new ArrayList<firstClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);	
						criteria.add(Restrictions.eq("systemName", system));
						criteria.addOrder(Order.asc("department"));				
					    fc=(List<firstClass>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fc;
			 }
			
			
			@SuppressWarnings("unchecked")
			public static List<secondClass> selectSecondClass4(String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("systemName", system));
						criteria.addOrder(Order.asc("department"));	
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
			public static List<secondClass> selectSecondClass5(String department){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.addOrder(Order.asc("systemName"));
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
			public static List<secondClass> selectSecondClass6(String department,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("systemName", system));
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
			public static List<secondClass> selectSecondClass6(List<String> collect,String department,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("systemName", system));
						criteria.add(Restrictions.in("houseId", collect));
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
			public static List<secondClass> selectSecondClass61(String department,String houseId,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("systemName", system));
						criteria.add(Restrictions.eq("houseId", houseId));
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
			public static List<secondClass> selectSecondClass61(String department,String houseId,String fcm,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("systemName", system));
						criteria.add(Restrictions.eq("houseId", houseId));
						criteria.add(Restrictions.eq("firstCName", fcm));
					    sc=(List<secondClass>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return sc;
			 }
			@SuppressWarnings("unchecked")
			public static List<secondClass> selectSecondClass6(String department,String houseId,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("houseId", houseId));
						criteria.add(Restrictions.eq("systemName", system));
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
			public static List<secondClass> selectSecondClass6(String department,String houseId,String fcm,String system){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("houseId", houseId));
						criteria.add(Restrictions.eq("systemName", system));
						criteria.add(Restrictions.eq("firstCName", fcm));
					    sc=(List<secondClass>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return sc;
			 }
			@SuppressWarnings("unchecked")
			public static List<secondClass> selectSecondClass6(String dp,String sys,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.ne("systemName", "0"));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						if(!"-1".equals(sys))criteria.add(Restrictions.eq("systemName", sys));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
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
			public static List<secondClass> selectHouseSecondClass6(String dp,String s,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<secondClass> sc=new ArrayList<secondClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.eq("systemName", "0"));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						if(!"-1".equals(s))criteria.add(Restrictions.eq("houseId", s));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
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
			public static int selectSecondClass61(String dp,String sys){
		 		 
				    Session session=null;	
				    int total=0;		    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);
						criteria.add(Restrictions.ne("systemName", "0"));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						if(!"-1".equals(sys))criteria.add(Restrictions.eq("systemName", sys));
						total=criteria.list().size();		
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return total;
			 }
			@SuppressWarnings("unchecked")
			public static int selectHouseSecondClass61(String dp,String s){
		 		 
				    Session session=null;	
				    int total=0;		    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(secondClass.class);	
						criteria.add(Restrictions.eq("systemName", "0"));
						if(!"-1".equals(dp))criteria.add(Restrictions.eq("department", dp));
						if(!"-1".equals(s))criteria.add(Restrictions.eq("houseId", s));
						total=criteria.list().size();		
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return total;
			 }
			 @SuppressWarnings("unchecked")
				public static List<secondClass> selectSecondClass(String fId){
			 		 
					    Session session=null;	
					    List<secondClass> sc=new ArrayList<secondClass>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(secondClass.class);	
							criteria.add(Restrictions.eq("firstCName", fId));					
						    sc=(List<secondClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return sc;
				 }
				 @SuppressWarnings("unchecked")
					public static int selectSecondClassSize(String fId){
				 		 
						    Session session=null;	
						    int size=0;
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(secondClass.class);	
								criteria.add(Restrictions.eq("firstCName", fId));					
							    size=criteria.list().size();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return size;
					 }
				
				 @SuppressWarnings("unchecked")
					public static List<secondClass> selectSecondClassId(String department){
				 		 
						    Session session=null;	
						    List<secondClass> sc=new ArrayList<secondClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(secondClass.class);	
								criteria.add(Restrictions.eq("department", department));					
							    sc=(List<secondClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return sc;
					 }
					
					 @SuppressWarnings("unchecked")
						public static List<secondClass> selectSecondClassId2(String department,String systemName){
					 		 
							    Session session=null;	
							    List<secondClass> sc=new ArrayList<secondClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", systemName));	
								    sc=(List<secondClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return sc;
						 }
					 @SuppressWarnings("unchecked")
						public static List<secondClass> selectSecondClassId1(String department,String system){
					 		 
							    Session session=null;	
							    List<secondClass> sc=new ArrayList<secondClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", system));		
								    sc=(List<secondClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return sc;
						 }
						@SuppressWarnings("unchecked")
						public static int selectSecondClassSize(String department,String system){
					 		 
							    Session session=null;	
							    int size=0;		    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", system));
									
								    size=criteria.list().size();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return size;
						 }
						@SuppressWarnings("unchecked")
						public static int selectSecondClassSize(List<String> collect,String department,String system){
					 		 
							    Session session=null;	
							    int size=0;		    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", system));
									criteria.add(Restrictions.in("houseId", collect));
									
								    size=criteria.list().size();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return size;
						 }
						@SuppressWarnings("unchecked")
						public static int selectSecondClassSize(String department,String houseId,String system){
					 		 
							    Session session=null;	
							    int size=0;		    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("houseId", houseId));
									criteria.add(Restrictions.eq("systemName", system));
									
								    size=criteria.list().size();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return size;
						 }
						@SuppressWarnings("unchecked")
						public static int selectSecondClassSize(String department,String houseId,String fcm,String system){
					 		 
							    Session session=null;	
							    int size=0;		    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("houseId", houseId));
									criteria.add(Restrictions.eq("systemName", system));
									criteria.add(Restrictions.eq("firstCName", fcm));
								    size=criteria.list().size();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return size;
						 }
					 @SuppressWarnings("unchecked")
						public static List<secondClass> selectAllSecondClass(String systemName){
					 		 
							    Session session=null;	
							    List<secondClass> sc=new ArrayList<secondClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("systemName", systemName));					
								    sc=(List<secondClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return sc;
						 }
						@SuppressWarnings("unchecked")
						public static List<secondClass> selectAllSecondClass2(String department,String systemName){
					 		 
							    Session session=null;	
							    List<secondClass> sc=new ArrayList<secondClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(secondClass.class);	
									criteria.add(Restrictions.eq("systemName", systemName));
									criteria.add(Restrictions.eq("department", department));
									criteria.addOrder(Order.asc("firstCName"));	
									criteria.addOrder(Order.asc("id"));	
								    sc=(List<secondClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return sc;
						 }

				 @SuppressWarnings("unchecked")
					public static String selectSecondClass2(String sId){
				 		    String fcn=null;
						    Session session=null;	
						    secondClass sc=new secondClass();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								sc=(secondClass)session.get(secondClass.class,Integer.valueOf(sId).intValue());
								fcn=sc.getFirstCName();	    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fcn;
					 }
				 
				 @SuppressWarnings("unchecked")
					public static String selectSecondClass8(String sId){
				 		    String fcn=null;
						    Session session=null;	
						    secondClass sc=new secondClass();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								sc=(secondClass)session.get(secondClass.class,Integer.valueOf(sId).intValue());
								if(sc==null){
									fcn = "";
								}else{
									fcn=sc.getSecondCName();	    
								}
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fcn;
					 }
				 
				 @SuppressWarnings("unchecked")
					public static String selectSecondClass2(String fId,String scn){
				 		    String scId=null;
						    Session session=null;	
						    secondClass sc=new secondClass();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(secondClass.class);	
								criteria.add(Restrictions.eq("firstCName", fId)); 
								criteria.add(Restrictions.eq("secondCName", scn)); 
								sc=(secondClass)criteria.uniqueResult();
								scId=String.valueOf(sc.getId());
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return scId;
					 }
				 
				 @SuppressWarnings("unchecked")
					public static secondClass selectSecondClass3(int sId){	 		 
						    Session session=null;	
						    secondClass sc=new secondClass();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								sc=(secondClass)session.get(secondClass.class,sId);							
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return sc;
					 }
				
			 @SuppressWarnings("unchecked")
				public static List<firstClass> selectFirstClass3(String department){
			 		 
					    Session session=null;	
					    List<firstClass> fc=new ArrayList<firstClass>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(firstClass.class);	
							criteria.add(Restrictions.eq("department", department));			
						    fc=(List<firstClass>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return fc;
				 }
				 @SuppressWarnings("unchecked")
					public static List<firstClass> selectHouseFirstClass3(String department){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("department", department));	
								criteria.add(Restrictions.eq("systemName", "0"));			
							    fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }
				
				 @SuppressWarnings("unchecked")
					public static int selectFirstClassSize3(String department){
				 		 
						    Session session=null;	
						    int size=0;			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.ne("systemName", "0"));
								criteria.add(Restrictions.eq("department", department));
								criteria.addOrder(Order.asc("department"));				
							    size=criteria.list().size();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return size;
					 }

				 @SuppressWarnings("unchecked")
					public static List<firstClass> selectFirstClass3(String department,String system,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.ne("systemName", "0"));
								if(!"-1".equals(department))criteria.add(Restrictions.eq("department", department));
								if(!"-1".equals(system))criteria.add(Restrictions.eq("systemName", system));	
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("department"));
								criteria.addOrder(Order.asc("systemName"));
								fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }	
					 @SuppressWarnings("unchecked")
						public static List<firstClass> selectHouseFirstClass3(String department,String s,int currentPage,int pageSize){
					 		 
							    Session session=null;	
							    List<firstClass> fc=new ArrayList<firstClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(firstClass.class);	
									criteria.add(Restrictions.eq("systemName", "0"));	
									if(!"-1".equals(department))criteria.add(Restrictions.eq("department", department));
									if(!"-1".equals(s))criteria.add(Restrictions.eq("houseId", s));	
									criteria.setFirstResult((currentPage-1)*pageSize);
									criteria.setMaxResults(pageSize);
									criteria.addOrder(Order.desc("department"));
									criteria.addOrder(Order.asc("houseId"));
									fc=(List<firstClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return fc;
						 }	
					@SuppressWarnings("unchecked")
					public static List<firstClass> selectFirstClass3(String system,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("systemName", system));
								criteria.addOrder(Order.desc("department"));
								criteria.addOrder(Order.asc("systemName"));
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
							    fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }	
					@SuppressWarnings("unchecked")
					public static List<firstClass> selectFirstClass31(String dp,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("department", dp));	
								criteria.add(Restrictions.ne("systemName", "0"));
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("department"));
								criteria.addOrder(Order.asc("systemName"));
								fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }	
					@SuppressWarnings("unchecked")
					public static List<firstClass> selectHouseFirstClass31(String dp,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<firstClass> fc=new ArrayList<firstClass>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(firstClass.class);	
								criteria.add(Restrictions.eq("department", dp));	
								criteria.add(Restrictions.eq("systemName", "0"));
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("department"));
								criteria.addOrder(Order.asc("houseId"));
								fc=(List<firstClass>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return fc;
					 }	
					 @SuppressWarnings("unchecked")
						public static List<firstClass> selectFirstClass3(String department,String system){
					 		 
							    Session session=null;	
							    List<firstClass> fc=new ArrayList<firstClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(firstClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", system));						
									criteria.addOrder(Order.asc("houseId"));
									criteria.addOrder(Order.asc("id"));
									fc=(List<firstClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return fc;
						 }	
						@SuppressWarnings("unchecked")
						public static List<firstClass> selectFirstClass3(List<String> collect,String department,String system){
					 		 
							    Session session=null;	
							    List<firstClass> fc=new ArrayList<firstClass>();			    
						        try {	      
						        	session=HibernateSessionFactory.getSession();
									Criteria criteria=session.createCriteria(firstClass.class);	
									criteria.add(Restrictions.eq("department", department));
									criteria.add(Restrictions.eq("systemName", system));
									criteria.add(Restrictions.in("houseId", collect));	
									criteria.addOrder(Order.asc("houseId"));
									criteria.addOrder(Order.asc("id"));
									fc=(List<firstClass>)criteria.list();					    
									} catch (HibernateException e) {			
									throw e;			
								}finally{
									if(session.isOpen()) session.close();
								}
								return fc;
						 }	
						 @SuppressWarnings("unchecked")
							public static List<firstClass> selectFirstClass3(String department,String houseId,String system){
						 		 
								    Session session=null;	
								    List<firstClass> fc=new ArrayList<firstClass>();			    
							        try {	      
							        	session=HibernateSessionFactory.getSession();
										Criteria criteria=session.createCriteria(firstClass.class);	
										criteria.add(Restrictions.eq("department", department));
										criteria.add(Restrictions.eq("systemName", system));
										criteria.add(Restrictions.eq("houseId", houseId));
										criteria.addOrder(Order.asc("id"));
										fc=(List<firstClass>)criteria.list();					    
										} catch (HibernateException e) {			
										throw e;			
									}finally{
										if(session.isOpen()) session.close();
									}
									return fc;
							 }	
				
	 @SuppressWarnings("unchecked")
		public static List<String> selectFirstClass(String department,String systemName){
	 		 
			    Session session=null;	
			    List<firstClass> fc=new ArrayList<firstClass>();
			    List<String> ls=new ArrayList<String>();
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(firstClass.class);
					criteria.add(Restrictions.eq("department", department.trim()));
					criteria.add(Restrictions.eq("systemName", systemName.trim()));
				    fc=(List<firstClass>)criteria.list();	
				    if(fc!=null){			   
				    	for(firstClass f : fc){
				   		 ls.add(f.getFirstCName());				    		
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ls;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static List<firstClass> selectFirstClassId(String department,String systemName){
	 		 
			    Session session=null;	
			    List<firstClass> fc=new ArrayList<firstClass>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(firstClass.class);
					criteria.add(Restrictions.eq("department", department.trim()));
					criteria.add(Restrictions.eq("systemName", systemName.trim()));
				    fc=(List<firstClass>)criteria.list();					   
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return fc;
		 }
		 @SuppressWarnings("unchecked")
			public static List<firstClass> selectFirstClassId(String systemName){
		 		 
				    Session session=null;	
				    List<firstClass> fc=new ArrayList<firstClass>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("systemName", systemName.trim()));
					    fc=(List<firstClass>)criteria.list();					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fc;
			 }
		 
		
	 @SuppressWarnings("unchecked")
		public static HashMap<String,String> selectFirstClassMap(String department,String systemName){
	 		 
			    Session session=null;	
			    HashMap<String,String> map=new LinkedHashMap<String,String>();
			    List<firstClass> fc=new ArrayList<firstClass>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(firstClass.class);
					criteria.add(Restrictions.eq("department", department.trim()));
					criteria.add(Restrictions.eq("systemName", systemName.trim()));
				    fc=(List<firstClass>)criteria.list();	
				    if(fc!=null){			   
				    	for(firstClass f : fc){
				   		 map.put(String.valueOf(f.getId()),f.getFirstCName());				    		
				    	}
				    }
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return map;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static firstClass selectFirstClass4(int fId){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    firstClass fc=new firstClass();
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
				    fc=(firstClass)session.get(firstClass.class, fId);									    
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fc;
		 } 
	 
	 @SuppressWarnings("unchecked")
		public static String  selectSystem2(int sId){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    String systemName=null;
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
		        	system s=(system)session.get(system.class, sId);	
		        	systemName=s.getSystemName();
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return systemName;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static String  selectSystem3(String system){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    String systemId=null;
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
		        	Criteria criteria=session.createCriteria(system.class);						
					criteria.add(Restrictions.eq("systemName", system));
					system s=(system)criteria.uniqueResult();
		        	systemId=String.valueOf(s.getSystemID());
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return systemId;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static String  selectFirstClass5(String fcn){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    String fcnId=null;
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
		        	Criteria criteria=session.createCriteria(firstClass.class);						
					criteria.add(Restrictions.eq("firstCName", fcn));
					firstClass s=(firstClass)criteria.uniqueResult();
		        	fcnId=String.valueOf(s.getId());
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fcnId;
		 }	 
	 @SuppressWarnings("unchecked")
		public static String  selectFirstClass5(String sys,String dp,String fcn){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    String fcnId=null;
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
		        	Criteria criteria=session.createCriteria(firstClass.class);						
					criteria.add(Restrictions.eq("firstCName", fcn));
					criteria.add(Restrictions.eq("systemName", sys));
					criteria.add(Restrictions.eq("department", dp));
					firstClass s=(firstClass)criteria.uniqueResult();
		        	fcnId=String.valueOf(s.getId());
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fcnId;
		 }	 
	 @SuppressWarnings("unchecked")
		public static String  selectFirstClass5(int sId){
	 		       
			    Session session=null;
			    Transaction tx=null;
			    String fcn=null;
		        try {	      
		        	session=HibernateSessionFactory.getSession();									
		        	firstClass s=(firstClass)session.get(firstClass.class, sId);	
		        	if(s==null){
		        		fcn="";
		        	}else{
		        		fcn=s.getFirstCName();
		        	}
					}catch (HibernateException e) {
						if(tx!=null)tx.rollback();
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return fcn;
		 } 
	 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, HashMap<String,String>>  selectDoubleFirstClass(){
	 		 
			    Session session=null;	
			    HashMap<String, HashMap<String,String>> dfc = new LinkedHashMap<String, HashMap<String,String>>();
			    List<system> sys=new ArrayList<system>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    sys=(List<system>)criteria.list();					  
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				if (sys!=null){
					for(system s: sys){
						session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("systemName", s.getSystemName().trim()));
						List<firstClass> sc=(List<firstClass>)criteria.list();
						if(sc!=null){
							HashMap<String,String> map=new LinkedHashMap<String,String>();
							for(firstClass f:sc){
								map.put(f.getFirstCName().trim(), f.getFirstCName().trim());
							}
							dfc.put(s.getSystemName().trim(), map);
						}
						
					}
				}
		//		System.out.println("dfc"+dfc);
				return dfc;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleFirstClass2(){
	 		 
			    Session session=null;	
			    HashMap<String, List<String>> dfc = new LinkedHashMap<String, List<String>>();
			    List<system> fc=new ArrayList<system>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    fc=(List<system>)criteria.list();					  
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				if (fc!=null){
					for(system f: fc){
						session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("systemName", String.valueOf(f.getSystemID())));
						List<firstClass> sc=(List<firstClass>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(firstClass s:sc){
								map.add(s.getFirstCName().trim());
							}
							dfc.put(f.getSystemName(), map);
						}
						
					}
				}
				return dfc;
		 }
		 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleFirstClass2(String dpId){
	 		 
			    Session session=null;	
			    HashMap<String, List<String>> dfc = new LinkedHashMap<String, List<String>>();
			    List<system> fc=new ArrayList<system>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(system.class);			
				    fc=(List<system>)criteria.list();					  
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				if (fc!=null){
					for(system f: fc){
						session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("systemName", String.valueOf(f.getSystemID())));
						criteria.add(Restrictions.eq("department", dpId));
						List<firstClass> sc=(List<firstClass>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(firstClass s:sc){
								map.add(s.getFirstCName().trim());
							}
							dfc.put(f.getSystemName(), map);
						}
						
					}
				}
				return dfc;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleSecondClass(List<String> fc,String department,String systemName){
		        Session session=null;
		        HashMap<String, List<String>> dfc = new LinkedHashMap<String, List<String>>();
				if (fc!=null){
					for(String f: fc){
						
						session=HibernateSessionFactory.getSession();
						Criteria criteria=null;
						criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("department", department.trim()));
						criteria.add(Restrictions.eq("systemName", systemName.trim()));
						criteria.add(Restrictions.eq("firstCName", f.toString()));
						firstClass f1=(firstClass)criteria.uniqueResult();
						String fcn=String.valueOf(f1.getId());
						
						criteria=session.createCriteria(secondClass.class);						
						//criteria.add(Restrictions.eq("department", department.trim()));
						//criteria.add(Restrictions.eq("systemName", systemName.trim()));
						criteria.add(Restrictions.eq("firstCName", fcn));
						List<secondClass> sc=(List<secondClass>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(secondClass s:sc){
								map.add(s.getSecondCName().trim());
							}
							dfc.put(f, map);
						}
						
					}
				}
				return dfc;
		 }
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleSecondClassMap(HashMap<String,String> fc){
		        Session session=null;
		        HashMap<String, List<String>> dfc = new LinkedHashMap<String, List<String>>();
				if (fc!=null){				
					Iterator<String> iterator=fc.keySet().iterator();
					if(iterator.hasNext()){
						String fId=iterator.next();
						session=HibernateSessionFactory.getSession();
						Criteria criteria=null;
						/**
						criteria=session.createCriteria(firstClass.class);						
						criteria.add(Restrictions.eq("department", department.trim()));
						criteria.add(Restrictions.eq("systemName", systemName.trim()));
						criteria.add(Restrictions.eq("firstCName", fname));
						firstClass f1=(firstClass)criteria.uniqueResult();
						String fcn=String.valueOf(f1.getId());
						*/
						criteria=session.createCriteria(secondClass.class);						
						criteria.add(Restrictions.eq("firstCName", fId));
						List<secondClass> sc=(List<secondClass>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(secondClass s:sc){
								map.add(s.getSecondCName().trim());
							}
							dfc.put(fId, map);
						}
						
					}
				}
				return dfc;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleUser(){
	 		 
			    Session session=null;	
			    HashMap<String, List<String>> sus= new LinkedHashMap<String, List<String>>();
			    List<department> dp=new ArrayList<department>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);			
				    dp=(List<department>)criteria.list();					  
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				if (dp!=null){
					for(department d: dp){
						session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(user.class);						
						criteria.add(Restrictions.eq("department", String.valueOf(d.getDepartmentId())));
						List<user> sc=(List<user>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(user s:sc){
								map.add(s.getUserName());
							}
							sus.put(d.getDepartment(), map);
						}
						
					}
				}
				return sus;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static  HashMap<String, List<String>>  selectDoubleUser2(){
	 		 
			    Session session=null;	
			    HashMap<String, List<String>> sus= new LinkedHashMap<String, List<String>>();
			    List<department> dp=new ArrayList<department>();	   
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(department.class);			
				    dp=(List<department>)criteria.list();					  
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				if (dp!=null){
					for(department d: dp){
						session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(power.class);						
						criteria.add(Restrictions.eq("department", String.valueOf(d.getDepartmentId())));
						criteria.add(Restrictions.eq("averify", true));
						List<power> sc=(List<power>)criteria.list();
						if(sc!=null){
							List<String> map=new ArrayList<String>();
							for(power s:sc){
								map.add(s.getUserName().trim());
							}
							sus.put(d.getDepartment(), map);
						}
						
					}
				}
				return sus;
		 }
	 
	 @SuppressWarnings("unchecked")
		public static  List<user>  selectDoubleUserId(){
	 		 
			    Session session=null;	
			    List <user> us=new ArrayList<user>();
			    List<power> pw=new ArrayList<power>();
			 try{
			    session=HibernateSessionFactory.getSession();						
				Criteria criteria=session.createCriteria(power.class);						
				criteria.add(Restrictions.eq("averify", true));
				pw=(List<power>)criteria.list();
					for(power p: pw){
						user u1=new user();
					    criteria=session.createCriteria(user.class);						
						criteria.add(Restrictions.eq("userName", p.getUserName()));
						u1=(user)criteria.uniqueResult();	
						us.add(u1);
						}
			    }catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 }
		@SuppressWarnings("unchecked")
		public static  List<user>  selectDoubleUserId(String dp){
	 		 
			    Session session=null;	
			    List <user> us=new ArrayList<user>();
			    List<power> pw=new ArrayList<power>();
			 try{
			    session=HibernateSessionFactory.getSession();						
				Criteria criteria=session.createCriteria(power.class);						
				criteria.add(Restrictions.eq("averify", true));
				criteria.add(Restrictions.eq("department", dp));
				pw=(List<power>)criteria.list();
					for(power p: pw){
						user u1=new user();
					    criteria=session.createCriteria(user.class);						
						criteria.add(Restrictions.eq("userName", p.getUserName()));
						u1=(user)criteria.uniqueResult();	
						us.add(u1);
						}
			    }catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return us;
		 }
		
		@SuppressWarnings("unchecked")
		public static int  selectUserCount(String dp){
			    Session session=null;	
			    int count=0;			   	
				 try {	      
					    session=HibernateSessionFactory.getSession();						
						Criteria criteria=session.createCriteria(user.class);						
						criteria.add(Restrictions.eq("department", dp));
					    count=criteria.list().size();					  
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return count;
		 }
		 
		 
}
