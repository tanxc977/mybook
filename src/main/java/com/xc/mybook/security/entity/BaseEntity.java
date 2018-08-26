package com.xc.mybook.security.entity;

import java.util.Date;

public class BaseEntity implements java.io.Serializable{

	private static final long serialVersionUID = -4513102479003721591L;
	
	private String createdUser;//创建人
	private Date createdDate;//创建时间
	private String lastUpdateBy;//最后更新人
	private Date lastUpdateDate;//最后更新时间
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}
