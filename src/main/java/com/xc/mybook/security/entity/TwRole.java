package com.xc.mybook.security.entity;

/**
 * 角色
 * @author XC
 *
 */
public class TwRole extends BaseEntity{

	private static final long serialVersionUID = -3576837481263385993L;
	private String roleId;
	private String roleCode;
	private String roleName;

	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
