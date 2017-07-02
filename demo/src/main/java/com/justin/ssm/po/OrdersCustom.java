package com.justin.ssm.po;

import java.util.Date;

public class OrdersCustom extends Orders {

	//添加用户属性
	/*
	 * user.username
	 * user.sex
	 * user.address
	 */
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
