package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.param.UserRoleQueryParam;


public interface IUserRoleMapper {

    /**
     * 新增
     * @param userRole
     * @return
     */
    int save(@Param("param") UserRole userRole);
    /**
     * 批量新增
     * @param userRoles
     * @return
     */
    int saveBatch(@Param("list") List<UserRole> userRoles);
    
    /**
     * 修改
     * @param userRole
     */
    int update(@Param("param") UserRole userRole);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param userRole
     */
    int delete(@Param("param") UserRole userRole);
    
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
    UserRole getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param userRole
     * @return
     */
    UserRole getData(@Param("param") UserRole userRole);
    
    int count(@Param("param") UserRoleQueryParam param);
    List<UserRole> query(@Param("param") UserRoleQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<UserRole> queryAll(@Param("param") UserRoleQueryParam param);
}

