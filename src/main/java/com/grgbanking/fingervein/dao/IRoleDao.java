package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.Role;
import com.grgbanking.fingervein.param.RoleQueryParam;


public interface IRoleDao {

    /**
     * 新增
     * @param role
     * @return
     */
    int save(Role role);
    /**
     * 批量新增
     * @param roles
     * @return
     */
    int saveBatch(List<Role> roles);
    
    /**
     * 修改
     * @param role
     */
    int update(Role role);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param role
     */
    int delete(Role role);
    
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
    Role getById(String id);
    
    /**
     * 多条件查找
     * @param role
     * @return
     */
    Role getData(Role role);

    int count(RoleQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Role> query(RoleQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Role> queryAll(RoleQueryParam param);
}
