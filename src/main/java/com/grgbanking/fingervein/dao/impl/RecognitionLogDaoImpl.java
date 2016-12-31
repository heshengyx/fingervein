package com.grgbanking.fingervein.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.fingervein.dao.IRecognitionLogDao;
import com.grgbanking.fingervein.data.RecognitionLogData;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.mapper.IRecognitionLogMapper;
import com.grgbanking.fingervein.param.RecognitionLogQueryParam;

@Repository
public class RecognitionLogDaoImpl implements IRecognitionLogDao {

    @Autowired
    private IRecognitionLogMapper recognitionLogMapper;
    
    @Override
    public int save(RecognitionLog recognitionLog) {
        return recognitionLogMapper.save(recognitionLog);
    }

    @Override
    public int saveBatch(List<RecognitionLog> recognitionLogs) {
        return recognitionLogMapper.saveBatch(recognitionLogs);
    }
    
    @Override
    public int update(RecognitionLog recognitionLog) {
        return recognitionLogMapper.update(recognitionLog);
    }

    @Override
    public int deleteById(String id) {
        return recognitionLogMapper.deleteById(id);
    }

    @Override
    public int delete(RecognitionLog recognitionLog) {
        return recognitionLogMapper.delete(recognitionLog);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return recognitionLogMapper.deleteByIds(ids);
    }

    @Override
    public RecognitionLog getById(String id) {
        return recognitionLogMapper.getById(id);
    }

    @Override
    public RecognitionLog getData(RecognitionLog recognitionLog) {
        return recognitionLogMapper.getData(recognitionLog);
    }

    @Override
    public int count(RecognitionLogQueryParam param) {
        return recognitionLogMapper.count(param);
    }

    @Override
    public List<RecognitionLog> query(RecognitionLogQueryParam param, int start,
            int end) {
        return recognitionLogMapper.query(param, start, end);
    }

    @Override
    public List<RecognitionLog> queryAll(RecognitionLogQueryParam param) {
        return recognitionLogMapper.queryAll(param);
    }

	@Override
	public List<RecognitionLog> queryIpaddr() {
		return recognitionLogMapper.queryIpaddr();
	}

	@Override
	public List<RecognitionLogData> queryReport(RecognitionLogQueryParam param) {
		return recognitionLogMapper.queryReport(param);
	}
}
