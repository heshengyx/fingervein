package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.PermissionData;
import com.grgbanking.fingervein.entity.Permission;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.PermissionQueryParam;


public interface IPermissionService {

    /**
     * 新增
     * @param permission
     */
    void save(Permission permission);
    /**
     * 批量新增
     * @param permissions
     * @return
     */
    void saveBatch(List<Permission> permissions);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(PermissionData data);
    
    /**
     * 修改
     * @param Permission
     */
    void update(Permission permission);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param permission
     */
    void delete(Permission permission);
    
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
    Permission getById(String id);
    
    /**
     * 多条件查找
     * @param permission
     * @return
     */
    Permission getData(Permission permission);
    
    /**
     * 保存或修改
     * @param permission
     */
    void saveOrUpdate(Permission permission);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<Permission> query(PermissionQueryParam param);
    
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