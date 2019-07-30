package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class Country {
	private int id;
	private String country_chi_name;
	private String country_eng_name;
	private String country_ab_name;
	private Timestamp created;
	private Timestamp updated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry_chi_name() {
		return country_chi_name;
	}
	public void setCountry_chi_name(String country_chi_name) {
		this.country_chi_name = country_chi_name;
	}
	public String getCountry_eng_name() {
		return country_eng_name;
	}
	public void setCountry_eng_name(String country_eng_name) {
		this.country_eng_name = country_eng_name;
	}
	public String getCountry_ab_name() {
		return country_ab_name;
	}
	public void setCountry_ab_name(String country_ab_name) {
		this.country_ab_name = country_ab_name;
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
