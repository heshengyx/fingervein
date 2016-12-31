package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;


public interface IRolePermissionDao {

    /**
     * 新增
     * @param rolePermission
     * @return
     */
    int save(RolePermission rolePermission);
    /**
     * 批量新增
     * @param rolePermissions
     * @return
     */
    int saveBatch(List<RolePermission> rolePermissions);
    
    /**
     * 修改
     * @param rolePermission
     */
    int update(RolePermission rolePermission);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param rolePermission
     */
    int delete(RolePermission rolePermission);
    
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
    RolePermission getById(String id);
    
    /**
     * 多条件查找
     * @param rolePermission
     * @return
     */
    RolePermission getData(RolePermission rolePermission);

    int count(RolePermissionQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<RolePermission> query(RolePermissionQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<RolePermission> queryAll(RolePermissionQueryParam param);
}
