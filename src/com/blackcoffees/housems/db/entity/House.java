package com.blackcoffees.housems.db.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class House {
	public int HOUSE_STATUS_LIMIT_SALE = 1;
	public int HOUSE_STATUS_ON_SALE = 2;
	public int HOUSE_STATUS_RESERVE = 3;
	public int HOUSE_STATUS_SOLD = 4;
	public int HOUSE_STATUS_REGISTER = 5;
	public int HOUSE_STATUS_UNKNOW = 6;
	public int HOUSE_STATUS_NO = 7;
	private int id;
	//门牌号
	private String door_number;
	private int status;
	//套内
	private BigDecimal inside_area;
	//建面
	private BigDecimal built_area;
	//房屋类型
	private int attribute_house_type_id;
	//套内价格
	private BigDecimal inside_price;
	//建面价格
	private BigDecimal built_price;
	//楼盘id
	private int real_estate_id;
	//大楼id
	private int building_id;
	//网站id
	private int web_source_id;
	private Timestamp created;
	private Timestamp updated;
	//单元
	private String unit;
	private int web_house_id;
	//物理层
	private int physical_layer;
	//名义层
	private int nominal_layer;
	private int house_number;
	private int country_id;
	private int province_id;
	private int city_id;
	private int region_id;
	//房籍号
	private String fjh;
	//结构
	private int attribute_structure_id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoor_number() {
		return door_number;
	}
	public void setDoor_number(String door_number) {
		this.door_number = door_number;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BigDecimal getInside_area() {
		return inside_area;
	}
	public void setInside_area(BigDecimal inside_area) {
		this.inside_area = inside_area;
	}
	public BigDecimal getBuilt_area() {
		return built_area;
	}
	public void setBuilt_area(BigDecimal built_area) {
		this.built_area = built_area;
	}
	public int getAttribute_house_type_id() {
		return attribute_house_type_id;
	}
	public void setAttribute_house_type_id(int attribute_house_type_id) {
		this.attribute_house_type_id = attribute_house_type_id;
	}
	public BigDecimal getInside_price() {
		return inside_price;
	}
	public void setInside_price(BigDecimal inside_price) {
		this.inside_price = inside_price;
	}
	public BigDecimal getBuilt_price() {
		return built_price;
	}
	public void setBuilt_price(BigDecimal built_price) {
		this.built_price = built_price;
	}
	public int getReal_estate_id() {
		return real_estate_id;
	}
	public void setReal_estate_id(int real_estate_id) {
		this.real_estate_id = real_estate_id;
	}
	public int getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}
	public int getWeb_source_id() {
		return web_source_id;
	}
	public void setWeb_source_id(int web_source_id) {
		this.web_source_id = web_source_id;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getWeb_house_id() {
		return web_house_id;
	}
	public void setWeb_house_id(int web_house_id) {
		this.web_house_id = web_house_id;
	}
	public int getPhysical_layer() {
		return physical_layer;
	}
	public void setPhysical_layer(int physical_layer) {
		this.physical_layer = physical_layer;
	}
	public int getNominal_layer() {
		return nominal_layer;
	}
	public void setNominal_layer(int nominal_layer) {
		this.nominal_layer = nominal_layer;
	}
	public int getHouse_number() {
		return house_number;
	}
	public void setHouse_number(int house_number) {
		this.house_number = house_number;
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
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getFjh() {
		return fjh;
	}
	public void setFjh(String fjh) {
		this.fjh = fjh;
	}
	public int getAttribute_structure_id() {
		return attribute_structure_id;
	}
	public void setAttribute_structure_id(int attribute_structure_id) {
		this.attribute_structure_id = attribute_structure_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
