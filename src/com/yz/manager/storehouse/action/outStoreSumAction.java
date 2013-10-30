package com.yz.manager.storehouse.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.yz.manager.bean.power;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.shouse;
public class outStoreSumAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private String userName;
	 private String department;
	 private String houseId;
	 private String firstCName;
	 private String secondCName;	
	 private String year;
	 private String content;
	 private String applyDepartment;

	public String getApplyDepartment() {
		return applyDepartment;
	}
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {	
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		user u=(user)session.getAttribute("us");
		 power pw=u.getPower();
	       List<shouse> sh1=new ArrayList<shouse>();
	      if(pw.isSystemManager()){
		        sh1=daoUtil.selectShouse();	
		    }else if (pw.isDepartmentManager()){
	          sh1=daoUtil.selectShouse(u.getDepartment());	
	      }else{
	        sh1=daoUtil.selectShouseManager(u.getUserName());	
	      }
	      List<String> collect=new ArrayList<String>();	
		    if(sh1!=null){
				for(shouse s :sh1){
				   collect.add(String.valueOf(s.getId()));
				}
		    }
		String system="0";
		String result="";
		    if("0".equals(this.getApplyDepartment())&"0".equals(this.getDepartment())&"0".equals(this.getUserName())
		       &"0".equals(this.getHouseId())&"0".equals(this.getFirstCName())
		       &"0".equals(this.getSecondCName())){
		    	 if("1".equals(this.getContent())){
		    		 int[][] sum=storeHouseDao.selectOutStoreCount(collect,u.getDepartment(),"0","0",system, this.getYear());
		    		 request.setAttribute("dp",u.getDepartment());
		    		 request.setAttribute("adp",u.getDepartment());
		    		 request.setAttribute("sum", sum);
		    		 request.setAttribute("name", "");
		    		 result="sumCount";
		    	 }else if("0".equals(this.getContent())){
		    		 double[][] sum=storeHouseDao.selectOutStoreExpenseCount(collect,u.getDepartment(),"0","0",system, this.getYear());
		    		 request.setAttribute("sum", sum);
		    		 request.setAttribute("dp",u.getDepartment());
		    		 request.setAttribute("adp",u.getDepartment());
		    		 request.setAttribute("name", "");
		    		 result="sumExpenseCount";
		    	 }
		    	
		    }else if(!"0".equals(this.getDepartment())
				       &"0".equals(this.getHouseId())&"0".equals(this.getFirstCName())
				       &"0".equals(this.getSecondCName())){
				    	 if("1".equals(this.getContent())){
				    		 int[][] sum=storeHouseDao.selectOutStoreCount(collect,this.getDepartment(),this.getApplyDepartment(),this.getUserName(),system, this.getYear());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("sum", sum);
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumCount";
				    	 }else if("0".equals(this.getContent())){
				    		 double[][] sum=storeHouseDao.selectOutStoreExpenseCount(collect,this.getDepartment(),this.getApplyDepartment(),this.getUserName(),system, this.getYear());
				    		 request.setAttribute("sum", sum);
				    		 request.setAttribute("dp",this.getDepartment());
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumExpenseCount";
				    	 }    	
		    }else if(!"0".equals(this.getDepartment())
				       &!"0".equals(this.getHouseId())&"0".equals(this.getFirstCName())
				       &"0".equals(this.getSecondCName())){
				    	 if("1".equals(this.getContent())){
				    		 int[][] sum=storeHouseDao.selectOutStoreCount(this.getDepartment(),this.getApplyDepartment(),this.getUserName(),this.getHouseId(),system, this.getYear());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("sum", sum);
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumCount1";
				    	 }else if("0".equals(this.getContent())){
				    		 double[][] sum=storeHouseDao.selectOutStoreExpenseCount(this.getDepartment(),this.getApplyDepartment(),this.getUserName(),this.getHouseId(),system, this.getYear());
				    		 request.setAttribute("sum", sum);
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumExpenseCount1";
				    	 }
				    	
			}else if(!"0".equals(this.getDepartment())
				       &!"0".equals(this.getHouseId())&!"0".equals(this.getFirstCName())
				       &"0".equals(this.getSecondCName())){
				    	 if("1".equals(this.getContent())){
				    		 int[][] sum=storeHouseDao.selectOutStoreCount(this.getDepartment(),this.getApplyDepartment(),this.getUserName(),this.getHouseId(),this.getFirstCName(),system, this.getYear());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("fcm",this.getFirstCName());
				    		 request.setAttribute("sum", sum);
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumCount2";
				    	 }else if("0".equals(this.getContent())){
				    		 double[][] sum=storeHouseDao.selectOutStoreExpenseCount(this.getDepartment(),this.getApplyDepartment(),this.getUserName(),this.getHouseId(),this.getFirstCName(),system, this.getYear());
				    		 request.setAttribute("sum", sum);
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("fcm",this.getFirstCName());
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumExpenseCount2";
				    	 }
				    	
			}else if(!"0".equals(this.getDepartment())
				       &!"0".equals(this.getHouseId())&!"0".equals(this.getFirstCName())
				       &!"0".equals(this.getSecondCName())){
				    	 if("1".equals(this.getContent())){
				    		 int[]sum=storeHouseDao.selectOutStoreCount1(this.getApplyDepartment(),this.getUserName(),this.getSecondCName(),system, this.getYear());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("fcm",this.getFirstCName());
				    		 request.setAttribute("scm",this.getSecondCName());
				    		 request.setAttribute("sum", sum);
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumCount3";
				    	 }else if("0".equals(this.getContent())){
				    		 double[]sum=storeHouseDao.selectOutStoreExpenseCount1(this.getApplyDepartment(),this.getUserName(),this.getSecondCName(),system, this.getYear());
				    		 request.setAttribute("sum", sum);
				    		 request.setAttribute("hId",this.getHouseId());
				    		 request.setAttribute("dp",this.getDepartment());
				    		 request.setAttribute("fcm",this.getFirstCName());
				    		 request.setAttribute("scm",this.getSecondCName());
				    		 if("0".equals(this.getUserName())){
				    			 request.setAttribute("name", "");
				    		 } else if(!"0".equals(this.getUserName())){
				    			 request.setAttribute("name", this.getUserName());
				    		 }
				    		 if("0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", "");
				    		 } else if(!"0".equals(this.getApplyDepartment())){
				    			 request.setAttribute("adp", this.getApplyDepartment());
				    		 }
				    		 result="sumExpenseCount3";
				    	 }
				    	
			}

	        return result;
	     
	}
	@Override
	public void validate() {
		  
		  if("0".equals(this.getDepartment())&!"0".equals(this.getApplyDepartment())){
			  this.addFieldError("departmentnull", "库房部门不能为空");
		  }
	}
	
}
