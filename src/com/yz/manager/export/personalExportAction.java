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
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.personalDao;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.personal.bean.personal;

public class personalExportAction extends ActionSupport {

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
			File exp = new File(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"personal"+"\\"+us.getUserName()+"personal.xls"));		
			
			if(exp.exists()){
				exp.delete();
				exp.getParentFile().mkdirs();
			}else{
				exp.getParentFile().mkdirs();
			}
			
			OutputStream outf = new FileOutputStream(exp);
			WritableWorkbook book=Workbook.createWorkbook(outf);
			 List<personal> ps=new ArrayList<personal>();
			 if(pw.isSystemManager()){
				 ps=personalDao.selectPersonal();		
			 }else if(pw.isDepartmentManager()){
				 ps=personalDao.selectPersonalByDepartment(us.getDepartment());		
			 }else{
				 ps=personalDao.selectPersonalByUserName(us.getUserName());		
			 }
		     
		     WritableSheet sheet=book.createSheet("第一页",0);
		     Label label=new Label(0,0,"序号");
		     Label label1=new Label(1,0,"添加日期");
		     Label label2=new Label(2,0,"一级分类");
		     Label label3=new Label(3,0,"二级分类");
		     Label label4=new Label(4,0,"联系人");
		     Label label5=new Label(5,0,"手机");
		     Label label6=new Label(6,0,"座机");
		     Label label7=new Label(7,0,"单位名称");
		     Label label8=new Label(8,0,"单位地址");
		     Label label9=new Label(9,0,"职位");
		     Label label10=new Label(10,0,"传真");
		     Label label11=new Label(11,0,"电子邮箱");
		     Label label12=new Label(12,0,"QQ号码");
		     Label label13=new Label(13,0,"邮编地址");
		     Label label14=new Label(14,0,"添加部门");
		     Label label15=new Label(15,0,"添加人");
		     Label label16=new Label(16,0,"备注");
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
		     
		     int i=1;
		     for(personal p :ps){
		    	 int k=0;
		    	 String fc=daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue());
		    	 String sc=daoUtil.selectSecondClass8(p.getSecondCName());     
		    	 String gd=daoUtil.selectDepartment3(Integer.valueOf(p.getDepartment()).intValue());
		    	 String sname=daoUtil.selectUser(p.getUserName().trim());
	              Label b=new Label(k++,i,String.valueOf(i));
	              Label b1=new Label(k++,i,CurrentDate.parseDate4(p.getRegisterDate().toString()));
	              Label b2=new Label(k++,i,fc);
	              Label b3=new Label(k++,i,sc); 
	              Label b4=new Label(k++,i,p.getContactName()); 
	              Label b5=new Label(k++,i,p.getMobilePhone()); 
	              Label b6=new Label(k++,i,p.getWorkPhone()); 
	              Label b7=new Label(k++,i,p.getCompanyName()); 
	              Label b8=new Label(k++,i,p.getCompanyAddress()); 
	              Label b9=new Label(k++,i,p.getPost()); 
	              Label b10=new Label(k++,i,p.getFax()); 
	              Label b11=new Label(k++,i,p.getMail()); 
	              Label b12=new Label(k++,i,p.getQq()); 
	              Label b13=new Label(k++,i,p.getZipCode()); 
	              Label b14=new Label(k++,i,gd); 
	              Label b15=new Label(k++,i,sname); 
	              Label b16=new Label(k++,i,p.getRemarks()); 
	              
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
     String path="/export/personal/"+us.getUserName()+"personal.xls";
    request.setAttribute("path", path);
    ServletActionContext.getResponse().sendRedirect(path);
		return SUCCESS;
	}
}


