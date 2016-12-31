package com.grgbanking.fingervein.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IFingerVeinDao;
import com.grgbanking.fingervein.data.FingerVeinData;
import com.grgbanking.fingervein.entity.FingerVein;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.FingerVeinQueryParam;
import com.grgbanking.fingervein.service.IFingerVeinService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("fingerVeinService")
public class FingerVeinServiceImpl implements IFingerVeinService {

	@Autowired
	private IFingerVeinDao fingerVeinDao;
	
	@Override
	public void save(FingerVein fingerVein) {
		fingerVein.setId(UUIDGeneratorUtil.getUUID());
		fingerVein.setCreateTime(new Date());

		int count = fingerVeinDao.save(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<FingerVein> fingerVeins) {
		FingerVein fingerVein = null;
		for (int i = 0; i < fingerVeins.size(); i++) {
			fingerVein = fingerVeins.get(i);
			fingerVein.setId(UUIDGeneratorUtil.getUUID());
			fingerVein.setCreateTime(new Date());
			fingerVeins.set(i, fingerVein);
		}
		int count = fingerVeinDao.saveBatch(fingerVeins);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(FingerVeinData data) {

	}

	@Override
	public void update(FingerVein fingerVein) {
		fingerVein.setUpdateTime(new Date());
		int count = fingerVeinDao.update(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = fingerVeinDao.deleteById(id);
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
			int count = fingerVeinDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(FingerVein fingerVein) {
		int count = fingerVeinDao.delete(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public FingerVein getById(String id) {
		return fingerVeinDao.getById(id);
	}

	@Override
	public FingerVein getData(FingerVein fingerVein) {
		return fingerVeinDao.getData(fingerVein);
	}

	@Override
	public void saveOrUpdate(FingerVein fingerVein) {
		if (StringUtils.isEmpty(fingerVein.getId())) {
			save(fingerVein);
		} else {
			update(fingerVein);
		}
	}

	@Override
	public IPage<FingerVein> query(final FingerVeinQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<FingerVein>() {

			@Override
			public int count() {
				return fingerVeinDao.count(param);
			}

			@Override
			public List<FingerVein> query(int start, int end) {
				return fingerVeinDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<FingerVein> queryAll(FingerVeinQueryParam param) {
		return fingerVeinDao.queryAll(param);
	}
}