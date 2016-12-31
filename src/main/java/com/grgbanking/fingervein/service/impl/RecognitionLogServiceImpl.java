package com.grgbanking.fingervein.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IRecognitionLogDao;
import com.grgbanking.fingervein.data.RecognitionLogData;
import com.grgbanking.fingervein.entity.RecognitionLog;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.RecognitionLogQueryParam;
import com.grgbanking.fingervein.service.IRecognitionLogService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("recognitionLogService")
public class RecognitionLogServiceImpl implements IRecognitionLogService {

	@Value("${fingervein.folder}")
	private String folder;
	
    @Autowired
    private IRecognitionLogDao recognitionLogDao;
    
    @Override
    public void save(RecognitionLog recognitionLog) {
        recognitionLog.setId(UUIDGeneratorUtil.getUUID());
        recognitionLog.setCreateTime(new Date());
        
        int count = recognitionLogDao.save(recognitionLog);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<RecognitionLog> recognitionLogs) {
        RecognitionLog recognitionLog = null;
        for (int i = 0; i < recognitionLogs.size(); i++) {
            recognitionLog = recognitionLogs.get(i);
            recognitionLog.setId(UUIDGeneratorUtil.getUUID());
            recognitionLog.setCreateTime(new Date());
            recognitionLogs.set(i, recognitionLog);
        }
        int count = recognitionLogDao.saveBatch(recognitionLogs);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(RecognitionLogData data) {
                //
    }
    
    @Override
    public void update(RecognitionLog recognitionLog) {
        String name = recognitionLog.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        recognitionLog.setUpdateTime(new Date());
        int count = recognitionLogDao.update(recognitionLog);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = recognitionLogDao.deleteById(id);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }
    
    @Override
    public void deleteByIds(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            int count = recognitionLogDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(RecognitionLog recognitionLog) {
        int count = recognitionLogDao.delete(recognitionLog);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public RecognitionLog getById(String id) {
        return recognitionLogDao.getById(id);
    }

    @Override
    public RecognitionLog getData(RecognitionLog recognitionLog) {
        return recognitionLogDao.getData(recognitionLog);
    }
    
    @Override
    public void saveOrUpdate(RecognitionLog recognitionLog) {
        if (StringUtils.isEmpty(recognitionLog.getId())) {
            save(recognitionLog);
        } else {
            update(recognitionLog);
        }
    }

    @Override
    public IPage<RecognitionLog> query(final RecognitionLogQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<RecognitionLog>() {

            @Override
            public int count() {
                return recognitionLogDao.count(param);
            }

            @Override
            public List<RecognitionLog> query(int start, int end) {
                return recognitionLogDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<RecognitionLog> queryAll(RecognitionLogQueryParam param) {
		return recognitionLogDao.queryAll(param);
	}

	@Override
	public List<RecognitionLog> queryIpaddr() {
		return recognitionLogDao.queryIpaddr();
	}

	@Override
	public List<RecognitionLogData> queryReport(RecognitionLogQueryParam param) {
		return recognitionLogDao.queryReport(param);
	}

	@Override
	public File exists(String id) {
		File file = null;
		RecognitionLog log = recognitionLogDao.getById(id);
		if (log != null) {
			String filePath = log.getFilePath();
			file = new File(folder + File.separator + filePath);
			if (!file.exists()) {
				throw new IllegalArgumentException("文件不存在");
			}
		}
		return file;
	}
}