package com.xc.mybook.security.entity;

/**
 * 用户类
 * @author XC
 *
 */
public class TwUser extends BaseEntity {

	private static final long serialVersionUID = -4750675213159334503L;
	
	private String userId;//工号
	private String username;//用户名
	private String password;//密码
	private String sex;//性别
	private String departmentId;//所在部门
	private String status;//状态
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
