package com.java.model;

import java.util.Date;

public class User {
	private int userId;
	private String uname;
	private Integer  gender;
	private Date birthday;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", uname=" + uname + ", gender=" + gender + ", birthday=" + birthday + "]";
	}
	
}
