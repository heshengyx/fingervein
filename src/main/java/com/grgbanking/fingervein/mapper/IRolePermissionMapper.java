package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;


public interface IRolePermissionMapper {

    /**
     * 新增
     * @param rolePermission
     * @return
     */
    int save(@Param("param") RolePermission rolePermission);
    /**
     * 批量新增
     * @param rolePermissions
     * @return
     */
    int saveBatch(@Param("list") List<RolePermission> rolePermissions);
    
    /**
     * 修改
     * @param rolePermission
     */
    int update(@Param("param") RolePermission rolePermission);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param rolePermission
     */
    int delete(@Param("param") RolePermission rolePermission);
    
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
    RolePermission getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param rolePermission
     * @return
     */
    RolePermission getData(@Param("param") RolePermission rolePermission);
    
    int count(@Param("param") RolePermissionQueryParam param);
    List<RolePermission> query(@Param("param") RolePermissionQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<RolePermission> queryAll(@Param("param") RolePermissionQueryParam param);
}

