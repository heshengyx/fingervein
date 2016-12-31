package com.grgbanking.fingervein.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IRoleOrganizationDao;
import com.grgbanking.fingervein.data.RoleOrganizationData;
import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;
import com.grgbanking.fingervein.service.IRoleOrganizationService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("roleOrganizationService")
public class RoleOrganizationServiceImpl implements IRoleOrganizationService {

	@Autowired
	private IRoleOrganizationDao roleOrganizationDao;

	@Override
	public void save(RoleOrganization roleOrganization) {
		String roleId = roleOrganization.getRoleId();
		if (StringUtils.isEmpty(roleId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		roleOrganization.setId(UUIDGeneratorUtil.getUUID());
		roleOrganization.setCreateTime(new Date());

		int count = roleOrganizationDao.save(roleOrganization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<RoleOrganization> roleOrganizations) {
		RoleOrganization roleOrganization = null;
		for (int i = 0; i < roleOrganizations.size(); i++) {
			roleOrganization = roleOrganizations.get(i);
			roleOrganization.setId(UUIDGeneratorUtil.getUUID());
			roleOrganization.setCreateTime(new Date());
			roleOrganizations.set(i, roleOrganization);
		}
		int count = roleOrganizationDao.saveBatch(roleOrganizations);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(RoleOrganizationData data) {
		//
	}

	@Override
	public void update(RoleOrganization roleOrganization) {
		String roleId = roleOrganization.getRoleId();
		if (StringUtils.isEmpty(roleId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		roleOrganization.setUpdateTime(new Date());
		int count = roleOrganizationDao.update(roleOrganization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = roleOrganizationDao.deleteById(id);
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
			int count = roleOrganizationDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(RoleOrganization roleOrganization) {
		int count = roleOrganizationDao.delete(roleOrganization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public RoleOrganization getById(String id) {
		return roleOrganizationDao.getById(id);
	}

	@Override
	public RoleOrganization getData(RoleOrganization roleOrganization) {
		return roleOrganizationDao.getData(roleOrganization);
	}

	@Override
	public void saveOrUpdate(RoleOrganization roleOrganization) {
		if (StringUtils.isEmpty(roleOrganization.getId())) {
			save(roleOrganization);
		} else {
			update(roleOrganization);
		}
	}

	@Override
	public IPage<RoleOrganization> query(final RoleOrganizationQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<RoleOrganization>() {

			@Override
			public int count() {
				return roleOrganizationDao.count(param);
			}

			@Override
			public List<RoleOrganization> query(int start, int end) {
				return roleOrganizationDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<RoleOrganization> queryAll(RoleOrganizationQueryParam param) {
		return roleOrganizationDao.queryAll(param);
	}

	@Override
	public List<RoleOrganization> queryByUserId(String userId) {
		return roleOrganizationDao.queryByUserId(userId);
	}
}