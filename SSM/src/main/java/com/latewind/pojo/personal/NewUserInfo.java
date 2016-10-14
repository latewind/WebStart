package com.latewind.pojo.personal;

import java.util.Date;

public class NewUserInfo {
	
private	String newNickname;

private Integer newSex;

private String newActualName;

private String newTel;

private Date newBirthDate;

private String newIdnumber;

private String newAddress;




@Override
public String toString() {
	return "NewUserInfo [newNickname=" + newNickname + ", newSex=" + newSex + ", newActualName=" + newActualName
			+ ", newTel=" + newTel + ", newBirthDate=" + newBirthDate + ", newIdnumber=" + newIdnumber + ", newAddress="
			+ newAddress + ", getNewNickname()=" + getNewNickname() + ", getNewSex()=" + getNewSex()
			+ ", getNewActualName()=" + getNewActualName() + ", getNewTel()=" + getNewTel() + ", getNewBirthDate()="
			+ getNewBirthDate() + ", getNewIdnumber()=" + getNewIdnumber() + ", getNewAddress()=" + getNewAddress()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

public String getNewNickname() {
	return newNickname;
}

public void setNewNickname(String newNickname) {
	this.newNickname = newNickname;
}

public Integer getNewSex() {
	return newSex;
}

public void setNewSex(Integer newSex) {
	this.newSex = newSex;
}

public String getNewActualName() {
	return newActualName;
}

public void setNewActualName(String newActualName) {
	this.newActualName = newActualName;
}

public String getNewTel() {
	return newTel;
}

public void setNewTel(String newTel) {
	this.newTel = newTel;
}

public Date getNewBirthDate() {
	return newBirthDate;
}

public void setNewBirthDate(Date newBirthDate) {
	this.newBirthDate = newBirthDate;
}

public String getNewIdnumber() {
	return newIdnumber;
}

public void setNewIdnumber(String newIdnumber) {
	this.newIdnumber = newIdnumber;
}

public String getNewAddress() {
	return newAddress;
}

public void setNewAddress(String newAddress) {
	this.newAddress = newAddress;
}






}
