package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.Permission;
import com.grgbanking.fingervein.param.PermissionQueryParam;


public interface IPermissionMapper {

    /**
     * 新增
     * @param permission
     * @return
     */
    int save(@Param("param") Permission permission);
    /**
     * 批量新增
     * @param permissions
     * @return
     */
    int saveBatch(@Param("list") List<Permission> permissions);
    
    /**
     * 修改
     * @param permission
     */
    int update(@Param("param") Permission permission);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param permission
     */
    int delete(@Param("param") Permission permission);
    
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
    Permission getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param permission
     * @return
     */
    Permission getData(@Param("param") Permission permission);
    
    int count(@Param("param") PermissionQueryParam param);
    List<Permission> query(@Param("param") PermissionQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Permission> queryAll(@Param("param") PermissionQueryParam param);
    
    /**
     * 查找用户权限
     */
    List<Permission> queryPermissions(@Param("param") PermissionQueryParam param);
}

