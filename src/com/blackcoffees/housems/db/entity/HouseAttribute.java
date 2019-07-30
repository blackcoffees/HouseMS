package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class HouseAttribute {
	private int id;
	private String chiese_name;
	private String internet_name;
	private String internet_type;
	private Timestamp created;
	private Timestamp updated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChiese_name() {
		return chiese_name;
	}
	public void setChiese_name(String chiese_name) {
		this.chiese_name = chiese_name;
	}
	public String getInternet_name() {
		return internet_name;
	}
	public void setInternet_name(String internet_name) {
		this.internet_name = internet_name;
	}
	public String getInternet_type() {
		return internet_type;
	}
	public void setInternet_type(String internet_type) {
		this.internet_type = internet_type;
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
	
}
