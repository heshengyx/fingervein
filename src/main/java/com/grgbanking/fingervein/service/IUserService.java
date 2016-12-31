package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.data.UserData;
import com.grgbanking.fingervein.entity.User;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.UserQueryParam;


public interface IUserService {

    /**
     * 新增
     * @param user
     */
    void save(User user);
    /**
     * 批量新增
     * @param users
     * @return
     */
    void saveBatch(List<User> users);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(UserData data);
    
    /**
     * 修改
     * @param User
     */
    void update(User user);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param user
     */
    void delete(User user);
    
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
    User getById(String id);
    
    /**
     * 多条件查找
     * @param user
     * @return
     */
    User getData(User user);
    
    /**
     * 保存或修改
     * @param user
     */
    void saveOrUpdate(User user);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<User> query(UserQueryParam param);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<User> queryAll(UserQueryParam param);
}