package com.latewind.pojo.personal;

public class NewPassword {
private String oldPassword;

private String newPassword;

private String twicePassword;


@Override
public String toString() {
	return "NewPassword [oldPassword=" + oldPassword + ", newPassword=" + newPassword + ", twicePassword="
			+ twicePassword + ", getOldPassword()=" + getOldPassword() + ", getNewPassword()=" + getNewPassword()
			+ ", getTwicePassword()=" + getTwicePassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}

public String getOldPassword() {
	return oldPassword;
}

public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
}

public String getNewPassword() {
	return newPassword;
}

public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}

public String getTwicePassword() {
	return twicePassword;
}

public void setTwicePassword(String twicePassword) {
	this.twicePassword = twicePassword;
}


}
