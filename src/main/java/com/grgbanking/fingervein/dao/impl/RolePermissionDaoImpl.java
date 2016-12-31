package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IRolePermissionDao;
import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.mapper.IRolePermissionMapper;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;


@Repository
public class RolePermissionDaoImpl implements IRolePermissionDao {

    @Autowired
    private IRolePermissionMapper rolePermissionMapper;
    
    @Override
    public int save(RolePermission rolePermission) {
        return rolePermissionMapper.save(rolePermission);
    }

    @Override
    public int saveBatch(List<RolePermission> rolePermissions) {
        return rolePermissionMapper.saveBatch(rolePermissions);
    }
    
    @Override
    public int update(RolePermission rolePermission) {
        return rolePermissionMapper.update(rolePermission);
    }

    @Override
    public int deleteById(String id) {
        return rolePermissionMapper.deleteById(id);
    }

    @Override
    public int delete(RolePermission rolePermission) {
        return rolePermissionMapper.delete(rolePermission);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return rolePermissionMapper.deleteByIds(ids);
    }

    @Override
    public RolePermission getById(String id) {
        return rolePermissionMapper.getById(id);
    }

    @Override
    public RolePermission getData(RolePermission rolePermission) {
        return rolePermissionMapper.getData(rolePermission);
    }

    @Override
    public int count(RolePermissionQueryParam param) {
        return rolePermissionMapper.count(param);
    }

    @Override
    public List<RolePermission> query(RolePermissionQueryParam param, int start,
            int end) {
        return rolePermissionMapper.query(param, start, end);
    }

    @Override
    public List<RolePermission> queryAll(RolePermissionQueryParam param) {
        return rolePermissionMapper.queryAll(param);
    }
}
