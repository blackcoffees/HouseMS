package com.blackcoffees.housems.db.entity;

import java.sql.Time;
import java.sql.Timestamp;

public class SysModule {

	private int id;
	private String name;
	private String href;
	private Timestamp created;
	private Timestamp updated;
	private int parent_id;
	private int status;
	private int sys_user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
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
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSys_user_id() {
		return sys_user_id;
	}
	public void setSys_user_id(int sys_user_id) {
		this.sys_user_id = sys_user_id;
	}
	
}
