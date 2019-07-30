package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class RealEstateAttr {
	private int id;
	private int real_estate_id;
	private Timestamp created;
	private Timestamp updated;
	private String attr_title;
	private String attr_value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReal_estate_id() {
		return real_estate_id;
	}
	public void setReal_estate_id(int real_estate_id) {
		this.real_estate_id = real_estate_id;
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
	public String getAttr_title() {
		return attr_title;
	}
	public void setAttr_title(String attr_title) {
		this.attr_title = attr_title;
	}
	public String getAttr_value() {
		return attr_value;
	}
	public void setAttr_value(String attr_value) {
		this.attr_value = attr_value;
	}
	
}
