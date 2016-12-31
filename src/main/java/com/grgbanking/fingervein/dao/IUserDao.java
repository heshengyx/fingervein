package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.User;
import com.grgbanking.fingervein.param.UserQueryParam;


public interface IUserDao {

    /**
     * 新增
     * @param user
     * @return
     */
    int save(User user);
    /**
     * 批量新增
     * @param users
     * @return
     */
    int saveBatch(List<User> users);
    
    /**
     * 修改
     * @param user
     */
    int update(User user);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param user
     */
    int delete(User user);
    
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
    User getById(String id);
    
    /**
     * 多条件查找
     * @param user
     * @return
     */
    User getData(User user);

    int count(UserQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<User> query(UserQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<User> queryAll(UserQueryParam param);
}
