package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IRoleOrganizationDao;
import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.mapper.IRoleOrganizationMapper;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;


@Repository
public class RoleOrganizationDaoImpl implements IRoleOrganizationDao {

    @Autowired
    private IRoleOrganizationMapper roleOrganizationMapper;
    
    @Override
    public int save(RoleOrganization roleOrganization) {
        return roleOrganizationMapper.save(roleOrganization);
    }

    @Override
    public int saveBatch(List<RoleOrganization> roleOrganizations) {
        return roleOrganizationMapper.saveBatch(roleOrganizations);
    }
    
    @Override
    public int update(RoleOrganization roleOrganization) {
        return roleOrganizationMapper.update(roleOrganization);
    }

    @Override
    public int deleteById(String id) {
        return roleOrganizationMapper.deleteById(id);
    }

    @Override
    public int delete(RoleOrganization roleOrganization) {
        return roleOrganizationMapper.delete(roleOrganization);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return roleOrganizationMapper.deleteByIds(ids);
    }

    @Override
    public RoleOrganization getById(String id) {
        return roleOrganizationMapper.getById(id);
    }

    @Override
    public RoleOrganization getData(RoleOrganization roleOrganization) {
        return roleOrganizationMapper.getData(roleOrganization);
    }

    @Override
    public int count(RoleOrganizationQueryParam param) {
        return roleOrganizationMapper.count(param);
    }

    @Override
    public List<RoleOrganization> query(RoleOrganizationQueryParam param, int start,
            int end) {
        return roleOrganizationMapper.query(param, start, end);
    }

    @Override
    public List<RoleOrganization> queryAll(RoleOrganizationQueryParam param) {
        return roleOrganizationMapper.queryAll(param);
    }

	@Override
	public List<RoleOrganization> queryByUserId(String userId) {
		return roleOrganizationMapper.queryByUserId(userId);
	}
}
