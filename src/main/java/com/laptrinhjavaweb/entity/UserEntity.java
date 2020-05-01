package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotion.Column;
import com.laptrinhjavaweb.annotion.Entity;
import com.laptrinhjavaweb.annotion.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "password")
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
