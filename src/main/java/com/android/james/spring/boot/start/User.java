package com.android.james.spring.boot.start;

import java.util.Objects;

public class User {

	int id;
	String address;
	String email;
	String password;
	String mobile;
	
	public User(int id, String address, String email, String password, String mobile) {
		this.id = id;
		this.address = address;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
			Objects.equals(address, user.address) &&
			Objects.equals(email, user.email) &&
			Objects.equals(password, user.password) &&
			Objects.equals(mobile, user.mobile);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, address, email, password, mobile);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
