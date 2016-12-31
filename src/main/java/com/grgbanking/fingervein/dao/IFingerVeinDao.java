package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.data.FingerVeinData;
import com.grgbanking.fingervein.entity.FingerVein;
import com.grgbanking.fingervein.param.FingerVeinQueryParam;


public interface IFingerVeinDao {

    /**
     * 新增
     * @param fingerVein
     * @return
     */
    int save(FingerVein fingerVein);
    /**
     * 批量新增
     * @param fingerVeins
     * @return
     */
    int saveBatch(List<FingerVein> fingerVeins);
    
    /**
     * 修改
     * @param fingerVein
     */
    int update(FingerVein fingerVein);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param fingerVein
     */
    int delete(FingerVein fingerVein);
    
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
    FingerVein getById(String id);
    
    /**
     * 多条件查找
     * @param fingerVein
     * @return
     */
    FingerVein getData(FingerVein fingerVein);

    int count(FingerVeinQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<FingerVein> query(FingerVeinQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<FingerVein> queryAll(FingerVeinQueryParam param);
    
    List<FingerVeinData> queryData();
}
