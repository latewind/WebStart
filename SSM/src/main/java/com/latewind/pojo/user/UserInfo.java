package com.latewind.pojo.user;

import java.util.Date;

import javax.ws.rs.HEAD;

import com.latewind.pojo.personal.NewPassword;
import com.latewind.pojo.personal.NewUserInfo;

public class UserInfo {
	private Integer userId;

	private String userName;

	private String password;

	private String tel;

	private Integer sex;

	private String nickname;

	private String actualName;

	private String address;

	private Date birthDate;

	private String salt;

	private String idnumber;

	private byte[] head;

	public Boolean setNewValue(NewUserInfo nu) {

		actualName = nu.getNewActualName();
		address = nu.getNewAddress();
		birthDate = nu.getNewBirthDate();
//		birthDate=new Date();
		idnumber = nu.getNewIdnumber();

		nickname = nu.getNewNickname();
		sex = nu.getNewSex();

		tel = nu.getNewTel();

		return true;
	}

	
	public Boolean setNewPassword(NewPassword p){
		//TODO 验证
		if(password.equals(p.getOldPassword())){
		password=p.getNewPassword();
		return true;
		}
		
		return false;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", password=" + password + ", tel=" + tel
				+ ", sex=" + sex + ", nickname=" + nickname + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the idnumber
	 */
	public String getIdnumber() {
		return idnumber;
	}

	/**
	 * @param idnumber
	 *            the idnumber to set
	 */
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	/**
	 * @return the head
	 */
	public byte[] getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(byte[] head) {
		this.head = head;
	}
}