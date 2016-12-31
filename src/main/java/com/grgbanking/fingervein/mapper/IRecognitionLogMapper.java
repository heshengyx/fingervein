package com.grgbanking.fingervein.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.fingervein.data.RecognitionLogData;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.param.RecognitionLogQueryParam;


public interface IRecognitionLogMapper {

    /**
     * 新增
     * @param recognitionLog
     * @return
     */
    int save(@Param("param") RecognitionLog recognitionLog);
    /**
     * 批量新增
     * @param recognitionLogs
     * @return
     */
    int saveBatch(@Param("list") List<RecognitionLog> recognitionLogs);
    
    /**
     * 修改
     * @param recognitionLog
     */
    int update(@Param("param") RecognitionLog recognitionLog);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param recognitionLog
     */
    int delete(@Param("param") RecognitionLog recognitionLog);
    
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
    RecognitionLog getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param recognitionLog
     * @return
     */
    RecognitionLog getData(@Param("param") RecognitionLog recognitionLog);
    
    int count(@Param("param") RecognitionLogQueryParam param);
    List<RecognitionLog> query(@Param("param") RecognitionLogQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<RecognitionLog> queryAll(@Param("param") RecognitionLogQueryParam param);
    
    /**
     * 查询ip地址
     * @return
     */
    List<RecognitionLog> queryIpaddr();
    
    /**
     * 识别报表
     * @return
     */
    List<RecognitionLogData> queryReport(@Param("param") RecognitionLogQueryParam param);
}

