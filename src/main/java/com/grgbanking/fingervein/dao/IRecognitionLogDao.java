package com.grgbanking.fingervein.dao;

import java.util.List;

import com.grgbanking.fingervein.data.RecognitionLogData;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.param.RecognitionLogQueryParam;


public interface IRecognitionLogDao {

    /**
     * 新增
     * @param recognitionLog
     * @return
     */
    int save(RecognitionLog recognitionLog);
    /**
     * 批量新增
     * @param recognitionLogs
     * @return
     */
    int saveBatch(List<RecognitionLog> recognitionLogs);
    
    /**
     * 修改
     * @param recognitionLog
     */
    int update(RecognitionLog recognitionLog);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param recognitionLog
     */
    int delete(RecognitionLog recognitionLog);
    
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
    RecognitionLog getById(String id);
    
    /**
     * 多条件查找
     * @param recognitionLog
     * @return
     */
    RecognitionLog getData(RecognitionLog recognitionLog);

    int count(RecognitionLogQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<RecognitionLog> query(RecognitionLogQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<RecognitionLog> queryAll(RecognitionLogQueryParam param);
    
    /**
     * 查询ip地址
     * @return
     */
    List<RecognitionLog> queryIpaddr();
    
    /**
     * 识别报表
     * @return
     */
    List<RecognitionLogData> queryReport(RecognitionLogQueryParam param);
}
