package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.entity.Style;
import com.grgbanking.fingervein.param.StyleQueryParam;


public interface IStyleDao {

    /**
     * 新增
     * @param style
     * @return
     */
    int save(Style style);
    /**
     * 批量新增
     * @param styles
     * @return
     */
    int saveBatch(List<Style> styles);
    
    /**
     * 修改
     * @param style
     */
    int update(Style style);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param style
     */
    int delete(Style style);
    
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
    Style getById(String id);
    
    /**
     * 多条件查找
     * @param style
     * @return
     */
    Style getData(Style style);

    int count(StyleQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Style> query(StyleQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Style> queryAll(StyleQueryParam param);
}
