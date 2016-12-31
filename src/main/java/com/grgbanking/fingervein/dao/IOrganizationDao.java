package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.Organization;
import com.grgbanking.fingervein.param.OrganizationQueryParam;

public interface IOrganizationDao {

	/**
	 * 新增
	 * @param organization
	 * @return
	 */
	int save(Organization organization);
	/**
	 * 批量新增
	 * @param organizations
	 * @return
	 */
	int saveBatch(List<Organization> organizations);
	
	/**
	 * 修改
	 * @param organization
	 */
	int update(Organization organization);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	int deleteById(String id);
	
	/**
	 * 多条件删除
	 * @param organization
	 */
	int delete(Organization organization);
	
	/**
	 * 根据ID批量删除
	 * @param id
	 */
	int deleteByIds(List<String> ids);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	Organization getById(String id);
	
	/**
	 * 多条件查找
	 * @param organization
	 * @return
	 */
	Organization getData(Organization organization);

	int count(OrganizationQueryParam param);
	/**
	 * 分页查询
	 * @param param
	 * @param start
	 * @param end
	 * @return
	 */
	List<Organization> query(OrganizationQueryParam param, int start, int end);
	
	/**
	 * 查找全部
	 * @param param
	 * @return
	 */
	List<Organization> queryAll(OrganizationQueryParam param);
}
