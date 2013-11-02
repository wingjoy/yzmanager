package com.yz.manager.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.upload.bean.SomeFile;
import com.yz.manager.upload.bean.FileDao;

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
		System.out.println(file.length);
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
				sofile.setComment(comment[i]);
				System.out.println(comment[i]);
				FileDao filedao = new FileDao();
				filedao.save(sofile);
				System.out.println("储存数据库成功，下来保存文件到项目文件夹下");
				FileInputStream fis = new FileInputStream(file[i]);
				FileOutputStream fos = new FileOutputStream(url);
				byte[] data = new byte[fis.available()];
				fis.read(data);
				fos.write(data);
				fis.close();
				fos.flush();
				fos.close();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			String uploaderror="上传文件失败";
			ServletActionContext.getRequest().setAttribute("message", uploaderror);
			return "uploadFiled ";
		}
		String uploadsuccessr="上传文件成功";
		ServletActionContext.getRequest().setAttribute("message", uploadsuccessr);
		return "uploadSuccess";
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