package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IUserRoleDao;
import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.mapper.IUserRoleMapper;
import com.grgbanking.fingervein.param.UserRoleQueryParam;


@Repository
public class UserRoleDaoImpl implements IUserRoleDao {

    @Autowired
    private IUserRoleMapper userRoleMapper;
    
    @Override
    public int save(UserRole userRole) {
        return userRoleMapper.save(userRole);
    }

    @Override
    public int saveBatch(List<UserRole> userRoles) {
        return userRoleMapper.saveBatch(userRoles);
    }
    
    @Override
    public int update(UserRole userRole) {
        return userRoleMapper.update(userRole);
    }

    @Override
    public int deleteById(String id) {
        return userRoleMapper.deleteById(id);
    }

    @Override
    public int delete(UserRole userRole) {
        return userRoleMapper.delete(userRole);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return userRoleMapper.deleteByIds(ids);
    }

    @Override
    public UserRole getById(String id) {
        return userRoleMapper.getById(id);
    }

    @Override
    public UserRole getData(UserRole userRole) {
        return userRoleMapper.getData(userRole);
    }

    @Override
    public int count(UserRoleQueryParam param) {
        return userRoleMapper.count(param);
    }

    @Override
    public List<UserRole> query(UserRoleQueryParam param, int start,
            int end) {
        return userRoleMapper.query(param, start, end);
    }

    @Override
    public List<UserRole> queryAll(UserRoleQueryParam param) {
        return userRoleMapper.queryAll(param);
    }
}
