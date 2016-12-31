package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.Permission;
import com.grgbanking.fingervein.param.PermissionQueryParam;


public interface IPermissionDao {

    /**
     * 新增
     * @param permission
     * @return
     */
    int save(Permission permission);
    /**
     * 批量新增
     * @param permissions
     * @return
     */
    int saveBatch(List<Permission> permissions);
    
    /**
     * 修改
     * @param permission
     */
    int update(Permission permission);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param permission
     */
    int delete(Permission permission);
    
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
    Permission getById(String id);
    
    /**
     * 多条件查找
     * @param permission
     * @return
     */
    Permission getData(Permission permission);

    int count(PermissionQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Permission> query(PermissionQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Permission> queryAll(PermissionQueryParam param);
    
    /**
     * 查找用户权限
     */
    List<Permission> queryPermissions(PermissionQueryParam param);
}
