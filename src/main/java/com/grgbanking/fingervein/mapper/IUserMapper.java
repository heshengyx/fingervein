package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.User;
import com.grgbanking.fingervein.param.UserQueryParam;


public interface IUserMapper {

    /**
     * 新增
     * @param user
     * @return
     */
    int save(@Param("param") User user);
    /**
     * 批量新增
     * @param users
     * @return
     */
    int saveBatch(@Param("list") List<User> users);
    
    /**
     * 修改
     * @param user
     */
    int update(@Param("param") User user);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param user
     */
    int delete(@Param("param") User user);
    
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
    User getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param user
     * @return
     */
    User getData(@Param("param") User user);
    
    int count(@Param("param") UserQueryParam param);
    List<User> query(@Param("param") UserQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<User> queryAll(@Param("param") UserQueryParam param);
}

