package com.grgbanking.fingervein.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IPermissionDao;
import com.grgbanking.fingervein.data.PermissionData;
import com.grgbanking.fingervein.entity.Permission;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.PermissionQueryParam;
import com.grgbanking.fingervein.service.IPermissionService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;


@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;
    
    @Override
    public void save(Permission permission) {
        String name = permission.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("监测点编号不能为空");
}

        permission.setId(UUIDGeneratorUtil.getUUID());
        permission.setCreateTime(new Date());
        
        int count = permissionDao.save(permission);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Permission> permissions) {
        Permission permission = null;
        for (int i = 0; i < permissions.size(); i++) {
            permission = permissions.get(i);
            permission.setId(UUIDGeneratorUtil.getUUID());
            permission.setCreateTime(new Date());
            permissions.set(i, permission);
        }
        int count = permissionDao.saveBatch(permissions);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(PermissionData data) {
                //
    }
    
    @Override
    public void update(Permission permission) {
        String name = permission.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("监测点编号不能为空");
}

        permission.setUpdateTime(new Date());
        int count = permissionDao.update(permission);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = permissionDao.deleteById(id);
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
            int count = permissionDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Permission permission) {
        int count = permissionDao.delete(permission);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Permission getById(String id) {
        return permissionDao.getById(id);
    }

    @Override
    public Permission getData(Permission permission) {
        return permissionDao.getData(permission);
    }
    
    @Override
    public void saveOrUpdate(Permission permission) {
        if (StringUtils.isEmpty(permission.getId())) {
            save(permission);
        } else {
            update(permission);
        }
    }

    @Override
    public IPage<Permission> query(final PermissionQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Permission>() {

            @Override
            public int count() {
                return permissionDao.count(param);
            }

            @Override
            public List<Permission> query(int start, int end) {
                return permissionDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Permission> queryAll(PermissionQueryParam param) {
		return permissionDao.queryAll(param);
	}

	@Override
	public List<Permission> queryPermissions(PermissionQueryParam param) {
		return permissionDao.queryPermissions(param);
	}
}