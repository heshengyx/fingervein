package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.RolePermissionData;
import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;


public interface IRolePermissionService {

    /**
     * 新增
     * @param rolePermission
     */
    void save(RolePermission rolePermission);
    /**
     * 批量新增
     * @param rolePermissions
     * @return
     */
    void saveBatch(List<RolePermission> rolePermissions);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(RolePermissionData data);
    
    /**
     * 修改
     * @param RolePermission
     */
    void update(RolePermission rolePermission);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param rolePermission
     */
    void delete(RolePermission rolePermission);
    
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
    RolePermission getById(String id);
    
    /**
     * 多条件查找
     * @param rolePermission
     * @return
     */
    RolePermission getData(RolePermission rolePermission);
    
    /**
     * 保存或修改
     * @param rolePermission
     */
    void saveOrUpdate(RolePermission rolePermission);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<RolePermission> query(RolePermissionQueryParam param);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<RolePermission> queryAll(RolePermissionQueryParam param);
}