package com.blackcoffees.housems.db.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleTreeNode {
	private int id;
	private String text;
	private List<ModuleTreeNode> children = new ArrayList<ModuleTreeNode>();;
	private Map<String, Boolean> state = new HashMap<String, Boolean>();
	private String href;
	private String icon;
	private int parent_id;
	
	public ModuleTreeNode(){
		this.state.put("opened", false);
		this.state.put("disabled", false);
		this.state.put("selected", false);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<ModuleTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<ModuleTreeNode> children) {
		this.children = children;
	}
	public Map<String, Boolean> getState() {
		return state;
	}
	public void setState(Map<String, Boolean> state) {
		this.state = state;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
}
