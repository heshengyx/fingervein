package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.data.FingerVeinData;
import com.grgbanking.fingervein.entity.FingerVein;
import com.grgbanking.fingervein.param.FingerVeinQueryParam;


public interface IFingerVeinMapper {

    /**
     * 新增
     * @param fingerVein
     * @return
     */
    int save(@Param("param") FingerVein fingerVein);
    /**
     * 批量新增
     * @param fingerVeins
     * @return
     */
    int saveBatch(@Param("list") List<FingerVein> fingerVeins);
    
    /**
     * 修改
     * @param fingerVein
     */
    int update(@Param("param") FingerVein fingerVein);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param fingerVein
     */
    int delete(@Param("param") FingerVein fingerVein);
    
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
    FingerVein getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param fingerVein
     * @return
     */
    FingerVein getData(@Param("param") FingerVein fingerVein);
    
    int count(@Param("param") FingerVeinQueryParam param);
    List<FingerVein> query(@Param("param") FingerVeinQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<FingerVein> queryAll(@Param("param") FingerVeinQueryParam param);
    
    List<FingerVeinData> queryData();
}

