package com.yz.manager.storehouse.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.power;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.storehouse.bean.outStoreHouse;

public class outSelectByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String applyDepartment;
	private String department;
	private String houseId;
	private String firstCName;
	private String secondCName;
	private String addDateBegin;	
	private String addDateEnd;
	private String outVerify;
	private String userName;
	
	public String getApplyDepartment() {
		return applyDepartment;
	}
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	public String getOutVerify() {
		return outVerify;
	}
	public void setOutVerify(String outVerify) {
		this.outVerify = outVerify;
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
	public String getAddDateBegin() {
		return addDateBegin;
	}
	public void setAddDateBegin(String addDateBegin) {
		this.addDateBegin = addDateBegin;
	}
	public String getAddDateEnd() {
		return addDateEnd;
	}
	public void setAddDateEnd(String addDateEnd) {
		this.addDateEnd = addDateEnd;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpSession session=request.getSession();
		   session.setAttribute("dp1",request.getParameter("department").trim());
		   session.setAttribute("sh1",request.getParameter("houseId").trim());
		   session.setAttribute("fc1",request.getParameter("firstCName").trim());
		   session.setAttribute("sc1",request.getParameter("secondCName").trim());
		   session.setAttribute("sdb",request.getParameter("addDateBegin").trim());      
		   session.setAttribute("sde",request.getParameter("addDateEnd").trim()); 
		   session.setAttribute("adp",request.getParameter("applyDepartment").trim()); 
		   session.setAttribute("vnm",request.getParameter("userName").trim());   
		   int currentPage = 1;
		   if(request.getParameter("currentPage")!=null){
			   currentPage = Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
		   }		     
			int pageSize=15;
			String bg="";
			String ed="";
			bg=this.getAddDateBegin();
			ed=this.getAddDateEnd();
		   if("1".equals(request.getParameter("export"))){

				HttpServletResponse response = ServletActionContext.getResponse();
				user us=new user();
				power pw=new power();
				us=(user)session.getAttribute("us");
				pw=us.getPower();
				try {
					//File exp = new File(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"outStore"+"\\"+us.getUserName()+"outStore.xls"));		
					
					/*if(exp.exists()){
						exp.delete();
						exp.getParentFile().mkdirs();
					}else{
						exp.getParentFile().mkdirs();
					}*/
					response.setContentType("application/vnd ms-excel");
					response.setHeader("Content-Disposition","attachment; filename="+new String("出库导出.xls".getBytes("UTF-8"),"iso8859-1"));
					OutputStream outf = response.getOutputStream();//new FileOutputStream(exp);
					WritableWorkbook book=Workbook.createWorkbook(outf);
					  List<outStoreHouse> sh=storeHouseDao.selectOutStoreByOption(this.getApplyDepartment(),this.getUserName(),this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),
								bg,ed,Integer.valueOf(this.getOutVerify()).intValue(),0,10000);
				     WritableSheet sheet=book.createSheet("第一页",0);
				     Label label=new Label(0,0,"序号");
				     Label label1=new Label(1,0,"出库日期");
				     Label label2=new Label(2,0,"领用部门");
				     Label label3=new Label(3,0,"领用人");
				     Label label4=new Label(4,0,"库房部门");
				     Label label5=new Label(5,0,"库房名称");
				     Label label6=new Label(6,0,"物品分类");
				     Label label7=new Label(7,0,"物品名称");
				     Label label8=new Label(8,0,"用途");
				     Label label9=new Label(9,0,"领用数量");
				     Label label10=new Label(10,0,"单位");
				     Label label11=new Label(11,0,"部门审核人");
				     Label label12=new Label(12,0,"部门审核人意见");
				     Label label13=new Label(13,0,"库房审核人");
				     Label label14=new Label(14,0,"库房审核人意见");
				     Label label15=new Label(15,0,"库管员审核");
				     Label label16=new Label(16,0,"库管员审核意见");
				     Label label17=new Label(17,0,"领用备注");
				    
				     sheet.addCell(label);	
				     sheet.addCell(label1);	
				     sheet.addCell(label2);	
				     sheet.addCell(label3);	
				     sheet.addCell(label4);	
				     sheet.addCell(label5);	
				     sheet.addCell(label6);	
				     sheet.addCell(label7);	
				     sheet.addCell(label8);	
				     sheet.addCell(label9);	
				     sheet.addCell(label10);
				     sheet.addCell(label11);	
				     sheet.addCell(label12);	
				     sheet.addCell(label13);	
				     sheet.addCell(label14);	
				     sheet.addCell(label15);	
				     sheet.addCell(label16);	
				     sheet.addCell(label17);	
				    
				     int i=1;
				     for(outStoreHouse p :sh){
				    	 int k=0;
				    	 
				    	    String shn=daoUtil.selectShouseName(Integer.valueOf(p.getHouseId()).intValue());
				    	    String fc=daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue());
				    	    String sc=daoUtil.selectSecondClass8(p.getSecondCName());     
				    	    String gd=daoUtil.selectDepartment3(Integer.valueOf(p.getDepartment()).intValue());
				    	    String sgd=daoUtil.selectDepartment3(Integer.valueOf(p.getApplyDepartment()).intValue());
				    	  String sname="";
				          String bname="";
				          String kname="";
				          String kgname="";
				         sname=daoUtil.selectUser(p.getUserName().trim());
				    	    if(!"0".equals(p.getInVerifyName().trim())){
				    	       bname=daoUtil.selectUser(p.getInVerifyName().trim());
				    	    }
				             if(!"0".equals(p.getHouseVerifyName().trim())){
				    	        kname=daoUtil.selectUser(p.getHouseVerifyName().trim());
				    	    }
				    	    if(!"0".equals(p.getHouseManager().trim())){
				    	        kgname=daoUtil.selectUser(p.getHouseManager().trim());
				    	    }
				    	  Label b=new Label(k++,i,String.valueOf(i));
			              Label b1=new Label(k++,i,CurrentDate.parseDate4(p.getOutDate().toString()));
			              Label b2=new Label(k++,i,sgd);
			              Label b3=new Label(k++,i,sname); 
			              Label b4=new Label(k++,i,gd); 
			              Label b5=new Label(k++,i,shn); 
			              Label b6=new Label(k++,i,fc); 
			              Label b7=new Label(k++,i,sc); 
			              Label b8=new Label(k++,i,p.getPurpose()); 
			              Label b9=new Label(k++,i,String.valueOf(p.getApplyCount()));
			              Label b10=new Label(k++,i,p.getUnit()); 
			              Label b11=new Label(k++,i,bname); 
			              Label b12=new Label(k++,i,p.getInVerifyRemarks()); 
			              Label b13=new Label(k++,i,kname); 
			              Label b14=new Label(k++,i,p.getHouseVerifyRemarks()); 
			              Label b15=new Label(k++,i,kgname); 
			              Label b16=new Label(k++,i,p.getHouseManagerRemarks()); 
			              Label b17=new Label(k++,i,p.getOutRemarks()); 
			             
			            
			              sheet.addCell(b);	
			              sheet.addCell(b1);		
			              sheet.addCell(b2);		
			              sheet.addCell(b3);		
			              sheet.addCell(b4);		
			              sheet.addCell(b5);		
			              sheet.addCell(b6);		
			              sheet.addCell(b7);		
			              sheet.addCell(b8);		
			              sheet.addCell(b9);		
			              sheet.addCell(b10);		
			              sheet.addCell(b11);		
			              sheet.addCell(b12);		
			              sheet.addCell(b13);		
			              sheet.addCell(b14);
			              sheet.addCell(b15);	
			              sheet.addCell(b16);	
			              sheet.addCell(b17);	
			             
			              i++;
				     }	
					book.write();
					book.close();
					outf.flush();
					outf.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			//ServletActionContext.getResponse().sendRedirect(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"archive"+"\\"+"archives.xls"));
		     String path="/export/outStore/"+us.getUserName()+"outStore.xls";
		    request.setAttribute("path", path);
		    ServletActionContext.getResponse().sendRedirect(path);
				return SUCCESS;
			
		   }
		
		
		int total=storeHouseDao.selectOutStoreByOptionInt(this.getApplyDepartment(),this.getUserName(),this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),
				bg,ed,Integer.valueOf(this.getOutVerify()).intValue());
		
		List<outStoreHouse> ep=new ArrayList<outStoreHouse>();
		
		if(!"".equals(this.getAddDateBegin().trim())){
			bg=this.getAddDateBegin().trim().substring(0, 10);
		}
		if(!"".equals(this.getAddDateEnd().trim())){
			ed=this.getAddDateEnd().trim().substring(0, 10);
		}

		ep=storeHouseDao.selectOutStoreByOption(this.getApplyDepartment(),this.getUserName(),this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),
				bg,ed,Integer.valueOf(this.getOutVerify()).intValue(),currentPage,pageSize);
		request.setAttribute("totalCount", total);
		request.setAttribute("ep", ep);
		request.setAttribute("outVerify", this.getOutVerify());
		return SUCCESS;
	}
}
