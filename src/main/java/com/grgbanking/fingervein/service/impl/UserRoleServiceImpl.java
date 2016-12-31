package com.grgbanking.fingervein.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IUserRoleDao;
import com.grgbanking.fingervein.data.UserRoleData;
import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.UserRoleQueryParam;
import com.grgbanking.fingervein.service.IUserRoleService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public void save(UserRole userRole) {
		String userId = userRole.getUserId();
		if (StringUtils.isEmpty(userId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		userRole.setId(UUIDGeneratorUtil.getUUID());
		userRole.setCreateTime(new Date());

		int count = userRoleDao.save(userRole);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<UserRole> userRoles) {
		UserRole userRole = null;
		for (int i = 0; i < userRoles.size(); i++) {
			userRole = userRoles.get(i);
			userRole.setId(UUIDGeneratorUtil.getUUID());
			userRole.setCreateTime(new Date());
			userRoles.set(i, userRole);
		}
		int count = userRoleDao.saveBatch(userRoles);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(UserRoleData data) {
		// 删除用户角色树
		UserRole userRole = new UserRole();
		userRole.setUserId(data.getUserId());
		userRoleDao.delete(userRole);

		// 保存用户角色树
		List<UserRole> userRoles = new ArrayList<UserRole>();
		String[] roleIds = data.getRoleId();
		for (int i = 0; i < roleIds.length; i++) {
			userRole = new UserRole();
			userRole.setId(UUIDGeneratorUtil.getUUID());
			userRole.setUserId(data.getUserId());
			userRole.setRoleId(roleIds[i]);
			userRole.setCreateBy(data.getCreateBy());
			userRole.setCreateTime(new Date());
			userRoles.add(userRole);
		}
		int count = userRoleDao.saveBatch(userRoles);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void update(UserRole userRole) {
		String userId = userRole.getUserId();
		if (StringUtils.isEmpty(userId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		userRole.setUpdateTime(new Date());
		int count = userRoleDao.update(userRole);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = userRoleDao.deleteById(id);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void deleteByIds(List<String> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			int count = userRoleDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(UserRole userRole) {
		int count = userRoleDao.delete(userRole);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public UserRole getById(String id) {
		return userRoleDao.getById(id);
	}

	@Override
	public UserRole getData(UserRole userRole) {
		return userRoleDao.getData(userRole);
	}

	@Override
	public void saveOrUpdate(UserRole userRole) {
		if (StringUtils.isEmpty(userRole.getId())) {
			save(userRole);
		} else {
			update(userRole);
		}
	}

	@Override
	public IPage<UserRole> query(final UserRoleQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<UserRole>() {

			@Override
			public int count() {
				return userRoleDao.count(param);
			}

			@Override
			public List<UserRole> query(int start, int end) {
				return userRoleDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<UserRole> queryAll(UserRoleQueryParam param) {
		return userRoleDao.queryAll(param);
	}
}