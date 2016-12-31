package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.param.UserRoleQueryParam;


public interface IUserRoleDao {

    /**
     * 新增
     * @param userRole
     * @return
     */
    int save(UserRole userRole);
    /**
     * 批量新增
     * @param userRoles
     * @return
     */
    int saveBatch(List<UserRole> userRoles);
    
    /**
     * 修改
     * @param userRole
     */
    int update(UserRole userRole);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param userRole
     */
    int delete(UserRole userRole);
    
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
    UserRole getById(String id);
    
    /**
     * 多条件查找
     * @param userRole
     * @return
     */
    UserRole getData(UserRole userRole);

    int count(UserRoleQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<UserRole> query(UserRoleQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<UserRole> queryAll(UserRoleQueryParam param);
}
