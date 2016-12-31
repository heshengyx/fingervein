package com.grgbanking.fingervein.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IUserDao;
import com.grgbanking.fingervein.data.UserData;
import com.grgbanking.fingervein.entity.User;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.UserQueryParam;
import com.grgbanking.fingervein.service.IUserService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public void save(User user) {
		String name = user.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("用户姓名不能为空");
		}
		String account = user.getAccount();
		if (StringUtils.isEmpty(account)) {
			throw new DataAccessResourceFailureException("用户账号不能为空");
		}
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			throw new DataAccessResourceFailureException("用户密码不能为空");
		}
		user.setId(UUIDGeneratorUtil.getUUID());
		user.setCreateTime(new Date());
		int count = userDao.save(user);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<User> users) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			user = users.get(i);
			user.setId(UUIDGeneratorUtil.getUUID());
			user.setCreateTime(new Date());
			users.set(i, user);
		}
		int count = userDao.saveBatch(users);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(UserData data) {
		//
	}

	@Override
	public void update(User user) {
		String name = user.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("监测点编号不能为空");
		}

		user.setUpdateTime(new Date());
		int count = userDao.update(user);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = userDao.deleteById(id);
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
			int count = userDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(User user) {
		int count = userDao.delete(user);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public User getById(String id) {
		return userDao.getById(id);
	}

	@Override
	public User getData(User user) {
		return userDao.getData(user);
	}

	@Override
	public void saveOrUpdate(User user) {
		if (StringUtils.isEmpty(user.getId())) {
			save(user);
		} else {
			update(user);
		}
	}

	@Override
	public IPage<User> query(final UserQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<User>() {

			@Override
			public int count() {
				return userDao.count(param);
			}

			@Override
			public List<User> query(int start, int end) {
				return userDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<User> queryAll(UserQueryParam param) {
		return userDao.queryAll(param);
	}
}