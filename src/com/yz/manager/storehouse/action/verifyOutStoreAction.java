package com.yz.manager.storehouse.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.outStoreHouse;

public class verifyOutStoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	private String id;
	private String verify;
	private String verifyRemarks;
	private String outVerify;
	private String nextVerifyName;

	public String getNextVerifyName() {
		return nextVerifyName;
	}

	public void setNextVerifyName(String nextVerifyName) {
		this.nextVerifyName = nextVerifyName;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getVerifyRemarks() {
		return verifyRemarks;
	}

	public void setVerifyRemarks(String verifyRemarks) {
		this.verifyRemarks = verifyRemarks;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutVerify() {
		return outVerify;
	}

	public void setOutVerify(String outVerify) {
		this.outVerify = outVerify;
	}

	@Override
	public String execute() throws Exception {
		String returnMsg = null;
		HttpServletRequest re = ServletActionContext.getRequest();

		// 获取所有出库id
		String[] aIds = re.getParameter("aId").split("/");
		for (int i = aIds.length - 1; i >= 0; i--) {
			outStoreHouse sh = storeHouseDao.selectOutHouse(aIds[i]);
			//获取,设置审查更改后的数量
			int applyCount = Integer.parseInt(re.getParameter(aIds[i]));
			sh.setApplyCount(applyCount);

			boolean result = true;
			int outV = Integer.valueOf(this.getOutVerify()).intValue();
			if (outV == 0) {
				if (this.getVerify().equals("1")) {
					sh.setOutVerify(1);
					sh.setInVerifyRemarks(this.getVerifyRemarks());
					sh.setHouseVerifyName(this.getNextVerifyName());
					sh.setNextVerifyName(this.getNextVerifyName());
				} else {
					sh.setOutVerify(11);
					sh.setInVerifyRemarks(this.getVerifyRemarks());
				}
				storeHouseDao.modifyOutStoreHouse(sh);
			} else if (outV == 1) {
				if (this.getVerify().equals("1")) {
					sh.setOutVerify(2);
					sh.setHouseVerifyRemarks(this.getVerifyRemarks());
					sh.setHouseManager(this.getNextVerifyName());
					sh.setNextVerifyName(this.getNextVerifyName());
				} else {
					sh.setOutVerify(22);
					sh.setHouseVerifyRemarks(this.getVerifyRemarks());
				}
				storeHouseDao.modifyOutStoreHouse(sh);
			} else if (outV == 2) {
				if (this.getVerify().equals("1")) {
					sh.setOutVerify(3);
					sh.setHouseManagerRemarks(this.getVerifyRemarks());
					Date date = new Date();
					sh.setOutDate(new Timestamp(date.getTime()));
				} else {
					sh.setOutVerify(33);
					sh.setHouseManagerRemarks(this.getVerifyRemarks());
					Date date = new Date();
					sh.setOutDate(new Timestamp(date.getTime()));
				}
				result = storeHouseDao.modifyEndOutStoreHouse(sh);
			}else if (outV == 3) {
				if (this.getVerify().equals("1")) {
					sh.setOutVerify(4);
					sh.setHouseManagerRemarks(this.getVerifyRemarks());
					Date date = new Date();
					sh.setOutDate(new Timestamp(date.getTime()));
				} else {
					sh.setOutVerify(44);
					sh.setHouseManagerRemarks(this.getVerifyRemarks());
					Date date = new Date();
					sh.setOutDate(new Timestamp(date.getTime()));
				}
				result = storeHouseDao.modifyEndOutStoreHouse(sh);
			}
			if (!result) {
				this.addActionError("出库失败，请重新处理出库业务或与管理员联系");
				re.setAttribute("said", this.getId());
				returnMsg = INPUT;

			} else {
				returnMsg = SUCCESS;
			}
		}
		return returnMsg;
	}

	@Override
	public void validate() {
		HttpServletRequest re = ServletActionContext.getRequest();
		if (this.getVerify().equals("1") & this.getNextVerifyName().equals("0")) {
			this.addFieldError("verifynull", "审核人不能为空");
			re.setAttribute("said", this.getId());
		}
	}

}
