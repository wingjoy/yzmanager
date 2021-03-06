package com.yz.manager.export;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.yz.manager.archives.bean.archives;
import com.yz.manager.dao.archivesDao;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.date.CurrentDate;

import jxl.*;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
public class archiveExport {

	public static  void main(String args[]) throws RowsExceededException, WriteException{
		
		try {
			WritableWorkbook book=Workbook.createWorkbook(new File("archives.xls"));
			 List<archives> ar=new ArrayList<archives>();
		     ar=archivesDao.selectArchives();
		     WritableSheet sheet=book.createSheet("第一页",0);
		     Label label=new Label(0,0,"序号");
		     Label label1=new Label(1,0,"存档日期");
		     Label label2=new Label(2,0,"文件名称");
		     Label label3=new Label(3,0,"一级分类");
		     Label label4=new Label(4,0,"二级分类");
		     Label label5=new Label(5,0,"档案编号");
		     Label label6=new Label(6,0,"页数");
		     Label label7=new Label(7,0,"代号");
		     Label label8=new Label(8,0,"保存年限");
		     Label label9=new Label(9,0,"交档部门");
		     Label label10=new Label(10,0,"交档人");
		     Label label11=new Label(11,0,"存档部门");
		     Label label12=new Label(12,0,"存档人");
		     Label label13=new Label(13,0,"档案备注");
		     Label label14=new Label(14,0,"审核意见");
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
		     
		     int i=1;
		     for(archives a :ar){
		    	 int k=0;
		    	  String dp=daoUtil.selectDepartment3(Integer.valueOf(a.getDepartment()).intValue());
	              String sdp=daoUtil.selectDepartment3(Integer.valueOf(a.getSaveArDepartment()).intValue());
	              String sname=daoUtil.selectUser(a.getSaveArName().trim());
	              String fc=daoUtil.selectFirstClass5(Integer.valueOf(a.getFirstCName()).intValue());
	              String sc=daoUtil.selectSecondClass8(a.getSecondCName());  
	              Label b=new Label(k++,i,String.valueOf(i));
	              Label b1=new Label(k++,i,CurrentDate.parseDate4(a.getSaveArDate().toString()));
	              Label b2=new Label(k++,i,a.getFileName());
	              Label b3=new Label(k++,i,fc); 
	              Label b4=new Label(k++,i,sc); 
	              Label b5=new Label(k++,i,a.getFileNumber()); 
	              Label b6=new Label(k++,i,a.getFilePages()); 
	              Label b7=new Label(k++,i,a.getFileCoverNumber()); 
	              Label b8=new Label(k++,i,a.getSaveYears()); 
	              Label b9=new Label(k++,i,dp); 
	              Label b10=new Label(k++,i,a.getGiveArName()); 
	              Label b11=new Label(k++,i,sdp); 
	              Label b12=new Label(k++,i,sname); 
	              Label b13=new Label(k++,i,a.getRemarks()); 
	              Label b14=new Label(k++,i,a.getSaveArRemarks()); 
	              
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
	              i++;
		     }
			
			
				
			book.write();
			book.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
