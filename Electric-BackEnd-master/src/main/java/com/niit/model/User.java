package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	String username;
	String custName;
	String email;
	String mobile;
	String password;
	String address;
	boolean enable;
	String role; /* user or admin */

	@Override
	public String toString() {
		return "User [username=" + username + ", custName=" + custName + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", address=" + address + ", enable=" + enable + ", role=" + role + "]";
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(String username, String custName, String email, String mobile, String password, String address,
			boolean enable, String role) {
		super();
		this.username = username;
		this.custName = custName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
		this.enable = enable;
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
