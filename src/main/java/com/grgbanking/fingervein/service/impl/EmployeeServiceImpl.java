package com.grgbanking.fingervein.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IEmployeeDao;
import com.grgbanking.fingervein.data.EmployeeData;
import com.grgbanking.fingervein.entity.Employee;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.EmployeeQueryParam;
import com.grgbanking.fingervein.service.IEmployeeService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		String name = employee.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("姓名不能为空");
		}

		employee.setId(UUIDGeneratorUtil.getUUID());
		employee.setCreateTime(new Date());
		int count = employeeDao.save(employee);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<Employee> employees) {
		Employee employee = null;
		for (int i = 0; i < employees.size(); i++) {
			employee = employees.get(i);
			employee.setId(UUIDGeneratorUtil.getUUID());
			employee.setCreateTime(new Date());
			employees.set(i, employee);
		}
		int count = employeeDao.saveBatch(employees);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(EmployeeData data) {
		//
	}

	@Override
	public void update(Employee employee) {
		String name = employee.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("终端名称不能为空");
		}

		employee.setUpdateTime(new Date());
		int count = employeeDao.update(employee);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = employeeDao.deleteById(id);
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
			int count = employeeDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(Employee employee) {
		int count = employeeDao.delete(employee);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public Employee getById(String id) {
		return employeeDao.getById(id);
	}

	@Override
	public Employee getData(Employee employee) {
		return employeeDao.getData(employee);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		if (StringUtils.isEmpty(employee.getId())) {
			save(employee);
		} else {
			update(employee);
		}
	}

	@Override
	public IPage<Employee> query(final EmployeeQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<Employee>() {

			@Override
			public int count() {
				return employeeDao.count(param);
			}

			@Override
			public List<Employee> query(int start, int end) {
				return employeeDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<Employee> queryAll(EmployeeQueryParam param) {
		return employeeDao.queryAll(param);
	}
}