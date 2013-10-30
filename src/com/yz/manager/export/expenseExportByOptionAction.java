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
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.expenseDao;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.expense.bean.expense;

public class expenseExportByOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		    String d1=(String)session.getAttribute("d1");
			String u1=(String)session.getAttribute("u1");
			String fc1=(String)session.getAttribute("fc1");
			String sc1=(String)session.getAttribute("sc1");
			String db=(String)session.getAttribute("db");      
			String de=(String)session.getAttribute("de");
			String sr=(String)session.getAttribute("sr"); 
			String s1=(String)session.getAttribute("s1"); 
			String n1=(String)session.getAttribute("n1"); 
			String g1=(String)session.getAttribute("g1"); 
		
		user us=new user();
		us=(user)session.getAttribute("us");
		try {
			File exp = new File(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"expense"+"\\"+us.getUserName()+"expense.xls"));		
			if(exp.exists()){
				exp.delete();
				exp.getParentFile().mkdirs();
			}else{
				exp.getParentFile().mkdirs();
			}
			
			OutputStream outf = new FileOutputStream(exp);
			WritableWorkbook book=Workbook.createWorkbook(outf);
			 List<expense> ex=new ArrayList<expense>();
		     ex=expenseDao.selectExpenseByOption(d1,u1,fc1,sc1,db,de,s1,sr,n1,g1);		
		     WritableSheet sheet=book.createSheet("第一页",0);
		     Label label=new Label(0,0,"序号");
		     Label label1=new Label(1,0,"添加日期");
		     Label label2=new Label(2,0,"一级分类");
		     Label label3=new Label(3,0,"二级分类");
		     Label label4=new Label(4,0,"事由");
		     Label label5=new Label(5,0,"单价");
		     Label label6=new Label(6,0,"数量");
		     Label label7=new Label(7,0,"单位");
		     Label label8=new Label(8,0,"总价");
		     Label label9=new Label(9,0,"供应商");
		     Label label10=new Label(10,0,"供应商地址");
		     Label label11=new Label(11,0,"联系人");
		     Label label12=new Label(12,0,"联系电话");
		     Label label13=new Label(13,0,"费用性质");
		     Label label14=new Label(14,0,"付款方式");
		     Label label15=new Label(15,0,"挂账公司");
		     Label label16=new Label(16,0,"经办部门");
		     Label label17=new Label(17,0,"经办人");
		     Label label18=new Label(18,0,"审核人");
		     Label label19=new Label(19,0,"备注");
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
		     sheet.addCell(label18);	
		     sheet.addCell(label19);	
		     
		     int i=1;
		     for(expense p :ex){
		    	 int k=0;
		    	    String fc=daoUtil.selectFirstClass5(Integer.valueOf(p.getFirstCName()).intValue());
		    	    String sc=daoUtil.selectSecondClass8(p.getSecondCName());     
		    	    String gd=daoUtil.selectDepartment3(Integer.valueOf(p.getDepartment()).intValue());
		    	    String sname=daoUtil.selectUser(p.getUserName().trim());
		    	    String everifyName=daoUtil.selectUser(p.getEverifyName().trim());
		    	    String cm=daoUtil.selectGCompanyName(Integer.valueOf(p.getCompany()).intValue());
		    	    String pm=daoUtil.selectPayModeName(Integer.valueOf(p.getPayMode()).intValue());
	         
		    	  Label b=new Label(k++,i,String.valueOf(i));
	              Label b1=new Label(k++,i,CurrentDate.parseDate4(p.getAddDate().toString()));
	              Label b2=new Label(k++,i,fc);
	              Label b3=new Label(k++,i,sc); 
	              Label b4=new Label(k++,i,p.getContent()); 
	              Label b5=new Label(k++,i,String.valueOf(p.getUnitPrice())); 
	              Label b6=new Label(k++,i,String.valueOf(p.getNumber())); 
	              Label b7=new Label(k++,i,p.getUnit()); 
	              Label b8=new Label(k++,i,String.valueOf(p.getTotalPrice())); 
	              Label b9=new Label(k++,i,p.getSupplier()); 
	              Label b10=new Label(k++,i,p.getSupplierAddress()); 
	              Label b11=new Label(k++,i,p.getContactName()); 
	              Label b12=new Label(k++,i,p.getContactPhone()); 
	              Label b13=new Label(k++,i,p.getNature()); 
	              Label b14=new Label(k++,i,pm); 
	              Label b15=new Label(k++,i,cm); 
	              Label b16=new Label(k++,i,gd); 
	              Label b17=new Label(k++,i,sname); 	 
	              Label b18=new Label(k++,i,everifyName); 
	              Label b19=new Label(k++,i,p.getRemarks()); 
	              
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
	              sheet.addCell(b18);	
	              sheet.addCell(b19);	
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
     String path="/export/expense/"+us.getUserName()+"expense.xls";
    request.setAttribute("path", path);
    ServletActionContext.getResponse().sendRedirect(path);
		return SUCCESS;
	}
}


              


