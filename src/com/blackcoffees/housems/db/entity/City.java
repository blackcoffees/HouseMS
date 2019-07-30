package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class City {
	private int id;
	private String city_chi_name;
	private String city_ab_name;
	private Timestamp created;
	private Timestamp updated;
	private int country_id;
	private int province_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_chi_name() {
		return city_chi_name;
	}
	public void setCity_chi_name(String city_chi_name) {
		this.city_chi_name = city_chi_name;
	}
	public String getCity_ab_name() {
		return city_ab_name;
	}
	public void setCity_ab_name(String city_ab_name) {
		this.city_ab_name = city_ab_name;
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
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	
}
