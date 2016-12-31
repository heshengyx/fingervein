package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.UserRoleData;
import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.UserRoleQueryParam;


public interface IUserRoleService {

    /**
     * 新增
     * @param userRole
     */
    void save(UserRole userRole);
    /**
     * 批量新增
     * @param userRoles
     * @return
     */
    void saveBatch(List<UserRole> userRoles);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(UserRoleData data);
    
    /**
     * 修改
     * @param UserRole
     */
    void update(UserRole userRole);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param userRole
     */
    void delete(UserRole userRole);
    
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
    UserRole getById(String id);
    
    /**
     * 多条件查找
     * @param userRole
     * @return
     */
    UserRole getData(UserRole userRole);
    
    /**
     * 保存或修改
     * @param userRole
     */
    void saveOrUpdate(UserRole userRole);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<UserRole> query(UserRoleQueryParam param);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<UserRole> queryAll(UserRoleQueryParam param);
}