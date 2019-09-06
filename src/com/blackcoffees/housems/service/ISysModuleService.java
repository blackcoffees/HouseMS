package com.blackcoffees.housems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysModule;
import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.db.query.ModuleTreeNode;
import com.blackcoffees.housems.util.Pager;

public interface ISysModuleService {
	public List<SysModule> getAllModule(Pager pager);
	
	public Map<String, Object> addModule(SysModule module, SysUser user);
	
	public int checkModuleUnique(SysModule module);
	
	public int updateModuleStatus(SysModule module);
	
	public Map<String, Object> updateModule(SysModule module, SysUser user);
	
	public List<SysModule> getModuleTreeNode(int parent_id);
	
	public List<ModuleTreeNode> getModuleTree(int user_id);
	
	public List<SysModule> getRootChildModule();
	
	public List<SysModule> getRootModuleByIds(int[] module_ids);
	
	public List<ModuleTreeNode> getUserModule(int user_id);
}
