package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.Role;
import com.grgbanking.fingervein.param.RoleQueryParam;


public interface IRoleMapper {

    /**
     * 新增
     * @param role
     * @return
     */
    int save(@Param("param") Role role);
    /**
     * 批量新增
     * @param roles
     * @return
     */
    int saveBatch(@Param("list") List<Role> roles);
    
    /**
     * 修改
     * @param role
     */
    int update(@Param("param") Role role);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param role
     */
    int delete(@Param("param") Role role);
    
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
    Role getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param role
     * @return
     */
    Role getData(@Param("param") Role role);
    
    int count(@Param("param") RoleQueryParam param);
    List<Role> query(@Param("param") RoleQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Role> queryAll(@Param("param") RoleQueryParam param);
}

