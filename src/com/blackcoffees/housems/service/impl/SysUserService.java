package com.blackcoffees.housems.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffees.housems.db.dao.SysUserMapper;
import com.blackcoffees.housems.db.entity.SysUser;
import com.blackcoffees.housems.db.entity.SysUserLoginLog;
import com.blackcoffees.housems.service.ISysUserLoginLogService;
import com.blackcoffees.housems.service.ISysUserService;
import com.blackcoffees.housems.util.DateUtil;
import com.blackcoffees.housems.util.Pager;
import com.blackcoffees.housems.util.ReturnJsonData;
import com.ndktools.javamd5.Mademd5;

@Service("sysUserService")
public class SysUserService implements ISysUserService{

	@Autowired
	private SysUserMapper mapper;
	
	@Autowired
	private ISysUserLoginLogService userLoginLogService;

	@Override
	public SysUser userLogin(SysUser user) {
		// TODO Auto-generated method stub
		Mademd5 md5 = new Mademd5();
		user.setPassword(md5.toMd5(user.getPassword()));
		int user_id = mapper.userLogin(user);
		if(user_id > 0){
			user.setId(user_id);
			user.setLast_login(DateUtil.getNow());
			this.updateUserLastLogin(user);
			SysUserLoginLog loginLog = new SysUserLoginLog();
			loginLog.setCreated(DateUtil.getNow());
			loginLog.setUser_id(user_id);
			userLoginLogService.addLoginLog(loginLog);
			return user;
		}
		else{
			return null;
		}
	}

	@Override
	public int updateUserLastLogin(SysUser user) {
		// TODO Auto-generated method stub
		return mapper.updateUserLastLogin(user);
	}

	@Override
	public SysUser getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.getUserByUsername(username);
	}

	@Override
	public List<SysUser> getAllUser(Pager pager) {
		// TODO Auto-generated method stub
		return mapper.getAllUser(pager);
	}

	@Override
	public Map<String, Object> addUser(SysUser user) {
		// TODO Auto-generated method stub
		Map<String, Object> result = ReturnJsonData.getReturnMap();
		user.setCreated(DateUtil.getNow());
		user.setStatus(1);
		Mademd5 md5 = new Mademd5();
		user.setPassword(md5.toMd5("123456"));
		if(mapper.addUser(user) > 0){
			result.put("succ", true);
			result.put("message", "新增用户成功");
		}
		else{
			result.put("message", "新增用户失败");
		}
		return result;
	}

	@Override
	public int updateUserStatus(SysUser user) {
		// TODO Auto-generated method stub
		user.setUpdated(DateUtil.getNow());
		return mapper.updateUserStatus(user);
	}

	@Override
	public int updateResetPassword(SysUser user) {
		// TODO Auto-generated method stub
		user.setUpdated(DateUtil.getNow());
		Mademd5 md5 = new Mademd5();
		user.setPassword(md5.toMd5("123456"));
		return mapper.updateResetPassword(user);
	}
}
