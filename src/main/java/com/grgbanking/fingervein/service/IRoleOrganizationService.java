package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.RoleOrganizationData;
import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;


public interface IRoleOrganizationService {

    /**
     * 新增
     * @param roleOrganization
     */
    void save(RoleOrganization roleOrganization);
    /**
     * 批量新增
     * @param roleOrganizations
     * @return
     */
    void saveBatch(List<RoleOrganization> roleOrganizations);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(RoleOrganizationData data);
    
    /**
     * 修改
     * @param RoleOrganization
     */
    void update(RoleOrganization roleOrganization);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param roleOrganization
     */
    void delete(RoleOrganization roleOrganization);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    void deleteByIds(List<String> ids);
    
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
    
    /**
     * 保存或修改
     * @param roleOrganization
     */
    void saveOrUpdate(RoleOrganization roleOrganization);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<RoleOrganization> query(RoleOrganizationQueryParam param);
    
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