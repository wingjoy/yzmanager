package com.yz.manager.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class CurrentDate {

	public static  String getCurrentDate() {  
		
	  	  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   	 
	  	  return sim.format(new Date());   	
	  	 	 	
	      }

	public static  String getCurrentDate2() {  
		
	  	  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");   	 
	  	  return sim.format(new Date());   	
	  	 	 	
	      }
	public static  String getCurrentDate4() {  
		
	  	  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	  	  Date date=new Date();
	  	  return sim.format(new Timestamp(date.getTime()));   	
	  	 	 	
	      }
	public static  String getCurrentDate3() {  
		
	  	  SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss");   	 
	  	  return sim.format(new Date());   	
	  	 	 	
	      }
	public static int getCurrentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
		
	}
	public static int getCurrentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH)+1;
		
	}
	public static int getCurrentDay(){
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
	}
	public static int getCurrentAPm(){
		return Calendar.getInstance().get(Calendar.AM_PM);
		
	}
	public static int getCurrentWeek(){
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		
	}
	public static Date parseDate(String date){
		Date mydate=null; 
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); 
			mydate=sim.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mydate;
	}
	public static Date parseDate2(String date){
		Date mydate=null; 
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			mydate=sim.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mydate;
	}
	public static Date parseDate3(String date){
		Date mydate=null; 
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); 
			mydate=sim.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mydate;
	}
	
	public static String parseDate1(String date){
		Date mydate=null; 
		String d=null;
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); 
			mydate=sim.parse(date);
			d=sim.format(mydate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static String parseDate4(String date){
		Date mydate=null; 
		String d=null;
		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			mydate=sim.parse(date);
			d=sim.format(mydate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
  
