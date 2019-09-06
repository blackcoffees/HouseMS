package com.blackcoffees.housems.db.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blackcoffees.housems.db.entity.SysModule;
import com.blackcoffees.housems.util.Pager;

public interface SysModuleMapper {
	public List<SysModule> getAllModule(@Param("pager") Pager pager);
	
	public int addModule(@Param("module") SysModule module);
	
	public int checkModuleUnique(@Param("module")SysModule module);
	
	public int updateModuleStatus(@Param("module")SysModule module);
	
	public int updateModule(@Param("module")SysModule module);
	
	public List<SysModule> getModuleTreeNode(@Param("parent_id")int parent_id);
	
	public List<SysModule> getRootChildModule();
	
	public List<SysModule> getRootModuleByIds(@Param("module_ids")int[] module_ids);
	
	public List<SysModule> getUserModule(@Param("user_id")int user_id);
}
