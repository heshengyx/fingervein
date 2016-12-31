package com.grgbanking.fingervein.service;

import java.io.File;
import java.util.List;

import com.grgbanking.fingervein.data.RecognitionLogData;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.param.RecognitionLogQueryParam;


public interface IRecognitionLogService {

    /**
     * 新增
     * @param recognitionLog
     */
    void save(RecognitionLog recognitionLog);
    /**
     * 批量新增
     * @param recognitionLogs
     * @return
     */
    void saveBatch(List<RecognitionLog> recognitionLogs);
    /**
     * 批量新增
     * @param data
     * @return
     */
    void saveBatchData(RecognitionLogData data);
    
    /**
     * 修改
     * @param RecognitionLog
     */
    void update(RecognitionLog recognitionLog);
    
    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);
    
    /**
     * 多条件删除
     * @param recognitionLog
     */
    void delete(RecognitionLog recognitionLog);
    
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
    RecognitionLog getById(String id);
    
    /**
     * 多条件查找
     * @param recognitionLog
     * @return
     */
    RecognitionLog getData(RecognitionLog recognitionLog);
    
    /**
     * 保存或修改
     * @param recognitionLog
     */
    void saveOrUpdate(RecognitionLog recognitionLog);
    
    /**
     * 查询分页
     * @param param
     * @return
     */
    IPage<RecognitionLog> query(RecognitionLogQueryParam param);
    
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
    
    /**
     * 检测日志文件是否存在
     * @param id
     */
    File exists(String id);
}