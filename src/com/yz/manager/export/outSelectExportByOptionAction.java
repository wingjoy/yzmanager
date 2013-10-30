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
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.date.CurrentDate;
import com.yz.manager.storehouse.bean.outStoreHouse;

public class outSelectExportByOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		String adp=(String)session.getAttribute("adp");
        String dp1=(String)session.getAttribute("dp1");
		String sh2=(String)session.getAttribute("sh1");
        String fc1=(String)session.getAttribute("fc1");
		String sc1=(String)session.getAttribute("sc1");
		String sdb1=(String)session.getAttribute("sdb");      
		String sde1=(String)session.getAttribute("sde");
		String vnm=(String)session.getAttribute("vnm");
		
		user us=new user();
		us=(user)session.getAttribute("us");
		try {

			File exp = new File(ServletActionContext.getServletContext().getRealPath("export"+"\\"+"outStore"+"\\"+us.getUserName()+"outStore.xls"));			
			if(exp.exists()){
				exp.delete();
				exp.getParentFile().mkdirs();
			}else{
				exp.getParentFile().mkdirs();
			}
			
			OutputStream outf = new FileOutputStream(exp);
			WritableWorkbook book=Workbook.createWorkbook(outf);
			  List<outStoreHouse> sh=new ArrayList<outStoreHouse>();
			    
			     sh=storeHouseDao.selectOutStoreByOption(adp,vnm,dp1,sh2,fc1,sc1,sdb1,sde1);
		     
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
}


