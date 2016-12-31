package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;


public interface IRoleOrganizationDao {

    /**
     * 新增
     * @param roleOrganization
     * @return
     */
    int save(RoleOrganization roleOrganization);
    /**
     * 批量新增
     * @param roleOrganizations
     * @return
     */
    int saveBatch(List<RoleOrganization> roleOrganizations);
    
    /**
     * 修改
     * @param roleOrganization
     */
    int update(RoleOrganization roleOrganization);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param roleOrganization
     */
    int delete(RoleOrganization roleOrganization);
    
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
    RoleOrganization getById(String id);
    
    /**
     * 多条件查找
     * @param roleOrganization
     * @return
     */
    RoleOrganization getData(RoleOrganization roleOrganization);

    int count(RoleOrganizationQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<RoleOrganization> query(RoleOrganizationQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<RoleOrganization> queryAll(RoleOrganizationQueryParam param);
    
    /**
     * 根据用户ID查找机构ID
     * @param userId
     * @return
     */
    List<RoleOrganization> queryByUserId(String userId);
}
