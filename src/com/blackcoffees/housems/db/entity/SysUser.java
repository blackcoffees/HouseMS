package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class SysUser {
	private int id;
	private String username;
	private String password;
	private Timestamp created;
	private Timestamp updated;
	private Timestamp last_login;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public Timestamp getLast_login() {
		return last_login;
	}
	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
