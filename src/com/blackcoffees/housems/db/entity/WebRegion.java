package com.blackcoffees.housems.db.entity;

import java.sql.Timestamp;

public class WebRegion {
	private int id;
	private int region_id;
	private int web_source_id;
	private int web_region_id;
	private Timestamp created;
	private Timestamp updated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public int getWeb_source_id() {
		return web_source_id;
	}
	public void setWeb_source_id(int web_source_id) {
		this.web_source_id = web_source_id;
	}
	public int getWeb_region_id() {
		return web_region_id;
	}
	public void setWeb_region_id(int web_region_id) {
		this.web_region_id = web_region_id;
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
