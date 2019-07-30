package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class RealEstate {
	private int id;
	//项目地址
	private String address;
	//楼盘名称
	private String name;
	//开发商
	private String developer;
	private Timestamp created;
	private Timestamp updated;
	//房子总数量
	private int count_house_number;
	//网站来源
	private int web_source_id;
	//网站房地产id
	private int web_real_estate_id;
	private int region_id;
	private int country_id;
	private int province_id;
	private int city;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
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
	public int getCount_house_number() {
		return count_house_number;
	}
	public void setCount_house_number(int count_house_number) {
		this.count_house_number = count_house_number;
	}
	public int getWeb_source_id() {
		return web_source_id;
	}
	public void setWeb_source_id(int web_source_id) {
		this.web_source_id = web_source_id;
	}
	public int getWeb_real_estate_id() {
		return web_real_estate_id;
	}
	public void setWeb_real_estate_id(int web_real_estate_id) {
		this.web_real_estate_id = web_real_estate_id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
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
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	
}
