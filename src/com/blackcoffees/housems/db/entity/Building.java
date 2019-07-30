package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class Building {
	// δ�ռ�����
	public int BUILDING_STATUS_NO_COLLECT = 1;
	// ���ռ�����
	public int BUILDING_STATUS_HAS_COLLECT = 2;
	// ���ռ�
	public int BUILDING_STATUS_BAN = 3;
	// ����������ƥ��
	public int BUILDING_STATUS_NOT_MATCH = 4;
	
	private int id;
	//Ԥ�����֤/����֤��
	private String pre_sale_number;
	//¥������
	private String real_estate_name;
	//¥������
	private String building_name;
	//�ܵ�סլ����
	private int count_residence_number;
	private int real_estate_id;
	private int web_source_id;
	private Timestamp created;
	private Timestamp updated;
	//��վ��¥ID
	private int web_building_id;
	//���ʱ��
	private Timestamp register_time;
	//����������
	private int count_house_number;
	//����
	private int country_id;
	//ʡ��
	private int province_id;
	//����
	private int city_id;
	//����
	private int region_id;
	//״̬
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPre_sale_number() {
		return pre_sale_number;
	}
	public void setPre_sale_number(String pre_sale_number) {
		this.pre_sale_number = pre_sale_number;
	}
	public String getReal_estate_name() {
		return real_estate_name;
	}
	public void setReal_estate_name(String real_estate_name) {
		this.real_estate_name = real_estate_name;
	}
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	public int getCount_residence_number() {
		return count_residence_number;
	}
	public void setCount_residence_number(int count_residence_number) {
		this.count_residence_number = count_residence_number;
	}
	public int getReal_estate_id() {
		return real_estate_id;
	}
	public void setReal_estate_id(int real_estate_id) {
		this.real_estate_id = real_estate_id;
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
	public int getWeb_building_id() {
		return web_building_id;
	}
	public void setWeb_building_id(int web_building_id) {
		this.web_building_id = web_building_id;
	}
	public Timestamp getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Timestamp register_time) {
		this.register_time = register_time;
	}
	public int getCount_house_number() {
		return count_house_number;
	}
	public void setCount_house_number(int count_house_number) {
		this.count_house_number = count_house_number;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
