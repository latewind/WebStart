package com.latewind.pojo.user;

public class LoginMessage {
	
	private UserInfo userInfo;
	private String alertMsg;
	private Boolean ifSuccess;
	private String userName;
	private String nickName;
	
	public LoginMessage(){
		
		
	}
	public LoginMessage(UserInfo u){
		
		userName=u.getUserName();
		nickName=u.getNickname();
		
		this.userInfo=u;
	}
	
	public LoginMessage(UserInfo u,String alertMsg,Boolean ifBoolean) {
				userName=u.getUserName();
		nickName=u.getNickname();
		
		this.userInfo=u;
		this.alertMsg=alertMsg;
		this.ifSuccess=ifBoolean;
		
	}
	
	
	
	/**
	 * @return the ifSuccess
	 */
	public Boolean getIfSuccess() {
		return ifSuccess;
	}
	/**
	 * @param ifSuccess the ifSuccess to set
	 */
	public void setIfSuccess(Boolean ifSuccess) {
		this.ifSuccess = ifSuccess;
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
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

}
