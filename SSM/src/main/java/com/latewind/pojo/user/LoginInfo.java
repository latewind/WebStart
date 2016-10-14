package com.latewind.pojo.user;

import java.util.Date;

public class LoginInfo {
	private Integer userId;
	private String nickName;
	private Date loginTime;
	private Boolean autoLogin;
	private String userKey;
	private String alertMsg;
	private Boolean success;
	private String salt;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer integer) {
		this.userId = integer;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Boolean getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(Boolean autoLogin) {
		this.autoLogin = autoLogin;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * @return the alertMsg
	 */
	public String getAlertMsg() {
		return alertMsg;
	}

	/**
	 * @param alertMsg the alertMsg to set
	 */
	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
