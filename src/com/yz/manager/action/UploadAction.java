package com.yz.manager.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.department;
import com.yz.manager.bean.firstClass;
import com.yz.manager.bean.secondClass;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.shouse;
import com.yz.manager.storehouse.bean.storeHouse;
import com.yz.manager.upload.bean.FileDao;
import com.yz.manager.upload.bean.SomeFile;
import com.yz.manager.utils.ExcelHandler;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = -5016873153441103539L;

	private File[] file;
	private String[] fileContentType;
	private String[] fileFileName;
	private String[] comment;
	private String savePath = "/upload";

	
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	
	public String[] getComment() {
		return comment;
	}

	public void setComment(String[] comment) {
		this.comment = comment;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * 产生文件的存储文件名
	 * @param fileName
	 * @return
	 */
	private String generateFileUrl(String fileName, String formatDate) {
		File dir = new File( ServletActionContext.getServletContext().getRealPath(
				savePath));
		if(!dir.exists()){
			dir.mkdir();
		}
		String url = ServletActionContext.getServletContext().getRealPath(
				savePath)
				+ File.separator + formatDate + fileName;
		return url;
	}

	/**
	 *
	 * @return
	 */
	public String save() {
		try {
			for (int i = 0; i < file.length; i++) {
				DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
				String formatDate = format.format(new Date());
				String url = generateFileUrl(fileFileName[i], formatDate);
				SomeFile sofile = new SomeFile();
				sofile.setFileName(fileFileName[i]);
				System.out.println(fileFileName[i]);
				sofile.setFilePath(url);
				System.out.println(url);
				FileDao filedao = new FileDao();
				filedao.save(sofile);
				System.out.println("储存数据库成功，下来保存文件到项目文件夹下");
				FileInputStream fis = new FileInputStream(file[i]);
				importExcel(fis);
				//FileOutputStream fos = new FileOutputStream(url);
				//byte[] data = new byte[fis.available()];
				//fis.read(data);
				//fos.write(data);
				fis.close();
				//fos.flush();
				//fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String uploaderror="上传文件失败";
			ServletActionContext.getRequest().setAttribute("message", uploaderror);
			return "uploadFiled ";
		}
		String uploadsuccessr="上传文件成功";
		ServletActionContext.getRequest().setAttribute("message", uploadsuccessr);
		return "uploadSuccess";
	}

	public void importExcel(InputStream in) throws BiffException, IOException{
		 department dp = daoUtil.selectHaveHouseDepartmentByName("办公室");
		 List<shouse> shs = daoUtil.selectShouseByDepartmentId(dp.getDepartmentId()+"");
		 shouse sho = null;
		 for(shouse sh:shs){
			 if(sh.getHouseName().equals("办公室库房")){
				 sho = sh;
			 }
		 }
		 HttpSession session = ServletActionContext.getRequest().getSession(); 
		 user user = (user) session.getAttribute("us");
		 List<user> users = daoUtil.selectAllIverifyName1();
		 user verifyUser=null ;
		 if(users.size()>0){
			 verifyUser = users.get(0);
		 }
		 
		 
		 
		 ExcelHandler eHandler = new ExcelHandler();
		 if(sho!=null&&verifyUser!=null){
			 List<firstClass> fc = daoUtil.selectAllHouseFirstClass2ForHouseId(sho.getId()+"");
			 List<storeHouse> storeHouses = eHandler.getStoreHousesFromExcel(in);
			 for(storeHouse s:storeHouses){
				 s.setDepartment(dp.getDepartmentId()+"");
				 s.setInDepartment(user.getDepartment());
				 s.setUserName(user.getUserName());
			     s.setHouseId(sho.getId()+"");
			     s.setInVerify(0);
			     s.setInVerifyName(verifyUser.getUserName());
			     Date date=new Date();
				 s.setInDate(new Timestamp(date.getTime()));
				 
				 boolean hasFirstName = false,hasSecondName = false;
				 for(firstClass f:fc){
					 if(f.getFirstCName().equals(s.getFirstCName())){
						 s.setFirstCName(f.getId()+"");
						 hasFirstName = true;
						 break;
					 }
				 }
				 if(!hasFirstName){
					 firstClass newClass = new firstClass();
					 newClass.setSystemName("0");
					 newClass.setDepartment(dp.getDepartmentId()+"");
					 newClass.setHouseId(sho.getId()+"");
					 newClass.setFirstCName(s.getFirstCName());
					 Integer id = daoUtil.addfirstClass(newClass);
					 s.setFirstCName(id+"");
					 newClass.setId(id);
					 fc.add(newClass);
				 }
				 List<secondClass> secondClasses  = daoUtil.selectAllHouseSecondClassForFirstClass(s.getFirstCName());
				 for(secondClass f:secondClasses){
					 if(f.getSecondCName().endsWith(s.getSecondCName())){
						 s.setSecondCName(f.getId()+"");
						 hasSecondName = true;
						 break;
					 }
				 }
				 if(!hasSecondName){
					 secondClass newClass = new secondClass();
					 newClass.setSystemName("0");
					 newClass.setDepartment(dp.getDepartmentId()+"");
					 newClass.setHouseId(sho.getId()+"");
					 newClass.setFirstCName(s.getFirstCName());
					 newClass.setSecondCName(s.getSecondCName());
					 newClass.setFirstCName(s.getFirstCName());
					 newClass.setUnit(s.getUnit());
					 newClass.setUnitPrice(s.getUnitPrice());
					 s.setSecondCName(daoUtil.addsecondClass(newClass)+"");
				 }
				 storeHouseDao.addStoreHouse1(s);
			 }
		 }
	}
	/**
	 *获得文件列表数据
	 */
	public String list() {
		//String userName = "tyt";
		FileDao filedao = new FileDao();
		List<SomeFile> files = filedao.list();
		for(SomeFile file:files){
			System.out.println(file.getId());
			System.out.println(file.getFilePath());
			System.out.println(file.getFileName());
		}
		ServletActionContext.getRequest().setAttribute("filelist",files);
		return "listSuccess";
	}
	public String execute(){
		System.out.println("execute方法执行成功");
		return "success";
	}
}