package com.yz.manager.dao;

import java.sql.Timestamp;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yz.manager.bean.secondClass;
import com.yz.manager.bean.user;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.expense.bean.expense;
import com.yz.manager.hibernate.HibernateSessionFactory;


public class expenseDao {

	 public expenseDao(){
		 
	 }
	 
	 public static void addExpense(expense ep){
 		 
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
	 @SuppressWarnings("unchecked")
		public static int selectExpenseSize(String department){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("everify", 1));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static int selectExpenseSize(String department,String userName){
	 		 
			    Session session=null;	
			    int size=0;
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("userName", userName));
					criteria.add(Restrictions.eq("everify", 1));
				    size=criteria.list().size();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return size;
		 }
	 @SuppressWarnings("unchecked")
		public static List<expense> selectExpense(String department,int currentPage,int pageSize){
	 		 
			    Session session=null;	
			    List<expense> ep=new ArrayList<expense>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("everify", 1));
					criteria.setFirstResult((currentPage-1)*pageSize);
					criteria.setMaxResults(pageSize);
					criteria.addOrder(Order.desc("addDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
					
				    ep=(List<expense>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ep;
		 }
		@SuppressWarnings("unchecked")
		public static List<expense> selectExpense(){
	 		 
			    Session session=null;	
			    List<expense> ep=new ArrayList<expense>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);	
					criteria.add(Restrictions.eq("everify", 1));
					criteria.addOrder(Order.desc("addDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
					
				    ep=(List<expense>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ep;
		 }
		@SuppressWarnings("unchecked")
		public static List<expense> selectExpenseByDepartment(String department){
	 		 
			    Session session=null;	
			    List<expense> ep=new ArrayList<expense>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);
					criteria.add(Restrictions.eq("department", department));
					criteria.add(Restrictions.eq("everify", 1));
					criteria.addOrder(Order.desc("addDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
					
				    ep=(List<expense>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ep;
		 }
		@SuppressWarnings("unchecked")
		public static List<expense> selectExpenseByUserName(String userName){
	 		 
			    Session session=null;	
			    List<expense> ep=new ArrayList<expense>();			    
		        try {	      
		        	session=HibernateSessionFactory.getSession();
					Criteria criteria=session.createCriteria(expense.class);
					criteria.add(Restrictions.eq("userName", userName));
					criteria.add(Restrictions.eq("everify", 1));
					criteria.addOrder(Order.desc("addDate"));
					criteria.addOrder(Order.asc("firstCName"));
					criteria.addOrder(Order.asc("secondCName"));
					
				    ep=(List<expense>)criteria.list();					    
					} catch (HibernateException e) {			
					throw e;			
				}finally{
					if(session.isOpen()) session.close();
				}
				return ep;
		 }
		 @SuppressWarnings("unchecked")
			public static List<expense> selectExpense(String department,String userName,int currentPage,int pageSize){
		 		 
				    Session session=null;	
				    List<expense> ep=new ArrayList<expense>();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(expense.class);
						criteria.add(Restrictions.eq("department", department));
						criteria.add(Restrictions.eq("userName", userName));
						criteria.add(Restrictions.eq("everify", 1));
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ep=(List<expense>)criteria.list();					    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ep;
			 }
		 @SuppressWarnings("unchecked")
			public static expense selectExpense(String aId){
		 		 
				    Session session=null;	
				    expense ps=new expense();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						ps=(expense)session.get(expense.class, Integer.valueOf(aId).intValue());	    
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
		 @SuppressWarnings("unchecked")
			public static void deleteExpense(int aId){
		 		 
				    Session session=null;	
				    Transaction tx=null;	 
				    expense ps=new expense();			    
			        try {	      
			        	session=HibernateSessionFactory.getSession();
			        	tx=session.beginTransaction();	
						ps=(expense)session.get(expense.class, aId);	
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
			public static void modifyExpense(expense ex){
		 		 
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
			public static int  selectExpenseByOptionInt(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search,String nature,String company){
		 		 
				    Session session=null;
				    int totalCount=0;  
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(expense.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
						if(!"0".equals(company))criteria.add(Restrictions.eq("company", company));
						criteria.add(Restrictions.eq("everify", 1));
						criteria.add(Restrictions.eq("nature", nature));
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
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactPhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplier","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplierAddress","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("content","%"+search+"%"));					
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
			public static  List<expense> selectExpenseByOption(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search,String nature,String company,int currentPage,int pageSize){
		 		 
				    Session session=null;
				    List<expense> ps=new ArrayList<expense>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(expense.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));		
						if(!"0".equals(company))criteria.add(Restrictions.eq("company", company));
						criteria.add(Restrictions.eq("everify", 1));
						criteria.add(Restrictions.eq("nature", nature));
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
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactPhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplier","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplierAddress","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("content","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						
						criteria.setFirstResult((currentPage-1)*pageSize);
						criteria.setMaxResults(pageSize);
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("userName"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ps=(List<expense>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }
			@SuppressWarnings("unchecked")
			public static  List<expense> selectExpenseByOption(String department,String userName,String firstCName,String secondCName,
					String dateBegin,String dateEnd,String select,String search,String nature,String company){
		 		 
				    Session session=null;
				    List<expense> ps=new ArrayList<expense>();
			        try {	      
			        	session=HibernateSessionFactory.getSession();
						Criteria criteria=session.createCriteria(expense.class);
						if(!"0".equals(department))criteria.add(Restrictions.eq("department", department));
						if(!"0".equals(userName))criteria.add(Restrictions.eq("userName", userName));
						if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
						if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));		
						if(!"0".equals(company))criteria.add(Restrictions.eq("company", company));
						criteria.add(Restrictions.eq("everify", 1));
						criteria.add(Restrictions.eq("nature", nature));
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
						if("2".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("contactPhone","%"+search+"%"));					
						if("3".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplier","%"+search+"%"));					
						if("4".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("supplierAddress","%"+search+"%"));					
						if("5".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("content","%"+search+"%"));					
						if("6".equals(select)&null!=search&!"".equals(search))criteria.add(Restrictions.like("remarks","%"+search+"%"));					
						
						criteria.addOrder(Order.desc("addDate"));
						criteria.addOrder(Order.asc("department"));
						criteria.addOrder(Order.asc("userName"));
						criteria.addOrder(Order.asc("firstCName"));
						criteria.addOrder(Order.asc("secondCName"));
						
					    ps=(List<expense>)criteria.list();				
					   
						} catch (HibernateException e) {			
						throw e;			
					}finally{
						if(session.isOpen()) session.close();
					}
					return ps;
			 }

			 @SuppressWarnings("unchecked")
				public static int selectExpenseByVerifySize(String userName,int verify){
			 		 
					    Session session=null;	
					   int i=0;			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(expense.class);
							criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("everify", verify));
							criteria.addOrder(Order.desc("addDate"));
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
				public static List<expense> selectExpenseByVerify(String userName,int verify,int currentPage,int pageSize){
			 		 
					    Session session=null;	
					    List<expense> ar=new ArrayList<expense>();			    
				        try {	      
				        	session=HibernateSessionFactory.getSession();
							Criteria criteria=session.createCriteria(expense.class);
							criteria.add(Restrictions.eq("userName", userName));
							criteria.add(Restrictions.eq("everify", verify));
							criteria.addOrder(Order.desc("addDate"));
							criteria.addOrder(Order.asc("firstCName"));
							criteria.addOrder(Order.asc("secondCName"));
							criteria.setFirstResult((currentPage-1)*pageSize);
							criteria.setMaxResults(pageSize);
						    ar=(List<expense>)criteria.list();					    
							} catch (HibernateException e) {			
							throw e;			
						}finally{
							if(session.isOpen()) session.close();
						}
						return ar;
				 }
				 @SuppressWarnings("unchecked")
					public static int  selectApplyEpByOptionInt(String firstCName,String secondCName,
							String addDateBegin,String addDateEnd,int  everify,String userName){
				 		 
						    Session session=null;
						    int totalCount=0;  
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(expense.class);	
								criteria.add(Restrictions.eq("userName", userName));
								criteria.add(Restrictions.eq("everify", everify));		
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));	
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
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
					public static List<expense> selectApplyEpByOption(String firstCName,String secondCName,
							String addDateBegin,String addDateEnd,int everify ,String userName,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<expense> ep=new ArrayList<expense>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
								Criteria criteria=session.createCriteria(expense.class);
								criteria.add(Restrictions.eq("everify", everify));
								criteria.add(Restrictions.eq("userName", userName));
								if(!"0".equals(firstCName))criteria.add(Restrictions.eq("firstCName", firstCName));
								if(!"0".equals(secondCName))criteria.add(Restrictions.eq("secondCName", secondCName));
								if(!"".equals(addDateBegin)&!"".equals(addDateEnd)){
									Date d1=CurrentDate.parseDate3(addDateBegin);
									Date d2=CurrentDate.parseDate3(addDateEnd);						
									criteria.add(Restrictions.ge("addDate", new Timestamp(d1.getTime())));
									criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
									//criteria.add(Restrictions.between("saveArDate", new Timestamp(d1.getTime()), new Timestamp(d2.getTime())));
								}else if(!"".equals(addDateBegin)&"".equals(addDateEnd)){
								Date d1=CurrentDate.parseDate3(addDateBegin);
									criteria.add(Restrictions.ge("addDate",new Timestamp(d1.getTime())));
								}else if("".equals(addDateBegin)&!"".equals(addDateEnd)){								
									Date d2=CurrentDate.parseDate3(addDateEnd);
									criteria.add(Restrictions.lt("addDate", new Timestamp(d2.getTime()+86400000)));
								}
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
								criteria.addOrder(Order.desc("addDate"));
								criteria.addOrder(Order.asc("firstCName"));
								criteria.addOrder(Order.asc("secondCName"));
								
							    ep=(List<expense>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
					@SuppressWarnings("unchecked")
					public static int selectExpenseSize2(String name){
				 		 
						    Session session=null;	
						    int i=0;	    
					        try {	      
					        	session=HibernateSessionFactory.getSession();
					        	
					        	Criteria  criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everifyName", name));
								criteria.add(Restrictions.eq("everify", 0));
								criteria.addOrder(Order.desc("addDate"));
							    i=criteria.list().size();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return i;
					 }	
					@SuppressWarnings("unchecked")
					public static List<expense> selectExpense2(String name,int currentPage,int pageSize){
				 		 
						    Session session=null;	
						    List<expense> ep=new ArrayList<expense>();			    
					        try {	      
					        	session=HibernateSessionFactory.getSession();		       
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everifyName", name));
								criteria.add(Restrictions.eq("everify", 0));
								criteria.addOrder(Order.desc("addDate"));
								criteria.setFirstResult((currentPage-1)*pageSize);
								criteria.setMaxResults(pageSize);
							    ep=(List<expense>)criteria.list();					    
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return ep;
					 }
		
					@SuppressWarnings("unchecked")
					public static double[][] selectMonthExpenseCount(String dp){
				 		 
						    Session session=null;	
						    int count=daoUtil.selectUserCount(dp);
						    double expenseCount [][]=new double[count][12];
						    List<expense> ep=new ArrayList<expense>();	
						    List<user> us=new ArrayList<user>();	
					        try {	      
					        	us=daoUtil.selectUser2(dp);
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everify", 1));
								criteria.add(Restrictions.eq("department", dp));
							    ep=(List<expense>)criteria.list();	
							
							    for(int i=0;i<us.size();i++){
							    	 for(int j=0;j<12;j++){
							    		 for(expense e1 : ep){
							    			    if(us.get(i).getUserName().equals(e1.getUserName())&e1.getAddDate().getMonth()==j)
									    		expenseCount[i][j]=expenseCount[i][j]+e1.getTotalPrice();
									    	}
							    	 }  	
							    }
								
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return expenseCount;
					 }
		
					@SuppressWarnings("unchecked")
					public static double[][] selectMonthExpenseCountByOption(String dp,String year,String nature,String company){
				 		 
						    Session session=null;	
						    int count=daoUtil.selectUserCount(dp);
						    double expenseCount [][]=new double[count][12];
						    List<expense> ep=new ArrayList<expense>();	
						    List<user> us=new ArrayList<user>();	
					        try {	      
					        	us=daoUtil.selectUser2(dp);
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everify", 1));
								criteria.add(Restrictions.eq("department", dp));
								criteria.add(Restrictions.eq("nature", nature));
								if(!company.equals("0"))criteria.add(Restrictions.eq("company", company));
							    ep=(List<expense>)criteria.list();	
							
							    for(int i=0;i<us.size();i++){
							    	 for(int j=0;j<12;j++){
							    		 for(expense e1 : ep){
							    			    if(us.get(i).getUserName().equals(e1.getUserName())&e1.getAddDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getAddDate().getMonth()==j)
									    		expenseCount[i][j]=expenseCount[i][j]+e1.getTotalPrice();
									    	}
							    	 }  	
							    }
								
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return expenseCount;
					 }
					@SuppressWarnings("unchecked")
					public static double[] selectMonthExpenseCountByOption1(String userName,String year,String nature,String company){
				 		 
						    Session session=null;	
						    double expenseCount[]=new double[12];
						    List<expense> ep=new ArrayList<expense>();	
					        try {	           
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everify", 1));
								criteria.add(Restrictions.eq("nature", nature));
								criteria.add(Restrictions.eq("userName", userName));
								if(!company.equals("0"))criteria.add(Restrictions.eq("company", company));
							    ep=(List<expense>)criteria.list();	 
							    	 for(int j=0;j<12;j++){
							    		 for(expense e1 : ep){
							    			    if(e1.getAddDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getAddDate().getMonth()==j)
									    		expenseCount[j]=expenseCount[j]+e1.getTotalPrice();
									    	}		    
							    }
								
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return expenseCount;
					 }		
					
					@SuppressWarnings("unchecked")
					public static double[][] selectClassExpenseCount(String dp,String system,String year,String nature,String company){
				 		 
						    Session session=null;	
						    int count=daoUtil.selectSecondClassSize(dp,system);
						    List<secondClass> sc=daoUtil.selectAllSecondClass2(dp, system);
						    double expenseCount [][]=new double[count][12];
						    List<expense> ep=new ArrayList<expense>();			
					        try {	      		        
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everify", 1));
								criteria.add(Restrictions.eq("department", dp));
								criteria.add(Restrictions.eq("nature", nature));
								criteria.addOrder(Order.asc("firstCName"));
								if(!company.equals("0"))criteria.add(Restrictions.eq("company", company));
							    ep=(List<expense>)criteria.list();	
							
							    for(int i=0;i<sc.size();i++){
							    	 for(int j=0;j<12;j++){
							    		 for(expense e1 : ep){
							    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getAddDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getAddDate().getMonth()==j)
									    		expenseCount[i][j]=expenseCount[i][j]+e1.getTotalPrice();
									    	}
							    	 }  	
							    }
								
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return expenseCount;
					 }	
					
					@SuppressWarnings("unchecked")
					public static double[][] selectClassExpenseCount(String dp,String userName,String system,String year,String nature,String company){
				 		 
						    Session session=null;	
						    int count=daoUtil.selectSecondClassSize(dp,system);
						    List<secondClass> sc=daoUtil.selectAllSecondClass2(dp, system);
						    double expenseCount [][]=new double[count][12];
						    List<expense> ep=new ArrayList<expense>();			
					        try {	      		        
					        	session=HibernateSessionFactory.getSession();
					        	Criteria criteria=session.createCriteria(expense.class);				
								criteria.add(Restrictions.eq("everify", 1));
								criteria.add(Restrictions.eq("department", dp));
								criteria.add(Restrictions.eq("userName", userName));
								criteria.add(Restrictions.eq("nature", nature));
								criteria.addOrder(Order.asc("firstCName"));
								if(!company.equals("0"))criteria.add(Restrictions.eq("company", company));
							    ep=(List<expense>)criteria.list();	
							
							    for(int i=0;i<sc.size();i++){
							    	 for(int j=0;j<12;j++){
							    		 for(expense e1 : ep){
							    			    if(String.valueOf(sc.get(i).getId()).equals(e1.getSecondCName())&e1.getAddDate().getYear()+1900==Integer.valueOf(year).intValue()&e1.getAddDate().getMonth()==j)
									    		expenseCount[i][j]=expenseCount[i][j]+e1.getTotalPrice();
									    	}
							    	 }  	
							    }
								
								} catch (HibernateException e) {			
								throw e;			
							}finally{
								if(session.isOpen()) session.close();
							}
							return expenseCount;
					 }	
}
