package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.Terminal;
import com.grgbanking.fingervein.param.TerminalQueryParam;


public interface ITerminalDao {

    /**
     * 新增
     * @param terminal
     * @return
     */
    int save(Terminal terminal);
    /**
     * 批量新增
     * @param terminals
     * @return
     */
    int saveBatch(List<Terminal> terminals);
    
    /**
     * 修改
     * @param terminal
     */
    int update(Terminal terminal);
    
    /**
     * 批量修改
     * @param terminal
     * @param ids
     * @return
     */
    int updateByIds(Terminal terminal, List<String> ids);
    
    /**
     * 批量修改超时断线状态
     * @param terminal
     * @param timeout
     * @return
     */
    int updateByTimeout(Terminal terminal, int timeout);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param terminal
     */
    int delete(Terminal terminal);
    
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
    Terminal getById(String id);
    
    /**
     * 多条件查找
     * @param terminal
     * @return
     */
    Terminal getData(Terminal terminal);

    int count(TerminalQueryParam param);
    /**
     * 分页查询
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Terminal> query(TerminalQueryParam param, int start, int end);
    
    int countData(TerminalQueryParam param);
    /**
     * 分页查询
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Terminal> queryData(TerminalQueryParam param, int start, int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Terminal> queryAll(TerminalQueryParam param);
    
    /**
     * 根据用户Id查找终端
     * @param userId
     * @return
     */
    List<Terminal> queryByUserId(String userId);
    
    /**
     * 查找超时断线终端
     * @param userId
     * @return
     */
    List<Terminal> queryTimeout(int timeout);
}
