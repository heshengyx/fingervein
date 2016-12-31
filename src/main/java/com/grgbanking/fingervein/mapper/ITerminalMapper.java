package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.entity.Terminal;
import com.grgbanking.fingervein.param.TerminalQueryParam;


public interface ITerminalMapper {

    /**
     * 新增
     * @param terminal
     * @return
     */
    int save(@Param("param") Terminal terminal);
    /**
     * 批量新增
     * @param terminals
     * @return
     */
    int saveBatch(@Param("list") List<Terminal> terminals);
    
    /**
     * 修改
     * @param terminal
     */
    int update(@Param("param") Terminal terminal);
    
    /**
     * 批量修改
     * @param terminal
     * @param ids
     * @return
     */
    int updateByIds(@Param("param") Terminal terminal, @Param("ids") List<String> ids);
    
    /**
     * 批量修改超时断线状态
     * @param terminal
     * @param timeout
     * @return
     */
    int updateByTimeout(@Param("param") Terminal terminal, @Param("timeout") int timeout);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param terminal
     */
    int delete(@Param("param") Terminal terminal);
    
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
    Terminal getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param terminal
     * @return
     */
    Terminal getData(@Param("param") Terminal terminal);
    
    int count(@Param("param") TerminalQueryParam param);
    List<Terminal> query(@Param("param") TerminalQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    int countData(@Param("param") TerminalQueryParam param);
    List<Terminal> queryData(@Param("param") TerminalQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Terminal> queryAll(@Param("param") TerminalQueryParam param);
    
    /**
     * 根据用户Id查找终端
     * @param userId
     * @return
     */
    List<Terminal> queryByUserId(@Param("userId") String userId);
    
    /**
     * 查找超时断线终端
     * @param userId
     * @return
     */
    List<Terminal> queryTimeout(@Param("timeout") int timeout);
}

