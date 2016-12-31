package com.grgbanking.fingervein.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IStyleDao;
import com.grgbanking.fingervein.data.StyleData;
import com.grgbanking.fingervein.entity.Style;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.StyleQueryParam;
import com.grgbanking.fingervein.service.IStyleService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("styleService")
public class StyleServiceImpl implements IStyleService {

	@Autowired
	private IStyleDao styleDao;

	@Override
	public void save(Style style) {
		String name = style.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("类别名称不能为空");
		}

		style.setId(UUIDGeneratorUtil.getUUID());
		style.setCreateTime(new Date());

		int count = styleDao.save(style);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<Style> styles) {
		Style style = null;
		for (int i = 0; i < styles.size(); i++) {
			style = styles.get(i);
			style.setId(UUIDGeneratorUtil.getUUID());
			style.setCreateTime(new Date());
			styles.set(i, style);
		}
		int count = styleDao.saveBatch(styles);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(StyleData data) {
		List<Style> styles = new ArrayList<Style>();
		Style style = null;
		String[] names = data.getName();
		String[] codes = data.getCode();

		for (int i = 0; i < names.length; i++) {
			style = new Style();
			style.setId(UUIDGeneratorUtil.getUUID());
			style.setName(names[i]);
			style.setCode(codes[i]);

			style.setCreateTime(new Date());
			style.setCreateBy(data.getCreateBy());
			styles.add(style);
		}
		int count = styleDao.saveBatch(styles);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		} //
	}

	@Override
	public void update(Style style) {
		String name = style.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("类别名称不能为空");
		}

		style.setUpdateTime(new Date());
		int count = styleDao.update(style);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = styleDao.deleteById(id);
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
			int count = styleDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(Style style) {
		int count = styleDao.delete(style);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public Style getById(String id) {
		return styleDao.getById(id);
	}

	@Override
	public Style getData(Style style) {
		return styleDao.getData(style);
	}

	@Override
	public void saveOrUpdate(Style style) {
		if (StringUtils.isEmpty(style.getId())) {
			save(style);
		} else {
			update(style);
		}
	}

	@Override
	public IPage<Style> query(final StyleQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<Style>() {

			@Override
			public int count() {
				return styleDao.count(param);
			}

			@Override
			public List<Style> query(int start, int end) {
				return styleDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<Style> queryAll(StyleQueryParam param) {
		return styleDao.queryAll(param);
	}
}