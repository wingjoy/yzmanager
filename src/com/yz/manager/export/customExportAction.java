package com.yz.manager.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.power;
import com.yz.manager.bean.user;
import com.yz.manager.custom.bean.custom;
import com.yz.manager.dao.customDao;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.date.CurrentDate;

public class customExportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		user us=new user();
		power pw=new power();
		us=(user)session.getAttribute("us");
		pw=us.getPower();
		try {
			File exp = new File(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"custom"+"\\"+us.getUserName()+"custom.xls"));		
			
			if(exp.exists()){
				exp.delete();
				exp.getParentFile().mkdirs();
			}else{
				exp.getParentFile().mkdirs();
			}
			
			OutputStream outf = new FileOutputStream(exp);
			WritableWorkbook book=Workbook.createWorkbook(outf);
			
			 List<custom> cs=new ArrayList<custom>();
			 if(pw.isSystemManager()){
				 cs=customDao.selectCustom();
			 }else if(pw.isDepartmentManager()){
				 cs=customDao.selectCustomByDepartment(us.getDepartment());
			 }else{
				 cs=customDao.selectCustomByUserName(us.getUserName());
			 }
			
			 
		     WritableSheet sheet=book.createSheet("第一页",0);
		     Label label=new Label(0,0,"序号");
		     Label label1=new Label(1,0,"添加日期");
		     Label label2=new Label(2,0,"区域");
		     Label label3=new Label(3,0,"添加部门");
		     Label label4=new Label(4,0,"添加人");
		     Label label5=new Label(5,0,"客户类型");
		     Label label6=new Label(6,0,"单位名称");
		     Label label7=new Label(7,0,"单位地址");
		     Label label8=new Label(8,0,"邮政编码");
		     Label label9=new Label(9,0,"联系人");
		     Label label10=new Label(10,0,"职位");
		     Label label11=new Label(11,0,"手机");
		     Label label12=new Label(12,0,"座机");
		     Label label13=new Label(13,0,"传真");
		     Label label14=new Label(14,0,"邮箱");
		     Label label15=new Label(15,0,"QQ号码");
		     Label label16=new Label(16,0,"备注");
		     Label label17=new Label(17,0,"客户状态");
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
		     for(custom p :cs){
		    	 int k=0;
		    	  String dp=daoUtil.selectDepartment3(Integer.valueOf(p.getDepartment()).intValue());
	              String sname=daoUtil.selectUser(p.getUserName().trim());
	              String ct=daoUtil.selectCustomTypeName(Integer.valueOf(p.getCustomType()).intValue());
	              String cstate=daoUtil.selectCustomStateName(Integer.valueOf(p.getCustomState()).intValue());
	              String an=daoUtil.selectCustomAreaName(Integer.valueOf(p.getAreaName()).intValue());
	           
	              Label b=new Label(k++,i,String.valueOf(i));
	              Label b1=new Label(k++,i,CurrentDate.parseDate4(p.getAddDate().toString()));
	              Label b2=new Label(k++,i,an);
	              Label b3=new Label(k++,i,dp); 
	              Label b4=new Label(k++,i,sname); 
	              Label b5=new Label(k++,i,ct); 
	              Label b6=new Label(k++,i,p.getCompanyName()); 
	              Label b7=new Label(k++,i,p.getCompanyAddress()); 
	              Label b8=new Label(k++,i,p.getZipCode()); 
	              Label b9=new Label(k++,i,p.getContactName()); 
	              Label b10=new Label(k++,i,p.getPost()); 
	              Label b11=new Label(k++,i,p.getMobilePhone()); 
	              Label b12=new Label(k++,i,p.getWorkPhone()); 
	              Label b13=new Label(k++,i,p.getFax()); 
	              Label b14=new Label(k++,i,p.getMail()); 
	              Label b15=new Label(k++,i,p.getQq()); 
	              Label b16=new Label(k++,i,p.getRemarks()); 
	              Label b17=new Label(k++,i,cstate); 
	              
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
     String path="/export/custom/"+us.getUserName()+"custom.xls";
    request.setAttribute("path", path);
    ServletActionContext.getResponse().sendRedirect(path);
		return SUCCESS;
	}
}


