package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class Province {
	private int id;
	private String province_chi_name;
	private String province_eng_name;
	private String province_ad_name;
	private Timestamp created;
	private Timestamp updated;
	private int country_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince_chi_name() {
		return province_chi_name;
	}
	public void setProvince_chi_name(String province_chi_name) {
		this.province_chi_name = province_chi_name;
	}
	public String getProvince_eng_name() {
		return province_eng_name;
	}
	public void setProvince_eng_name(String province_eng_name) {
		this.province_eng_name = province_eng_name;
	}
	public String getProvince_ad_name() {
		return province_ad_name;
	}
	public void setProvince_ad_name(String province_ad_name) {
		this.province_ad_name = province_ad_name;
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
	
}
