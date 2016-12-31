package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.Organization;
import com.grgbanking.fingervein.param.OrganizationQueryParam;

public interface IOrganizationMapper {

	/**
	 * 新增
	 * @param organization
	 * @return
	 */
	int save(@Param("param") Organization organization);
	/**
	 * 批量新增
	 * @param organizations
	 * @return
	 */
	int saveBatch(@Param("list") List<Organization> organizations);
	
	/**
	 * 修改
	 * @param organization
	 */
	int update(@Param("param") Organization organization);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	int deleteById(@Param("id") String id);
	
	/**
	 * 多条件删除
	 * @param organization
	 */
	int delete(@Param("param") Organization organization);
	
	/**
	 * 根据ID批量删除
	 * @param id
	 */
	int deleteByIds(@Param("ids") List<String> ids);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	Organization getById(@Param("id") String id);
	
	/**
	 * 多条件查找
	 * @param organization
	 * @return
	 */
	Organization getData(@Param("param") Organization organization);
	
	int count(@Param("param") OrganizationQueryParam param);
	List<Organization> query(@Param("param") OrganizationQueryParam param,
			@Param("start") int start, @Param("end") int end);
	
	/**
	 * 查找全部
	 * @param param
	 * @return
	 */
	List<Organization> queryAll(@Param("param") OrganizationQueryParam param);
}
